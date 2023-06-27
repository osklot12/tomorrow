package no.ntnu.oskarlothe.model.exception;

/**
 * A class representing an exception for when trying to unassign a completer of
 * a task status, that does not have a completer assigned.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskNotCompletedException extends RuntimeException {
    /**
     * Default constructor for the TaskNotCompletedException class.
     */
    public TaskNotCompletedException() {
        super("TaskStatus has not been completed yet.");
    }

    /**
     * Constructor for the TaskNotCompletedException class, with a custom message.
     * 
     * @param message custom message
     */
    public TaskNotCompletedException(String message) {
        super(message);
    }
}
