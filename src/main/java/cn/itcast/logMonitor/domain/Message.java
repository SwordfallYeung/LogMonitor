package cn.itcast.logMonitor.domain;

import java.io.Serializable;

/**
 * Describe: 请补充类描述
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 7241117393416877510L;
    private String appId;//消息所属服务器编号
    private String line;//消息内容
    private String ruleId;//规则编号
    private String keyword;//规则中的关键词
    private int isEmail;//是否已发送邮件
    private int isPhone;//是否已发送短信
    private String appName;//应用的名称

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getIsEmail() {
        return isEmail;
    }

    public void setIsEmail(int isEmail) {
        this.isEmail = isEmail;
    }

    public int getIsPhone() {
        return isPhone;
    }

    public void setIsPhone(int isPhone) {
        this.isPhone = isPhone;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "Message{" +
                "appId='" + appId + '\'' +
                ", line='" + line + '\'' +
                ", ruleId='" + ruleId + '\'' +
                ", keyword='" + keyword + '\'' +
                ", isEmail=" + isEmail +
                ", isPhone=" + isPhone +
                '}';
    }
}
