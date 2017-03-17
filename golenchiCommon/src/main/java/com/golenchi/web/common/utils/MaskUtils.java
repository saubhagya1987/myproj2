package com.golenchi.web.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
//import java.util.Base64;

import org.springframework.stereotype.Component;

import com.golenchi.web.common.exception.BusinessException;
import com.golenchi.web.common.exception.SystemException;

@Component
public class MaskUtils {

	private static final String DIGEST_ALGORITHM = "SHA-256";
	private static final String DIGEST_512_ALGORITHM = "SHA-512";
	public static char NIBBLE_TO_CHAR[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	private static final int NO_OF_CAPS_ALPHA = 2;
	private static final int NO_OF_SMALL_ALPHA = 2;
	private static final int NO_OF_DIGITS = 3;
	private static final int NO_OF_SPLCHARS = 1;	
	private static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUM = "0123456789";
	private static final String SPL_CHARS = "!@/#$%^&)(*+,-.:;<=>?[]_{|}~`\"\\'";
	//private static final String SPL_CHARS = "/\"\\'";
	public static final int NO_OF_MAXCHARS = 10; 
	public static final int SECURITY_CODE_LENGTH = 6; 
 

	/**
	 * Generates and returns the random string.
	 * 
	 * Generated password must conform to following rules :- 1. Must be of
	 * specified length 2. Must contains atleast 1 UpperCase Character 3. Must
	 * contains atleast 1 Special Character from allowed list of characters 4.
	 * Must contains atleast 1 Numeric Character
	 * 
	 * @return
	 */
	public static String generateSecurityCode() {

		Integer codeLength = SECURITY_CODE_LENGTH;
		SecureRandom rnd = new SecureRandom();
		char[] securityCode = new char[codeLength];

		int index = 0;

		/*
		 * for (int i = 0; i < noOfCAPSAlpha; i++) { index = getNextIndex(rnd,
		 * passLength, securityCode); securityCode[index] =
		 * ALPHA_CAPS.charAt(rnd.nextInt(ALPHA_CAPS.length())); }
		 */
		for (int i = 0; i < codeLength; i++) {
			index = getNextIndex(rnd, codeLength, securityCode);
			securityCode[index] = NUM.charAt(rnd.nextInt(NUM.length()));
		}
		/*
		 * for (int i = 0; i < noOfSplChars; i++) { index = getNextIndex(rnd,
		 * passLength, securityCode); securityCode[index] =
		 * SPL_CHARS.charAt(rnd.nextInt(SPL_CHARS.length())); } for(int i = 0; i
		 * < passLength; i++) { if(securityCode[i] == 0) { securityCode[i] =
		 * ALPHA.charAt(rnd.nextInt(ALPHA.length())); } }
		 */
		return new String(securityCode);
	}

	public static String generateAutoPass() {
		
		SecureRandom rnd = new SecureRandom();
		Integer passLength = NO_OF_MAXCHARS;
		char[] tempPass = new char[passLength];

		int index = 0;

		for (int i = 0; i < NO_OF_CAPS_ALPHA; i++) {
			index = getNextIndex(rnd, passLength, tempPass);
			tempPass[index] = ALPHA_CAPS.charAt(rnd.nextInt(ALPHA_CAPS.length()));
		}
		for (int i = 0; i < NO_OF_DIGITS; i++) {
			index = getNextIndex(rnd, passLength, tempPass);
			tempPass[index] = NUM.charAt(rnd.nextInt(NUM.length()));
		}
		for (int i = 0; i < NO_OF_SPLCHARS; i++) {
			index = getNextIndex(rnd, passLength, tempPass);
			tempPass[index] = SPL_CHARS.charAt(rnd.nextInt(SPL_CHARS.length()));
		}
		for (int i = 0; i < NO_OF_SMALL_ALPHA; i++) {
			index = getNextIndex(rnd, passLength, tempPass);
			tempPass[index] = ALPHA.charAt(rnd.nextInt(ALPHA.length()));
		}
		for (int i = 0; i < passLength; i++) {
			if (tempPass[i] == 0) {
				tempPass[i] = ALPHA.charAt(rnd.nextInt(ALPHA.length()));
			}
		}
		return new String(tempPass);
	}

	public static String getDigest(byte[] bytes) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(DIGEST_ALGORITHM);
			return byteArrayToHexString(messageDigest.digest(bytes));
		} catch (NoSuchAlgorithmException exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
	public static String getDigest512(String text) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(DIGEST_512_ALGORITHM);
			messageDigest.update(text.getBytes());
			return convertByteToHex(messageDigest.digest());
		} catch (NoSuchAlgorithmException exception) {
			exception.printStackTrace();
		}
		return null;
	}

	public static String byteArrayToHexString(byte[] data) {
		StringBuffer buffer = new StringBuffer();

		if (data != null) {
			for (int i = 0; i < data.length; i++) {
				byte b = data[i];
				int I = ((char) b) & 0xFF;
				buffer.append(NIBBLE_TO_CHAR[I >>> 4]);
				buffer.append(NIBBLE_TO_CHAR[I & 0x0F]);

			}
		}
		return buffer.toString();
	}

	public static String generateRandomSalt() {

		byte[] bytes = new byte[16];
		SecureRandom secureRandom = new SecureRandom();
		bytes = secureRandom.generateSeed(16);

		return byteArrayToHexString(bytes);
	}

	public static String generateRandomSaltBySize() {

		byte[] bytes = new byte[3];
		SecureRandom secureRandom = new SecureRandom();
		bytes = secureRandom.generateSeed(3);

		return byteArrayToHexString(bytes);
	}

	public static String convertByteToHex(byte data[])
    {
        StringBuffer hexData = new StringBuffer();
        for (int byteIndex = 0; byteIndex < data.length; byteIndex++)
            hexData.append(Integer.toString((data[byteIndex] & 0xff) + 0x100, 16).substring(1));
        
        return hexData.toString();
    }
    
	/**
	 * Generates and returns the temporary password.
	 * 
	 * Generated password must conform to following rules :- 1. Must be of
	 * specified length 2. Must contains atleast 1 UpperCase Character 3. Must
	 * contains atleast 1 Special Character from allowed list of characters 4.
	 * Must contains atleast 1 Numeric Character
	 * 
	 * @return
	 */
	public static String generateTempPassword() {

		int noOfCAPSAlpha = 1;
		int noOfDigits = 1;
		int noOfSplChars = 1;
		int passLength = 8;

		SecureRandom rnd = new SecureRandom();
		char[] tempPass = new char[passLength];

		int index = 0;

		for (int i = 0; i < noOfCAPSAlpha; i++) {
			index = getNextIndex(rnd, passLength, tempPass);
			tempPass[index] = ALPHA_CAPS.charAt(rnd.nextInt(ALPHA_CAPS.length()));
		}
		for (int i = 0; i < noOfDigits; i++) {
			index = getNextIndex(rnd, passLength, tempPass);
			tempPass[index] = NUM.charAt(rnd.nextInt(NUM.length()));
		}
		for (int i = 0; i < noOfSplChars; i++) {
			index = getNextIndex(rnd, passLength, tempPass);
			tempPass[index] = SPL_CHARS.charAt(rnd.nextInt(SPL_CHARS.length()));
		}
		for (int i = 0; i < passLength; i++) {
			if (tempPass[i] == 0) {
				tempPass[i] = ALPHA.charAt(rnd.nextInt(ALPHA.length()));
			}
		}
		return new String(tempPass);
	}

	private static int getNextIndex(SecureRandom rnd, int len, char[] pswd) {

		int index = rnd.nextInt(len);

		while (pswd[index] != 0) {
			index = rnd.nextInt(len);
		}
		return index;
	}
/*
	public static void main(String[] args) throws IOException, ClassNotFoundException, BusinessException, SystemException {
		//String helloWorldInHex = "Tester@123";
		//System.out.println(helloWorldInHex + " hash : " + getDigest(MaskUtils.getDigest512(helloWorldInHex).getBytes()));
        //System.out.println("'HELLO WORLD' in HEX : " + helloWorldInHex);
        //System.out.println("Reconvert to String : " + fromString(helloWorldInHex));
   
	}
*/
	public static String toString( Serializable token ) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject(token);
        oos.close();
        return null;//Base64.getEncoder().encodeToString(baos.toByteArray()); 
    }
	public static Object fromString( String token )  throws BusinessException, SystemException, IOException, ClassNotFoundException {
		byte [] data = null;//Base64.getDecoder().decode(token);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
		Object o  = ois.readObject();
		ois.close();		
		return o;
	}

}
