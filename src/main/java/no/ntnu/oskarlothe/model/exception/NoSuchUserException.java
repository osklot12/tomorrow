package no.ntnu.oskarlothe.model.exception;

/**
 * A class representing an exception for when a spesific user is not found in a
 * list.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class NoSuchUserException extends RuntimeException {
    /**
     * Default constructor for the NoSuchUserException class.
     */
    public NoSuchUserException() {
        super("No such user exist in the list.");
    }

    /**
     * Constructor for the NoSuchUserException class, with custom message.
     * 
     * @param message custom message
     */
    public NoSuchUserException(String message) {
        super(message);
    }
}
