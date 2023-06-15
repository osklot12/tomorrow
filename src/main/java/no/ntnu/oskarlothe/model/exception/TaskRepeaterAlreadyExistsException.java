package no.ntnu.oskarlothe.model.exception;

/**
 * A class representing an exception for when trying to add a TaskRepeater to a
 * list that already contains the TaskRepeater.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskRepeaterAlreadyExistsException extends RuntimeException {
    /**
     * Default contructor for the TaskRepeaterAlreadyExistsException class.
     */
    public TaskRepeaterAlreadyExistsException() {
        super("The TaskRepeater already exists in the list.");
    }

    /**
     * Constructor for the TaskRepeaterAlreadyExistsException class, with a custom
     * message.
     * 
     * @param message custom message
     */
    public TaskRepeaterAlreadyExistsException(String message) {
        super(message);
    }
}
