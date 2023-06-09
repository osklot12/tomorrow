package no.ntnu.oskarlothe.model.exception;

/**
 * A class representing an exception for when a user tries to add a task that
 * already exists in a list.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskAlreadyExistsException extends RuntimeException {
    /**
     * Default constructor for the TaskAlreadyExistsException class.
     */
    public TaskAlreadyExistsException() {
        super("Task already exists in the list.");
    }

    /**
     * Constructor for the TaskAlreadyExistsException, with custom message.
     * 
     * @param message custom message
     */
    public TaskAlreadyExistsException(String message) {
        super(message);
    }
}
