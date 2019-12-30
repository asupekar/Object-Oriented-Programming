package asupekar_hw2.encrypt;

/**
 * To implement encryption and decryption of the password
 * 
 * @author Aishwarya
 * @version 1.0
 */
public class CaesarCipher implements Encryptor {

	private int shift;

	private static final int DEFAULT_SHIFT = 4;

	public int getShift() {
		return shift;
	}

	/**
	 * Default constructor
	 */
	public CaesarCipher() {
		shift = DEFAULT_SHIFT;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param shift decides by how many places to shift the character
	 */
	public CaesarCipher(int shift) {
		this.shift = shift;
	}

	@Override
	public String encrypt(String s) {

		return encrypt(s, shift);
	}

	@Override
	public String decrypt(String s) {

		// Using cyclic property of the ceaser cipher
		return decrypt(s, shift);
	}

	/**
	 * Encrypts text using a shift
	 * 
	 * @param text  To be encrypted
	 * @param shift Shift to be added
	 * @return Enrypted shift
	 */
	private static String encrypt(String text, int shift) {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (Character.isUpperCase(ch)) {
				ch = (char) (((int) text.charAt(i) + shift - 65) % 26 + 65);
			} else if (Character.isLowerCase(ch)) {
				ch = (char) (((int) text.charAt(i) + shift - 97) % 26 + 97);
			} else if (Character.isDigit(ch)) {
				ch = (char) (((int) text.charAt(i) + shift - 48) % 10 + 48);
			}
			result.append(ch);
		}
		return result.toString();
	}

	/**
	 * Decrypts text using a shift
	 * 
	 * @param text To be decrypted
	 * @param d    Shift to be subtracted
	 * @return decrypted string
	 */
	private static String decrypt(String text, int d) {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			int shift = 0;
			if (Character.isUpperCase(ch)) {
				shift = 26 - d;
				ch = (char) (((int) text.charAt(i) + shift - 65) % 26 + 65);
			} else if (Character.isLowerCase(ch)) {
				shift = 26 - d;
				ch = (char) (((int) text.charAt(i) + shift - 97) % 26 + 97);
			} else if (Character.isDigit(ch)) {
				shift = 10 - d;
				ch = (char) (((int) text.charAt(i) + shift - 48) % 10 + 48);
			}
			result.append(ch);
		}
		return result.toString();
	}
}
