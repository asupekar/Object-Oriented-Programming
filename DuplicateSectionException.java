package asupekar_hw4.exception;

/**
 * <p>The class <strong>DuplicateSectionException</strong> and its subclasses are a form of Throwable 
 * that indicates conditions that a reasonable application might want to catch.
 * This exception is thrown when attempting to add a duplicate section.</p>
 * 
 * @author ohsh
 */
@SuppressWarnings("serial")
public class DuplicateSectionException extends Exception {

    public DuplicateSectionException(String msg) {
        super(msg);
    }
    
    public DuplicateSectionException() {
        this("Section has already been added.");
    }
    
}
