package cn.itcast.logMonitor.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author y15079
 * @create 2018-05-06 22:14
 * @desc
 **/
public class MailAuthenticator extends Authenticator {
	String userName;
	String userPassword;

	public MailAuthenticator() {
		super();
	}

	public MailAuthenticator(String user, String pwd) {
		this.userName = user;
		this.userPassword = pwd;
	}

	public PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(userName, userPassword);
	}
}
