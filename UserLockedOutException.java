package asupekar_hw2.exceptions;

public class UserLockedOutException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserLockedOutException(String message) {
		super(message);
	}

}
