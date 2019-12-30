package asupekar_hw2.vault;
/**
 * This program implements adding a new user, adding new site, retrieving site password and 
 * updating site password
 * 
 * @author Aishwarya
 */

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import asupekar_hw2.encrypt.CaesarCipher;
import asupekar_hw2.exceptions.DuplicateSiteException;
import asupekar_hw2.exceptions.DuplicateUserException;
import asupekar_hw2.exceptions.InvalidPasswordException;
import asupekar_hw2.exceptions.InvalidSiteException;
import asupekar_hw2.exceptions.InvalidUsernameException;
import asupekar_hw2.exceptions.PasswordMismatchException;
import asupekar_hw2.exceptions.SiteNotFoundException;
import asupekar_hw2.exceptions.UserLockedOutException;
import asupekar_hw2.exceptions.UserNotFoundException;

public class PasswordVault implements Vault {

	private static SecureRandom random = new SecureRandom();
	private static final int minPasswordLength = 6;
	private static final int maxPasswordLength = 15;

	// Stores username as a key and password, site details as value
	private static Map<String, UserSiteMapping> userMap;

	// Reference to ceaser cipher object
	private CaesarCipher cipher;

	public PasswordVault() {
		userMap = new HashMap<>();
		cipher = new CaesarCipher();
	}

	/**
	 * Adds a new user to the vault
	 * 
	 * @param username unique username for the user
	 * @param password for the user account
	 */
	@Override
	public void addNewUser(String username, String password)
			throws InvalidUsernameException, InvalidPasswordException, DuplicateUserException {

		if (ValidationUtil.isValidUsername(username)) {
			if (ValidationUtil.isValidPassword(password)) {
				if (!userMap.containsKey(username)) {
					userMap.put(username, new UserSiteMapping(cipher.encrypt(password), null));
				} else {
					throw new DuplicateUserException(username + " username already exists.Please try a new one.");
				}
			} else {
				increaseRetryCount(username);
				throw new InvalidPasswordException("Password does not meet requirements for user: " + username);
			}
		} else {
			throw new InvalidUsernameException("Username does not meet required expectations for user: " + username);
		}
	}

	/**
	 * Adds a new site to the vault
	 * 
	 * @param username unique username for the user
	 * @param password for the user account
	 * @sitename name of the website for the user
	 * @return plain text password for the site
	 */
	@Override
	public String addNewSite(String username, String password, String sitename) throws DuplicateSiteException,
			UserNotFoundException, UserLockedOutException, PasswordMismatchException, InvalidSiteException {

		String sitepassword = null;

		if (userMap.containsKey(username)) {
			if (!isLockedUser(username)) {
				if (cipher.decrypt(userMap.get(username).getUserPassword()).equals(password)) {

					// Validate sitename
					if (ValidationUtil.isValidSitename(sitename)) {

						UserSiteMapping mapping = userMap.get(username);

						Map<String, String> siteMap = mapping.getSiteMap();
						if (siteMap != null) {
							if (siteMap.containsKey(sitename)) {
								throw new DuplicateSiteException("This site exists for this username ");
							}
						} else {
							siteMap = new HashMap<>();

						}

						sitepassword = generateRandomSitePassword();
						// Encrypt and store the sitepassword
						String encryptedPassword = cipher.encrypt(sitepassword);
						siteMap.put(sitename, encryptedPassword);
						mapping.setSiteMap(siteMap);
					} else {
						throw new InvalidSiteException("Site name does not match required expectations");
					}
				} else {
					increaseRetryCount(username);
					throw new PasswordMismatchException("Entered password does not match with original password");
				}
			} else {
				throw new UserLockedOutException("User is locked because of 3 wrong operations");
			}
		} else {
			throw new UserNotFoundException("Username " + username + " not found");
		}

		return sitepassword;
	}

