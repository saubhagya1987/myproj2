package org.ireslab.notification.service;

import org.ireslab.notification.bean.SmsUser;

// TODO: Auto-generated Javadoc
/**
 * The Interface SmsService.
 */
public interface SmsService {

	/**
	 * Send sms.
	 *
	 * @param user
	 *            the user
	 * @throws BccException
	 *             the bcc exception
	 */
	public void sendSms(SmsUser smsUser);
}
