package no.ntnu.oskarlothe.model.exception;

/**
 * A class representing a runtime exception for when a trying to add an
 * Assignment object to a collection where it already exists.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class AssignmentAlreadyExistsException extends RuntimeException {
    /**
     * Constructor for the AssignmentAlreadyExistsException class.
     */
    public AssignmentAlreadyExistsException() {
        super("Assignment already exists.");
    }

    /**
     * Constructor for the AssignmentAlreadyExistsException class, allowing for a
     * predefined message.
     * 
     * @param message message to display for the exception
     */
    public AssignmentAlreadyExistsException(String message) {
        super(message);
    }
}
