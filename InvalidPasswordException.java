package asupekar_hw2.exceptions;

public class InvalidPasswordException extends Exception {  
	
	private static final long serialVersionUID = 1L;
	
    public InvalidPasswordException(String message) {
        super(message);
    }
}
