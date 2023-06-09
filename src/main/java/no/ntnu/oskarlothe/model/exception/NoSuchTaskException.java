package no.ntnu.oskarlothe.model.exception;

/**
 * A class representing an exception for when a spesific task is not to be found
 * in a list.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class NoSuchTaskException extends RuntimeException {
    /**
     * Default constructor NoSuchTaskException class.
     */
    public NoSuchTaskException() {
        super("The is no such task.");
    }

    /**
     * Constructor for the NoSuchTaskException class, with custom message.
     * 
     * @param message custom message
     */
    public NoSuchTaskException(String message) {
        super(message);
    }
}
