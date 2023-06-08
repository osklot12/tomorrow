package no.ntnu.oskarlothe.model;

/**
 * A class representing a task to be done.
 * The Task object is the core part of the application, and is the super class
 * of all other task classes.
 * <br/>
 * <br/>
 * 
 * Wheter a task is done or not is represented by a Status object.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class Task {
    private TaskStatus status;

    private String header;

    private String content;

    private User creator;

    /**
     * Constructor for the Task class.
     * <br/>
     * <br/>
     * The header and creator of a Task must be defined.
     * 
     * @param header the header of the task
     * @param content the descriptive text of the task
     * @param creator the user that created the task
     */
    public Task(String header, String content, User creator) {
        if (header.isBlank()) {
            throw new IllegalArgumentException("Task header must be defined.");
        }

        if (creator == null) {
            throw new IllegalArgumentException("Creator of task must be defined.");
        }

        this.status = new TaskStatus();
        this.header = header;
        this.content = content;
        this.creator = creator;
    }
}
