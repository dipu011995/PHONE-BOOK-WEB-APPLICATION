package com.pk.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
/**
 * This class is to perform Java Mail operation
 * 
 * @author Pankaj Kumar
 *
 */

@Component
public class MailUtils {

	@Autowired
	public JavaMailSender  jms;


	/**
	 * This method is to send mail
	 * @param to
	 * @param subject
	 * @param body
	 */
	public void sendMail(String to, String subject, String body) {
		SimpleMailMessage msg = new SimpleMailMessage(); 
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(body);
		
		jms.send(msg);
	}

}
