package asupekar_hw4.person;

import java.util.Calendar;

public class PersonUtils {
	
	private static int suid = 100000;
	
	private static final String emailDomain = "@seattleu.edu";
	
	public static int getNextSuid() {
		return suid++;
	}
	
	public static String generateEmailAddress(String firstName, String lastName) {
		return (firstName + lastName + emailDomain).toLowerCase();
	}
	
	public static int getYearDifference(int startYear) {
		return Calendar.getInstance().get(Calendar.YEAR) - startYear;
	}

}
