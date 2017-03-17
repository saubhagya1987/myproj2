package org.ireslab.notification.service;

import org.ireslab.notification.bean.MailUser;

// TODO: Auto-generated Javadoc
/**
 * The Interface MailService.
 *
 * @author Pramoj
 * @Write Mail Service Class
 */

public interface MailService {

	 /**
 	 * Send email.
 	 *
 	 * @param user the user
 	 */
 	public void sendEmail(MailUser user);
}
