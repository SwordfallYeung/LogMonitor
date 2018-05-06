package cn.itcast.logMonitor.bolt;

import cn.itcast.logMonitor.domain.Message;
import cn.itcast.logMonitor.domain.Record;
import cn.itcast.logMonitor.utils.MonitorHandler;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

/**
 * @author y15079
 * @create 2018-05-06 23:13
 * @desc 将触发信息发送邮件或短息，并保存到mysql数据库中
 * //BaseRichBolt 需要手动调ack方法，BaseBasicBolt由storm框架自动调ack方法
 **/
public class PrepareRecordBolt extends BaseBasicBolt{
	private static Logger logger = Logger.getLogger(PrepareRecordBolt.class);

	@Override
	public void execute(Tuple input, BasicOutputCollector basicOutputCollector) {
		Message message = (Message) input.getValueByField("message");
		String appId = input.getStringByField("appId");
		//将触发规则的信息进行通知
		MonitorHandler.notifly(appId, message);
		Record record = new Record();
		try {
			BeanUtils.copyProperties(record,message);
			basicOutputCollector.emit(new Values(record));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
		outputFieldsDeclarer.declare(new Fields("record"));
	}
}
