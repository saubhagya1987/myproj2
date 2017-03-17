/*
 * 
 */
package org.ireslab.notification.serviceimpl;

import org.apache.log4j.Logger;
import org.ireslab.notification.bean.SmsUser;
import org.ireslab.notification.service.SmsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class Sms4bdServiceImpl.
 */

public class Sms4bdServiceImpl implements SmsService {

	/** The Log. */
	static Logger Log = Logger.getLogger(Sms4bdServiceImpl.class.getName());

	/** The smsbd url. */
	private String smsbdUrl;

	/** The public key. */
	private String publicKey;

	/** The private key. */
	private String privateKey;

	/** The sender. */
	private String sender;

	/** The delay. */
	private String delay;

	/** The type. */
	private String type;

	/*
	 * Send sms.
	 * 
	 * @see com.bcc.nea.serviceportal.service.SmsService#sendSms(com.bcc.nea.
	 * serviceportal.domain.User)
	 */
	@Override
	public void sendSms(SmsUser smsUser) {

		String mobilenumber = smsUser.getUserMobileNumber();
		String message = smsUser.getTextMessage();
		StringBuilder smsOutGoingUrl = new StringBuilder();

		String smsUrl = smsOutGoingUrl.append(smsbdUrl).append("?").append("publickey=" + publicKey)
				.append("&privatekey=" + privateKey).append("&sender=" + sender).append("&receiver=" + mobilenumber)
				.append("&message=" + message).append("&delay=" + delay).append("&type=" + type).toString();

		RestTemplate restTemplate = new RestTemplate();
		System.out.print("url--" + smsOutGoingUrl);
		try {

			ResponseEntity<String> response = restTemplate.getForEntity(smsUrl, String.class);
			Log.debug("Send Message Response Code:   " + response.getStatusCode() + "   Response Message   :  "
					+ response.getBody());

		} catch (Exception ex) {
			Log.error(" error : " + ex.getLocalizedMessage());

		}

	}

	/**
	 * Gets the public key.
	 *
	 * @return the public key
	 */
	public String getPublicKey() {
		return publicKey;
	}

	/**
	 * Sets the public key.
	 *
	 * @param publicKey
	 *            the new public key
	 */
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	/**
	 * Gets the private key.
	 *
	 * @return the private key
	 */
	public String getPrivateKey() {
		return privateKey;
	}

	/**
	 * Sets the private key.
	 *
	 * @param privateKey
	 *            the new private key
	 */
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	/**
	 * Gets the sender.
	 *
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * Sets the sender.
	 *
	 * @param sender
	 *            the new sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * Gets the delay.
	 *
	 * @return the delay
	 */
	public String getDelay() {
		return delay;
	}

	/**
	 * Sets the delay.
	 *
	 * @param delay
	 *            the new delay
	 */
	public void setDelay(String delay) {
		this.delay = delay;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the smsbd url.
	 *
	 * @return the smsbd url
	 */
	public String getSmsbdUrl() {
		return smsbdUrl;
	}

	/**
	 * Sets the smsbd url.
	 *
	 * @param smsbdUrl
	 *            the new smsbd url
	 */
	public void setSmsbdUrl(String smsbdUrl) {
		this.smsbdUrl = smsbdUrl;
	}

}
