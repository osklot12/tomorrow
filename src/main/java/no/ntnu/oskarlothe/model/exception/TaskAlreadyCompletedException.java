package no.ntnu.oskarlothe.model.exception;

/**
 * A class representing an exception for when a user tries to complete a task
 * that is already completed.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskAlreadyCompletedException extends RuntimeException {
    /**
     * Default constructor for the TaskAlreadyCompleted class.
     */
    public TaskAlreadyCompletedException() {
        super("Task is already completed.");
    }

    /**
     * Constructor for the TaskAlreadyCompleted class, with custom message.
     * 
     * @param message custom message
     */
    public TaskAlreadyCompletedException(String message) {
        super(message);
    }
}
