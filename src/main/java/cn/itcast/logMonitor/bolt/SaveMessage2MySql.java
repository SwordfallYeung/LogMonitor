package cn.itcast.logMonitor.bolt;

import cn.itcast.logMonitor.domain.Record;
import cn.itcast.logMonitor.utils.MonitorHandler;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.log4j.Logger;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Tuple;

/**
 * @author y15079
 * @create 2018-05-06 23:20
 * @desc
 **/
public class SaveMessage2MySql extends BaseBasicBolt{
	private static Logger logger = Logger.getLogger(SaveMessage2MySql.class);

	@Override
	public void execute(Tuple input, BasicOutputCollector basicOutputCollector) {
		Record record = (Record) input.getValueByField("record");
		MonitorHandler.save(record);
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

	}
}
