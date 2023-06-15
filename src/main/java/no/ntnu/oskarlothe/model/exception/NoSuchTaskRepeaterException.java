package no.ntnu.oskarlothe.model.exception;

/**
 * A class representing an exception for when a TaskRepeater is not found in a
 * list.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class NoSuchTaskRepeaterException extends RuntimeException {
    /**
     * Constructor for the NoSuchTaskRepeater class.
     */
    public NoSuchTaskRepeaterException() {
        super("There is no such TaskRepeater.");
    }

    /**
     * Constructor for the NoSuchTaskRepeaterException class, with a custom message.
     * 
     * @param message
     */
    public NoSuchTaskRepeaterException(String message) {
        super(message);
    }
}
