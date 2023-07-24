package no.ntnu.oskarlothe.model;

/**
 * A class representing a task to be done.
 * The Task class extends from the Assignment class and puts a status on top.
 * The TaskStatus holds data relevant to the Assignments' progress.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class Task extends Assignment implements Doable {
    private TaskStatus status;

    /**
     * Constructor for the Task class.
     * 
     * @param header the header of the task
     * @param content the content of the task
     * @param creator the creator of the task
     */
    public Task(String header, String content, User creator) {
        super(header, content, creator);

        this.status = new TaskStatus();
    }

    /**
     * Constructor for the Task class, allowing for a premade status.
     * 
     * @param status the status of the task
     * @param header the header of the task
     * @param content the content of the task
     * @param creator the creator of the task
     */
    public Task(TaskStatus status, String header, String content, User creator) {
        super(header, content, creator);

        this.status = status;
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
     * Does the task.
     * 
     * @param user the user which completed the task
     */
    public void doTask(User user) {
        this.status.complete(user);
    }

    /**
     * Undoes the task, and removes the completer of the task.
     */
    public void unDo() {
        this.status.abandon();
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
        return new Task(new TaskStatus(this.status.getAssignees()), this.getHeader(), this.getContent(), this.getCreator());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.status.hashCode();
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
        return this.getHeader().equals(task.getHeader()) && super.equals(o);
    }
}
