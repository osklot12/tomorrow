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
     * @param header  the header of the task
     * @param content the descriptive text of the task
     * @param creator the user that created the task
     */
    public Task(String header, String content, User creator) {
        if (header == null || header.isBlank()) {
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

    /**
     * Checks if the task header matches the header of another task.
     * Ignores uppercase.
     * 
     * @param task the task to compare
     * @return true if header matches, false if not
     */
    public boolean matchHeader(Task task) {
        return this.header.toLowerCase().equals(task.getHeader().toLowerCase());
    }

    /**
     * Returns the TaskStatus of the task.
     * 
     * @return TaskStatus object
     */
    public TaskStatus getStatus() {
        return this.status;
    }

    /**
     * Returns the header of the task.
     * 
     * @return header of task
     */
    public String getHeader() {
        return this.header;
    }

    /**
     * Returns the content of the task.
     * 
     * @return content of task
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Returns the creator of the task.
     * 
     * @return creator of task
     */
    public User getCreator() {
        return this.creator;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.header.hashCode();
        result = 31 * result + this.content.hashCode();
        result = 31 * result + this.creator.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Task)) {
            return false;
        }

        Task task = (Task) o;
        return this.header.equals(task.getHeader()) && this.content.equals(task.getContent())
                && this.creator.equals(task.getCreator());
    }
}
