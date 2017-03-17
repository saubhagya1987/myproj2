package org.ireslab.notification;

import org.ireslab.notification.bean.MailUser;
import org.ireslab.notification.bean.SmsUser;
import org.ireslab.notification.service.MailService;
import org.ireslab.notification.service.SmsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// TODO: Auto-generated Javadoc
/**
 * The Class TestMail.
 */
public class TestMail {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create the application context
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");

		// Get the mailer instance
		MailService mailer = (MailService) context.getBean("mailService");
		SmsService smsSend = (SmsService) context.getBean("smsService");

		// create user bean

		MailUser user = new MailUser();
		user.setUserName("rajnish");
		user.setEmailAddress("rajnishkumar.dubey@ireslab.com");
		user.setTemplateName("mailTemplet.html");
		user.setSubject("Test eMail services ( spring + velocity )");

		// Send a composed mail
		mailer.sendEmail(user);

		SmsUser smsUser = new SmsUser();
		smsUser.setTextMessage("ok test mesage");
		smsUser.setUserMobileNumber("8801123467890");
		smsSend.sendSms(smsUser);

	}

}
