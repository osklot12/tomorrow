package no.ntnu.oskarlothe.model.notification;

import no.ntnu.oskarlothe.model.Task;
import no.ntnu.oskarlothe.model.User;

/**
 * A class representing a notification for when a task has been completed.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskCompletedNotification extends TaskNotification {
    private User completer;

    /**
     * Constructor for the TaskCompletedNotification class.
     * 
     * @param task      the task of the notification
     * @param completer the completer of the task
     */
    public TaskCompletedNotification(Task task, User completer) {
        super(task);

        if (completer == null) {
            throw new IllegalArgumentException("Cannot create TaskCompletedNotification, because completer is null.");
        }

        this.completer = completer;
    }

    public String getHeader() {
        return "The task '" + this.getTask().getHeader() + "' has been completed by "
                + this.completer.getStringRepresentation();
    }
}
