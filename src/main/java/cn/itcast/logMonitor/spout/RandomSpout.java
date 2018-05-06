package cn.itcast.logMonitor.spout;

import org.apache.storm.spout.Scheme;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author y15079
 * @create 2018-05-06 23:26
 * @desc 随机产生消息发送出去
 **/
public class RandomSpout extends BaseRichSpout {
	private SpoutOutputCollector collector;
	private TopologyContext context;
	private List list ;
	private final Scheme scheme;

	public RandomSpout(final Scheme scheme) {
		super();
		this.scheme = scheme;
	}

	public void open(Map conf, TopologyContext context,
					 SpoutOutputCollector collector) {
		this.context = context;
		this.collector = collector;
		list = new ArrayList();
		list.add("1$$$$$error: Caused by: java.lang.NoClassDefFoundError: com/starit/gejie/dao/SysNameDao");
		list.add("2$$$$$java.sql.SQLException: You have an error in your SQL syntax;");
		list.add("1$$$$$error Unable to connect to any of the specified MySQL hosts.");
		list.add("1$$$$$error:Servlet.service() for servlet action threw exception java.lang.NullPointerException");
		list.add("1$$$$$error:Exception in thread main java.lang.ArrayIndexOutOfBoundsException: 2");
		list.add("1$$$$$error:NoSuchMethodError: com/starit/.");
		list.add("2$$$$$error:java.lang.NoClassDefFoundError: org/coffeesweet/test01/Test01");
		list.add("1$$$$$error:java.lang.NoClassDefFoundError: org/coffeesweet/test01/Test01");
		list.add("1$$$$$error:Java.lang.IllegalStateException");
		list.add("1$$$$$error:Java.lang.IllegalMonitorStateException");
		list.add("1$$$$$error:Java.lang.NegativeArraySizeException");
		list.add("2$$$$$error:java.sql.SQLException: You have an error in your SQL syntax;");
		list.add("1$$$$$error:Java.lang.TypeNotPresentException ");
		list.add("1$$$$$error:Java.lang.UnsupprotedOperationException ");
		list.add("1$$$$$error Java.lang.IndexOutOfBoundsException");
		list.add("1$$$$$error Java.lang.ClassNotFoundException");
		list.add("2$$$$$error java.lang.ExceptionInInitializerError ");
		list.add("1$$$$$error:java.lang.IncompatibleClassChangeError ");
		list.add("1$$$$$error:java.lang.LinkageError ");
		list.add("1$$$$$error:java.lang.OutOfMemoryError ");
		list.add("1$$$$$error java.lang.StackOverflowError");
		list.add("2$$$$$error: java.lang.UnsupportedClassVersionError");
		list.add("1$$$$$error java.lang.ClassCastException");
		list.add("1$$$$$error: java.lang.CloneNotSupportedException");
		list.add("1$$$$$error: java.lang.EnumConstantNotPresentException ");
		list.add("1$$$$$error java.lang.IllegalMonitorStateException ");
		list.add("2$$$$$error java.lang.IllegalStateException ");
		list.add("1$$$$$error java.lang.IndexOutOfBoundsException ");
		list.add("1$$$$$error java.lang.NumberFormatException ");
		list.add("1$$$$$error java.lang.RuntimeException ");
		list.add("1$$$$$error java.lang.TypeNotPresentException ");
		list.add("2$$$$$error MetaSpout.java:9: variable i might not have been initialized");
		list.add("1$$$$$error MyEvaluator.java:1: class Test1 is public, should be declared in a file named Test1.java ");
		list.add("1$$$$$error Main.java:5: cannot find symbol ");
		list.add("1$$$$$error NoClassDefFoundError: asa wrong name: ASA ");
		list.add("1$$$$$error Test1.java:54: 'void' type not allowed here");
		list.add("2$$$$$error Test5.java:8: missing return statement");
		list.add("1$$$$$error:Next.java:66: cannot find symbol ");
		list.add("1$$$$$error symbol  : method createTempFile(java.lang.String,java.lang.String,java.lang.String) ");
		list.add("1$$$$$error invalid method declaration; return type required");
		list.add("1$$$$$error array required, but java.lang.String found");
		list.add("2$$$$$error Exception in thread main java.lang.NumberFormatException: null 20. .");
		list.add("1$$$$$error non-static method cannot be referenced from a static context");
		list.add("1$$$$$error Main.java:5: non-static method fun1() cannot be referenced from a static context");
		list.add("1$$$$$error continue outside of  loop");
		list.add("1$$$$$error MyAbstract.java:6: missing method body, or declare abstract");
		list.add("2$$$$$error Main.java:6: Myabstract is abstract; cannot be instantiated");
		list.add("1$$$$$error MyInterface.java:2: interface methods cannot have body ");
		list.add("1$$$$$error Myabstract is abstract; cannot be instantiated");
		list.add("1$$$$$error asa.java:3: modifier static not allowed here");
		list.add("1$$$$$error possible loss of precision  found: long required:byte  var=varlong");
		list.add("2$$$$$error  java.lang.NegativeArraySizeException ");
		list.add("1$$$$$error java.lang.ArithmeticException:  by zero");
		list.add("1$$$$$error java.lang.ArithmeticException");
		list.add("1$$$$$error java.lang.ArrayIndexOutOfBoundsException");
		list.add("1$$$$$error java.lang.ClassNotFoundException");
		list.add("2$$$$$error java.lang.IllegalArgumentException");
		list.add("1$$$$$error fatal error C1010: unexpected end of file while looking for precompiled header directive");
		list.add("1$$$$$error fatal error C1083: Cannot open include file: R…….h: No such file or directory");
		list.add("1$$$$$error C2011:C……clas type redefinition");
		list.add("1$$$$$error C2018: unknown character 0xa3");
		list.add("2$$$$$error C2057: expected constant expression");
		list.add("1$$$$$error C2065: IDD_MYDIALOG : undeclared identifier IDD_MYDIALOG");
		list.add("1$$$$$error C2082: redefinition of formal parameter bReset");
		list.add("1$$$$$error C2143: syntax error: missing : before  ");
		list.add("1$$$$$error C2146: syntax error : missing ';' before identifier dc");
		list.add("2$$$$$error C2196: case value '69' already used");
		list.add("1$$$$$error C2509: 'OnTimer' : member function not declared in 'CHelloView'");
		list.add("1$$$$$error C2555: 'B::f1': overriding virtual function differs from 'A::f1' only by return type or calling convention");
		list.add("1$$$$$error C2511: 'reset': overloaded member function 'void (int)' not found in 'B'");
		list.add("1$$$$$error C2660: 'SetTimer' : function does not take 2 parameters");
		list.add("2$$$$$error warning C4035: 'f……': no return value");
		list.add("1$$$$$error warning C4553: '= =' : operator has no effect; did you intend '='");
		list.add("1$$$$$error C4716: 'CMyApp::InitInstance' : must return a value");
		list.add("1$$$$$error LINK : fatal error LNK1168: cannot open Debug/P1.exe for writing");
		list.add("1$$$$$error LNK2001: unresolved external symbol public: virtual _ _thiscall C (void)");
		list.add("2$$$$$error java.lang.IllegalArgumentException: Path index.jsp does not start with");
		list.add("1$$$$$error org.apache.struts.action.ActionServlet.process(ActionServlet.java:148");
		list.add("1$$$$$error org.apache.jasper.JasperException: Exception in JSP");
		list.add("1$$$$$error The server encountered an internal error () that prevented it from fulfilling this request");
		list.add("1$$$$$error org.apache.jasper.servlet.JspServletWrapper.handleJspException(JspServletWrapper.java:467");
		list.add("2$$$$$error javax.servlet.http.HttpServlet.service(HttpServlet.java:803)");
		list.add("1$$$$$error javax.servlet.jsp.JspException: Cannot find message resources under key org.apache.struts.action.MESSAGE");
		list.add("1$$$$$error Stacktrace:  org.apache.jasper.servlet.JspServletWrapper.handleJspException(JspServletWrapper.java:467)");
		list.add("1$$$$$error javax.servlet.ServletException: Cannot find bean org.apache.struts.taglib.html.BEAN in any scope");
		list.add("1$$$$$error no data found");
		list.add("2$$$$$error exception in thread main org.hibernate.MappingException: Unknown entity:.");
		list.add("1$$$$$error using namespace std;");
		list.add("1$$$$$error C2065: 'cout' : undeclared identifier");
		list.add("1$$$$$error main already defined in aaa.obj");
		list.add("1$$$$$error syntax error : missing ';' before '}'");
		list.add("2$$$$$error cout : undeclared identifier");
		list.add("1$$$$$error weblogic.servlet.internal.WebAppServletContext$ServletInvocationAction.run(WebAp ");
		list.add("1$$$$$error Caused by: java.lang.reflect.InvocationTargetException");
		list.add("1$$$$$error Caused by: java.lang.NoClassDefFoundError: com/starit/gejie/dao/SysNameDao");
		list.add("1$$$$$error at com.starit.gejie.Util.Trans.BL_getSysNamesByType(Trans.java:220)");

	}

	/**
	 * 发送消息
	 */
	public void nextTuple() {
		final Random rand = new Random();
		String msg = list.get(rand.nextInt(90)).toString();
		this.collector.emit(this.scheme.deserialize(ByteBuffer.wrap(msg.getBytes())));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void declareOutputFields(final OutputFieldsDeclarer declarer) {
		declarer.declare(this.scheme.getOutputFields());
	}
}
