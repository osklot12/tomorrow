package no.ntnu.oskarlothe.model.exception;

/**
 * A class representing an exception for when a user already exists in a
 * spesific list.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class UserAlreadyExistsException extends RuntimeException {
    /**
     * Default constructor for the UserAlreadyExistsException class.
     */
    public UserAlreadyExistsException() {
        super("User already exists in the list.");
    }

    /**
     * Constructor for the UserAlreadyExistsException class, with custom message.
     * 
     * @param message custom message
     */
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