	/**
	 * Update the site password in the vault
	 * 
	 * @param username unique username for the user
	 * @param password for the user account
	 * @sitename name of the website for which password has to be updated
	 * @return plain text updated password for the site
	 */
	@Override
	public String updateSitePassword(String username, String password, String sitename)
			throws SiteNotFoundException, UserNotFoundException, UserLockedOutException, PasswordMismatchException {
		String updatedSitePassword = null;
		if (userMap.containsKey(username)) {
			if (!isLockedUser(username)) {
				if (cipher.decrypt(userMap.get(username).getUserPassword()).equals(password)) {

					UserSiteMapping mapping = userMap.get(username);

					Map<String, String> siteMap = mapping.getSiteMap();
					if (siteMap != null) {
						if (siteMap.containsKey(sitename)) {
							updatedSitePassword = generateRandomSitePassword();
						} else {
							throw new SiteNotFoundException("Given site does not exist");
						}
					} else {
						throw new SiteNotFoundException("Given site does not exist.");
					}

					// Encrypt and store the sitepassword
					String encryptedPassword = cipher.encrypt(updatedSitePassword);
					siteMap.put(sitename, encryptedPassword);
					mapping.setSiteMap(siteMap);
				} else {
					increaseRetryCount(username);
					throw new PasswordMismatchException("Entered password does not match with original password");
				}
			} else {
				throw new UserLockedOutException("User is locked because of 3 wrong operations");
			}
		} else {
			throw new UserNotFoundException("Username " + username + " not found");
		}
		return updatedSitePassword;
	}

	/**
	 * Gets the site decrypted password from the vault
	 * 
	 * @param username unique username for the user
	 * @param password for the user account
	 * @sitename name of the website for the user
	 * @return plain text password for the site
	 */
	@Override
	public String retrieveSitePassword(String username, String password, String sitename)
			throws SiteNotFoundException, UserNotFoundException, UserLockedOutException, PasswordMismatchException {

		String sitePassword = null;
		if (userMap.containsKey(username)) {
			if (!isLockedUser(username)) {
				if (cipher.decrypt(userMap.get(username).getUserPassword()).equals(password)) {
	
					UserSiteMapping mapping = userMap.get(username);
	
					Map<String, String> siteMap = mapping.getSiteMap();
					if (siteMap != null) {
						if (siteMap.containsKey(sitename)) {
							sitePassword = cipher.decrypt(siteMap.get(sitename));
						} else {
							throw new SiteNotFoundException("Given site does not exist");
						}
					} else {
						throw new SiteNotFoundException("Given site does not exist");
					}
				} else {
					increaseRetryCount(username);
					throw new PasswordMismatchException("Entered password does not match with original password");
				}
			}else {
				throw new UserLockedOutException("User is locked because of 3 wrong operations");
			}
		} else {
			throw new UserNotFoundException("Username " + username + " not found");
		}
		return sitePassword;
	}

	/**
	 * Generates random string password
	 * 
	 * @return password
	 */
	private String generateRandomSitePassword() {
		int passwordLength = random.nextInt(maxPasswordLength - minPasswordLength + 1) + minPasswordLength;
		return PasswordGenerator.generatePassword(passwordLength);
	}

	/**
	 * Mapping between sitename and sitepassword
	 */
	private static class UserSiteMapping {
		private String userPassword;
		private int retryCount;
		private Map<String, String> siteMap;

		public UserSiteMapping(String userPassword, Map<String, String> siteMap) {
			this.userPassword = userPassword;
			this.siteMap = siteMap;
		}

		public String getUserPassword() {
			return userPassword;
		}

		public Map<String, String> getSiteMap() {
			return siteMap;
		}

		public void setSiteMap(Map<String, String> siteMap) {
			this.siteMap = siteMap;
		}

		public void setRetryCount(int retryCount) {
			this.retryCount = retryCount;
		}
	}

	/**
	 * Checks whether a user is locked out
	 * @param username
	 * @return true if locked false otherwise
	 */
	private static boolean isLockedUser(String username) {
		// TODO Auto-generated method stub
		UserSiteMapping mapping = userMap.get(username);
		if (mapping.retryCount < 3) {
			return false;
		}
		return true;
	}

	/**
	 * Increments the retryCount for a user with wrong password attempt
	 * @param username
	 */
	private void increaseRetryCount(String username) {
		UserSiteMapping mapping = userMap.get(username);
		mapping.setRetryCount(mapping.retryCount++);

		userMap.put(username, mapping);
	}
}