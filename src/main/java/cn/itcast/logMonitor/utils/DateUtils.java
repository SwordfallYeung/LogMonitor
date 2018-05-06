package cn.itcast.logMonitor.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**
     * 根据 formatter格式返回系统日期
     *
     * @param formatter
     * @return
     */
    public static String getDateTime(String formatter) {
        SimpleDateFormat df = new SimpleDateFormat(formatter);
        return df.format(new Date());
    }

    public static String getDateTime() {
        return DateUtils.getDateTime("yyyy-MM-dd HH:mm:ss");
    }

    public static String getDate() {
        return DateUtils.getDateTime("yyyy-MM-dd");
    }

    public static String getDate(String formatter) {
        return DateUtils.getDateTime(formatter);
    }

    public static String removeTime(String dateTime) {
        return dateTime.substring(0, dateTime.indexOf(" "));
    }

    /**
     * 获取指定时间之前minute的时间  例如:minute = 30, 2014-07-15 12:00:00 ->  2014-07-15 11:30:00
     * @param time
     * @return
     */
    public static String getBeforeMinute(String time, int minute){
        String result = time;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date myDate = formatter.parse( time );
            Calendar c = Calendar.getInstance();
            c.setTime(myDate);
            c.add(Calendar.MINUTE, -minute);
            myDate = c.getTime();
            result = formatter.format(myDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 截取日期 yyyyMMdd
     *
     * @param date
     * @return
     */
    public static String splitDate(String date) {
        return date.substring(0, date.indexOf(" ")).replace("-", "");
    }

    /**
     * 替换{}中的变量
     *
     * @param data
     * @param key
     * @param newData
     * @return
     */
    public static String replaceParentheses(String data, String key, String newData) {
        return data.replaceAll("\\{" + key + "\\}", newData);
    }

    public static String replaceParentheses(String data, String key) {
        return data.replaceAll("\\{" + key + "\\}", "");
    }

    /**
     * 格式化double，不使用科学计数法
     *
     * @param doubleValue
     * @param fractionDigits
     * @return
     */
    public static String formatDouble(String doubleValue, int fractionDigits) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(fractionDigits);
        return nf.format(Double.parseDouble(doubleValue));
    }

    public static String formatDouble(double doubleValue, int fractionDigits) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(fractionDigits);
        return nf.format(doubleValue);
    }

    public static String formatDouble(String doubleValue) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(2);
        return nf.format(Double.parseDouble(doubleValue));
    }

    public static String formatDouble(double doubleValue) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(2);
        return nf.format(doubleValue);
    }

    public static String getInt(Object str) {
        return Integer.toString(Integer.parseInt(str.toString().replaceAll("\\.\\d+", "")));
    }

    public static String getYesterday(String formatter) {
        SimpleDateFormat df = new SimpleDateFormat(formatter);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return df.format(calendar.getTime());
    }

    public static void main(String[] args) {
        System.out.print(getDate());
    }


}
