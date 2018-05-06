package cn.itcast.logMonitor.dao;

import cn.itcast.logMonitor.domain.App;
import cn.itcast.logMonitor.domain.Record;
import cn.itcast.logMonitor.domain.Rule;
import cn.itcast.logMonitor.domain.User;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;


/**
 * @author y15079
 * @create 2018-05-06 22:33
 * @desc
 **/
public class LogMonitorDao {
	private static Logger logger = Logger.getLogger(LogMonitorDao.class);
	private JdbcTemplate jdbcTemplate;

	public LogMonitorDao() {
		jdbcTemplate = new JdbcTemplate(DataSourceUtil.getDataSource());
	}

	/**
	 * 查询所有规则信息
	 *
	 * @return
	 */
	public List<Rule> getRuleList(){
		String sql = "SELECT `id`,`name`,`keyword`,`isValid`,`appId` FROM `log_monitor`.`log_monitor_rule` WHERE isValid =1";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Rule>(Rule.class));
	}

	/**
	 * 查询所有应用的信息
	 *
	 * @return
	 */
	public List<App> getAppList(){
		String sql = "SELECT `id`,`name`,`isOnline`,`typeId`,`userId`  FROM `log_monitor`.`log_monitor_app` WHERE isOnline =1";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<App>(App.class) );
	}

	/**
	 * 查询所有用户的信息
	 *
	 * @return
	 */
	public List<User> getUserList() {
		String sql = "SELECT `id`,`name`,`mobile`,`email`,`isValid` FROM `log_monitor`.`log_monitor_user` WHERE isValid =1";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
	}

	/**
	 * 插入触发规则的信息
	 *
	 * @param record
	 */
	public void saveRecord(Record record) {
		String sql = "INSERT INTO `log_monitor`.`log_monitor_rule_record`" +
				" (`appId`,`ruleId`,`isEmail`,`isPhone`,`isColse`,`noticeInfo`,`updataDate`) " +
				"VALUES ( ?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, record.getAppId(), record.getRuleId(), record.getIsEmail(), record.getIsPhone(), 0, record.getLine(), new Date());
	}

	public static void main(String[] args) {
		System.out.println("start.....");
		//测试数据库连接及相关方法是否正常
		LogMonitorDao logMonitorDao = new LogMonitorDao();
		//打印所有的规则信息
		List<Rule> rules = logMonitorDao.getRuleList();
		for (Rule rule:rules){
			System.out.println("rule:    "+rule);
		}
		System.out.println();
		System.out.println();
		//打印所有的应用信息
		List<App>  apps= logMonitorDao.getAppList();
		for (App app:apps){
			System.out.println("app:    "+app);
		}
		System.out.println();
		System.out.println();
		//打印所有的用户信息
		List<User> users= logMonitorDao.getUserList();
		for (User user:users){
			System.out.println("user:    "+user);
		}
		System.out.println("end.....");
	}
}
