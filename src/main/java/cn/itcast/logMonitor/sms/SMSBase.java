package cn.itcast.logMonitor.sms;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class SMSBase {
    private static Logger logger = Logger.getLogger(SMSBase.class);
    private static final String USER_ID = "wangsenfeng";
    private static final String PASSWORD = "wangsenfeng";

    public static boolean sendSms(String mobile, String content) {
        HttpURLConnection httpconn = null;
        String result = "";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("http://service.winic.org:8009/sys_port/gateway/index.asp?");
            //以下是参数
            sb.append("id=").append(URLEncoder.encode(USER_ID, "gb2312"));
            sb.append("&pwd=").append(PASSWORD);
            sb.append("&to=").append(mobile);
            sb.append("&content=").append(URLEncoder.encode(content, "gb2312"));
            sb.append("&time=").append("");

            URL url = new URL(sb.toString());
            httpconn = (HttpURLConnection) url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(httpconn.getInputStream()));
            result = rd.readLine();
            System.out.println("===================================="+result);
            rd.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpconn != null) {
                httpconn.disconnect();
            }
            httpconn = null;
        }
        if (StringUtils.isNotBlank(result)) {
            if (result.substring(0, 3).equals("000")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(sendSms("15652306418", "传智播客日志监控平台-系统1发生异常，需要处理！"));
//        String result = "000/Send:1/Consumption:.1/Tmoney:1.8/sid:1112144311751362";
//        if (StringUtils.isNotBlank(result)) {
//            if (result.substring(0, 3).equals("000")) {
//                System.out.println(true);
//            }
//        }
    }
}
