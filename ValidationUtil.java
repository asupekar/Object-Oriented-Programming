package asupekar_hw2.vault;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class implements the validation for password and sitename.
 * 
 * @author Aishwarya
 * @version 1.0
 */

public class ValidationUtil {

	private static final Set<Character> specialCharacterSet = new HashSet<>(
			Arrays.asList('!', '@', '#', '$', '%', '^', '&'));
	private static final String regex = "[a-z]+";

	/**
	 * Checks whether password satisfies the given constraints
	 * @param password vault/site password
	 * @return true if valid password
	 */
	public static boolean isValidPassword(String password) {
		if (password.length() < 6 || password.length() > 15) {
			return false;
		}

		if (!hasOneDigitOneLetter(password)) {
			return false;
		}

		if (!hasSpecialCharacter(password)) {
			return false;
		}

		return true;
	}

	/**
	 * Checks whether username satisfies the given constraints
	 * @param username vault/site username
	 * @return true if valid username
	 */
	public static boolean isValidUsername(String username) {
		return isValidName(username);
	}

	/**
	 * Checks whether sitename satisfies the given constraints
	 * @param username vault/site sitename
	 * @return true if valid sitename
	 */
	public static boolean isValidSitename(String sitename) {
		return isValidName(sitename);
	}

	/**
	 * Generic method to check username/sitename requirements
	 * @param name
	 * @return true if a valid name
	 */
	private static boolean isValidName(String name) {
		if (name.length() < 6 || name.length() > 12) {
			return false;
		}

		return name.matches(regex);
	}

	/**
	 * Checks if password has atleast one digit
	 * @param password
	 * @return true if password has atleast one digit
	 */
	private static boolean hasOneDigitOneLetter(String password) {
		boolean foundDigit = false;
		boolean foundLetter = false;
		for (int i = 0; i < password.length(); ++i) {
			char c = password.charAt(i);
			if (Character.isDigit(c)) {
				foundDigit = true;
			} else if (Character.isLetter(c)) {
				foundLetter = true;
			}
		}
		return foundDigit && foundLetter;
	}

	/**
	 * Checks if password has atleast one special character
	 * @param password
	 * @return true if password has atleast one special character
	 */
	private static boolean hasSpecialCharacter(String password) {
		boolean hasSpecialCharacter = false;
		for (int i = 0; i < password.length(); ++i) {
			char c = password.charAt(i);
			if (specialCharacterSet.contains(c)) {
				hasSpecialCharacter = true;
				break;
			}
		}
		return hasSpecialCharacter;
	}
}