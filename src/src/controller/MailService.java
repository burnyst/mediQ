package controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {
	private String host;
	private String user;
	private String port;
	
	public MailService() {
		this.host = "smtp.gmail.com";
		this.user = "mediqmaster";
		this.port = "465";
	}
	
	public void sendMail(String title, String content, String eamil) throws UnsupportedEncodingException, MessagingException {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", this.host);
		props.put("mail.smtp.user", this.user);
		props.put("mail.smtp.port", this.port);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", this.port);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		Authenticator auth = new MailAuthentication();
		Session session = Session.getDefaultInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		msg.setSentDate(new Date());
		msg.setFrom(new InternetAddress("mediqmaster@gmail.com"));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(eamil));
		msg.setSubject(title, "UTF-8");
		msg.setText(content, "UTF-8");
		msg.setHeader("content-Type", "text/html");
		Transport.send(msg);
	}
}
class MailAuthentication extends Authenticator {
	private PasswordAuthentication pa;
	public MailAuthentication() {
		String id = "mediqmaster";
		String pw = "jwqzpvhhjzfhcoyv";
		pa = new PasswordAuthentication(id, pw);
	}
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}