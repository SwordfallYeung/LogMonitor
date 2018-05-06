package cn.itcast.logMonitor.spout;

import org.apache.storm.spout.Scheme;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author y15079
 * @create 2018-05-06 23:34
 * @desc
 **/
public class StringScheme implements Scheme {
	Charset charset = Charset.forName("utf-8");

	public List<Object> deserialize(ByteBuffer byteBuffer) {
		try {
			return new Values(charset.decode(byteBuffer).toString());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public Fields getOutputFields() {
		return new Fields("line");
	}
}
