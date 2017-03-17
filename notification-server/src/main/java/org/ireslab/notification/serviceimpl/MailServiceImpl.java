package org.ireslab.notification.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.ireslab.notification.bean.MailConfig;
import org.ireslab.notification.bean.MailUser;
import org.ireslab.notification.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class MailServiceImpl.
 *
 * @author Pramoj
 * @Write Mail Service impl Class
 */

@Service("mailService")
public class MailServiceImpl implements MailService {

	/** The mail sender. */
	@Autowired
	private JavaMailSender mailSender;

	/** The velocity engine. */
	@Autowired
	private VelocityEngine velocityEngine;

	/** The mail config. */
	@Autowired
	private MailConfig mailConfig;

	/*
	 * Send email.
	 * 
	 * @see org.ireslab.notification.service.MailService#sendEmail(org.ireslab.
	 * notification.bean.MailUser)
	 */
	public void sendEmail(MailUser user) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);

				message.setFrom(mailConfig.getFromMailId());
				message.setTo(user.getEmailAddress());

				if (user.getSubject() != null)
					message.setSubject(user.getSubject());

				if (user.getCcMailList() != null)
					message.setCc(user.getCcMailList());
				else if (user.getCcMailId() != null)
					message.setCc(user.getCcMailId());

				if (user.getBccMailList() != null)
					message.setBcc(user.getBccMailList());
				else if (user.getBccMailId() != null && !"false".equalsIgnoreCase(user.getBccMailId()))
					message.setBcc(user.getBccMailId());

				Map<String, Object> model = new HashMap<String, Object>();
				model.put("user", user);

				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, user.getTemplateName(),
						"UTF-8", model);
				message.setText(text, true);

			}
		};

		mailSender.send(preparator);
	}

}
