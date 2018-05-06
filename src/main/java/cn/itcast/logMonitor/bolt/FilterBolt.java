package cn.itcast.logMonitor.bolt;

import cn.itcast.logMonitor.domain.Message;
import cn.itcast.logMonitor.utils.MonitorHandler;
import org.apache.log4j.Logger;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;


/**
 * @author y15079
 * @create 2018-05-06 18:22
 * @desc 过滤规则信息
 *
 * BaseRichBolt 需要手动调ack方法，BaseBasicBolt由storm框架自动调ack方法
 **/
public class FilterBolt extends BaseBasicBolt{
	private static Logger logger = Logger.getLogger(FilterBolt.class);

	@Override
	public void execute(Tuple input, BasicOutputCollector basicOutputCollector) {
		//获取KafkaSpout发送出来的数据
		String line = input.getString(0);
		//获取kafka发送的数据，是一个byte数组
		//byte[] value = (byte[]) input.getValue(0);
		//将数组转化成字符串
		//String line = new String(value);
		//对数据进行解析
		//  appid   content
		//1  error: Caused by: java.lang.NoClassDefFoundError: com/starit/gejie/dao/SysNameDao

		//把line转换为Message对象
		Message message = MonitorHandler.parser(line);
		if (message == null){
			return;
		}
		//对日志message进行规制判定，看看是否触发规则
		if (MonitorHandler.trigger(message)){
			basicOutputCollector.emit(new Values(message.getAppId(), message));
		}
		//定时更新规则信息
		MonitorHandler.scheduleLoad();
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
		outputFieldsDeclarer.declare(new Fields("appId", "message"));
	}
}
