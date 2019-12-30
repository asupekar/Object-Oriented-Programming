package asupekar_hw2.vault;

import java.security.SecureRandom;

/**
 * Generates password as per requirement.
 * 
 * @author Aishwarya
 * @version 1.0
 */

public class PasswordGenerator {
	private static SecureRandom random = new SecureRandom();

	/** different dictionaries used */
	private static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String ALPHA_SMALL = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMERIC = "0123456789";
	private static final String SPECIAL_CHARS = "!@#$%^&";

	/**
	 * Method will generate random string based on the parameters
	 * 
	 * @param len the length of the random string
	 * @return the random password
	 */
	public static String generatePassword(int len) {
		StringBuilder result = new StringBuilder();
		int i = 0;
		while (i < len) {
			if (i < len) {
				int capsIndex = random.nextInt(ALPHA_CAPS.length());
				result.append(ALPHA_CAPS.charAt(capsIndex));
				i++;
			}

			if (i < len) {
				int smallIndex = random.nextInt(ALPHA_SMALL.length());
				result.append(ALPHA_SMALL.charAt(smallIndex));
				i++;
			}

			if (i < len) {
				int numIndex = random.nextInt(NUMERIC.length());
				result.append(NUMERIC.charAt(numIndex));
				i++;
			}

			if (i < len) {
				int specialIndex = random.nextInt(SPECIAL_CHARS.length());
				result.append(SPECIAL_CHARS.charAt(specialIndex));
				i++;
			}
		}

		return shuffleString(result.toString());
	}

	/**
	 * Is responsible for shuffling the string.
	 * 
	 * @param password String to be shuffled
	 * @return Shuffled String
	 */
	private static String shuffleString(String password) {
		char[] passwordArray = password.toCharArray();
		for (int i = 0; i < passwordArray.length; i++) {
			int randPos = random.nextInt(passwordArray.length);
			char tmp = passwordArray[i];
			passwordArray[i] = passwordArray[randPos];
			passwordArray[randPos] = tmp;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < passwordArray.length; i++) {
			sb.append(passwordArray[i]);
		}
		return sb.toString();
	}
}