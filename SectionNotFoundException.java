package asupekar_hw4.exception;

/**
 * <p>The class <strong>SectionNotFoundException</strong> and its subclasses are a form of Throwable 
 * that indicates conditions that a reasonable application might want to catch.
 * This exception is thrown when attempting to find a section that does not exist.</p>
 * 
 * @author ohsh
 */
@SuppressWarnings("serial")
public class SectionNotFoundException extends Exception {
    
    public SectionNotFoundException(String msg) {
        super(msg);
    }
    
    public SectionNotFoundException() {
        this("Section was not found.");
    }
}
