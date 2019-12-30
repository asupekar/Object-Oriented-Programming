package asupekar_hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Template {

	/**
	 * Constructor to spilt the String separated by space
	 * 
	 * @param s String to separated
	 * @throws FileNotFoundException
	 */
	public Template(String s) throws FileNotFoundException {
		words = s.split("\\s");
		zippy = populateZippyList();
		currentOffSet = 0;
	}

	/**
	 * To check if the word is same as the some conditions.
	 *  
	 * @param args Hash map
	 * @param isRandom Boolean flag
	 * @return String that is to be printed
	 * @throws Exception
	 */
	public String instantiate(Map<String, String> args, boolean isRandom) throws Exception {
		String[] translatedWords = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			if (isVariable(words[i])) {
				if (words[i].equals("$newline"))
					translatedWords[i] = "\n";
				else if (words[i].equals("$zippy")) {
					if (isRandom) {
						translatedWords[i] = getRandomZippy();
					} else {
						translatedWords[i] = getSequentialZippy();
						currentOffSet++;
					}
				} else if (words[i].equals("$daypart"))
					translatedWords[i] = (new DayPart()).toString();
				else if (args.containsKey(words[i])) {
					translatedWords[i] = args.get(words[i]);
				} else if (words[i].equals("$name")) {
					String userName = System.getProperty("user.name");
					if (userName != null || userName.length() != 0) {
						translatedWords[i] = userName.substring(0, 1).toUpperCase() + userName.substring(1);
					} else {
						translatedWords[i] = unnamedPerson;
					}
				} else
					throw new Exception("variable does not match: " + words[i]);
			} else {
				translatedWords[i] = words[i];
			}
		}
		return String.join(" ", translatedWords);

	}

	/**
	 * Return Sequential zippy quote
	 * 
	 * @return sequential zippy quote, null otherwise.
	 */
	private String getSequentialZippy() {
		if (currentOffSet < numberOfLines) {
			return zippy.get(currentOffSet);
		}
		return null;
	}

	/**
	 *  If zandom, get a random number and get the zippy quote from 
	 *  the array list
	 *  
	 * @return zippy quote from generated random number.
	 * @throws FileNotFoundException
	 */
	private String getRandomZippy() throws FileNotFoundException {
		Random rand = new Random();
		int randomIndex = rand.nextInt(numberOfLines);

		return zippy.get(randomIndex);
	}

	/**
	 * To populate the Arraylist with zippy quotes.
	 * 
	 * @return populated zippy quote
	 * @throws FileNotFoundException
	 */
	private List<String> populateZippyList() throws FileNotFoundException {
		File file = new File("yow.lines");
		List<String> zippy = new ArrayList<>();

		Scanner scan = new Scanner(file);
		numberOfLines = 0;
		while (scan.hasNextLine()) {
			String zippyQuote = scan.nextLine();
			if (zippyQuote.length() != 0) {
				zippy.add(zippyQuote);
				numberOfLines++;
			}
		}

		return zippy;
	}

	/**Check if the start of the word is with $
	 * 
	 * @param s String to be checked
	 * @return true is $, false otherwise
	 */
	private boolean isVariable(String s) {
		if (s.charAt(0) != '$') {
			return false;
		}

		// Edge case for currency $1.25
		if (isNumeric(s.substring(1))) {
			return false;
		}
		return true;
	}

	private static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private String[] words;
	private static int currentOffSet;
	private static int numberOfLines;
	private static List<String> zippy;
	private final static String unnamedPerson = "Unnamed Person";
}
