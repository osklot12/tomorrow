package no.ntnu.oskarlothe.model;

import no.ntnu.oskarlothe.model.notification.ChangedTaskHeaderNotification;
import no.ntnu.oskarlothe.model.notification.TaskCompletedNotification;

/**
 * A class representing a task to be done.
 * The Task object is the core part of the application, and is the super class
 * of all other task classes.
 * 
 * <p>
 * Users assigned to a task will also be subscribed to notifications for that
 * task.
 * Unwanted subscription of a task can be achieved by simply unsubscribing to
 * that task.
 * <p/>
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class Task implements Doable {
    private TaskStatus status;

    private String header;

    private String content;

    private User creator;

    private TaskNotifier notifier;

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
        this.notifier = new TaskNotifier();
    }

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
    public Task(TaskStatus status, String header, String content, User creator) {
        if (status == null) {
            throw new IllegalArgumentException("TaskStatus cannot be null.");
        }

        if (header == null || header.isBlank()) {
            throw new IllegalArgumentException("Task header must be defined.");
        }

        if (creator == null) {
            throw new IllegalArgumentException("Creator of task must be defined.");
        }

        this.status = status;
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
     * Assigns a user to the task.
     * Any user assigned to a task will also be subscribed to notifications for the
     * task.
     * 
     * @param user the user to assign
     * @return true if successfully assigned, false if user already is assigned
     */
    public boolean assign(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot assign user to task, because user is null.");
        }

        if (!this.status.getAssignees().contains(user)) {
            this.status.assign(user);

            if (!this.notifier.hasSubscriber(user)) {
                this.notifier.subscribe(user);
            }

            return true;
        }

        return false;
    }

    /**
     * Unassigns a user from the task.
     * 
     * @param user user to unassign
     * @return true is successfully unassigned, false if user does not exist as
     *         assignee
     */
    public boolean unassign(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot unassign user from task, because user is null.");
        }

        if (this.status.getAssignees().contains(user)) {
            this.status.unassign(user);

            if (this.notifier.hasSubscriber(user)) {
                this.notifier.unsubscribe(user);
            }

            return true;
        }

        return false;
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

    /**
     * Returns the notifier of the task.
     * 
     * @return TaskNotifier object
     */
    public TaskNotifier getNotifier() {
        return this.notifier;
    }

    /**
     * Does the task.
     * 
     * @param user the completer of the task
     */
    public void doTask(User user) {
        this.status.complete(user);
        this.notifier.sendNotification(new TaskCompletedNotification(this, user));
    }

    /**
     * Undoes the task, and removes the completer of the task.
     */
    public void unDo() {
        this.status.abandon();
    }

    /**
     * Sets the header of the task.
     * 
     * @param header new header to set
     */
    public void setHeader(String header) {
        if (header == null || header.isBlank()) {
            throw new IllegalArgumentException("Cannot set header, because header is not defined.");
        }

        String oldHeader = this.header;
        this.header = header;
        this.notifier.sendNotification(new ChangedTaskHeaderNotification(this, oldHeader, this.header));
    }

    /**
     * Sets the content of the task.
     * 
     * @param content new content of task
     */
    public void setContent(String content) {
        if (content == null) {
            throw new IllegalArgumentException("Cannot set content, because content is null.");
        }

        this.content = content;
    }

    @Override
    public boolean isDone() {
        return this.status.isDone();
    }

    /**
     * Returns a copy of the Task.
     * 
     * @return copy of Task object
     */
    @Override
    public Task clone() {
        return new Task(new TaskStatus(this.status.getAssignees()), this.header, this.content, this.creator);
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
