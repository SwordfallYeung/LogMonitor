package cn.itcast.logMonitor.mail;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * @author y15079
 * @create 2018-05-06 22:19
 * @desc
 **/
public class MessageSender {
	private static final Logger logger = Logger.getLogger(MessageSender.class);

	//发送邮件-邮件内容为文本格式
	public static boolean sendMail(MailInfo mailInfo) {
		try {
			Message mailMessage = generateBaseInfo(mailInfo);
			mailMessage.setText(mailInfo.getMailContent());// 设置邮件消息的主要内容
			Transport.send(mailMessage); // 发送邮件
			logger.info("【 TEXT 邮件发送完毕，成功时间： " + System.currentTimeMillis() + " 】");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//邮件内容为html格式
	public static boolean sendHtmlMail(MailInfo mailInfo) {
		try {
			Message mailMessage = generateBaseInfo(mailInfo);
			Multipart mainPart = new MimeMultipart();// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			BodyPart html = new MimeBodyPart();// 创建一个包含HTML内容的MimeBodyPart
			html.setContent(mailInfo.getMailContent(), "text/html; charset=utf-8");// 设置HTML内容
			mainPart.addBodyPart(html);
			mailMessage.setContent(mainPart);// 将MiniMultipart对象设置为邮件内容
			Transport.send(mailMessage);// 发送邮件
			logger.info("【 HTML 邮件发送完毕，成功时间： " + System.currentTimeMillis() + " 】");
			System.out.println("send ok!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Message generateBaseInfo(MailInfo mailInfo) throws Exception{
		// 判断是否需要身份认证
		MailAuthenticator authenticator = null;
		Properties props = mailInfo.getProperties();
		// 如果需要身份认证，则创建一个密码验证器
		if (mailInfo.isAuthValidate()){
			authenticator = new MailAuthenticator(mailInfo.getUserName(), mailInfo.getUserPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(props, authenticator);
		Message mailMessage = null;
		mailMessage = new MimeMessage(sendMailSession); // 根据session创建一个邮件消息
		Address from = new InternetAddress(mailInfo.getFromAddress(), mailInfo.getFromUserName()); // 创建邮件发送者地址
		mailMessage.setFrom(from);// 设置邮件消息的发送者
		if (mailInfo.getToAddress() != null && mailInfo.getToAddress().contains(",")){
			mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailInfo.getToAddress())); // Message.RecipientType.TO属性表示接收者的类型为TO
		}else {
			Address to = new InternetAddress(mailInfo.getToAddress()); //创建邮件的接收者地址，并设置到邮件消息中
			mailMessage.setRecipient(Message.RecipientType.TO, to); // Message.RecipientType.TO属性表示接收者的类型为TO
		}
		if (StringUtils.isNotBlank(mailInfo.getCcAddress())){
			if (mailInfo.getCcAddress().contains(",")){
				mailMessage.setRecipients(Message.RecipientType.CC, InternetAddress.parse(mailInfo.getCcAddress()));  // Message.RecipientType.CC属性表示接收者的类型为CC
			}else {
				Address cc = new InternetAddress(mailInfo.getCcAddress()); // 创建邮件的抄送者地址，并设置到邮件消息中
				mailMessage.setRecipient(Message.RecipientType.CC, cc); // Message.RecipientType.CC属性表示接收者的类型为CC
			}
		}
		mailMessage.setSubject(mailInfo.getMailSubject()); // 设置邮件消息的主题
		mailMessage.setSentDate(new Date()); // 设置邮件消息发送的时间
		return mailMessage;
	}
}
