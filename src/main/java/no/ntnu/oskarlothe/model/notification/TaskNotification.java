package no.ntnu.oskarlothe.model.notification;

import java.time.LocalDateTime;

import no.ntnu.oskarlothe.model.Assignment;
import no.ntnu.oskarlothe.model.Task;
import no.ntnu.oskarlothe.model.User;

/**
 * A class representing a notification about a spesific task.
 * A TaskNotification object holds information about spesific changes or events
 * related to a task for a spesific day.
 * 
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public abstract class TaskNotification implements Notification {
    private Task task;

    private LocalDateTime timestamp;

    /**
     * Constructor for the TaskNotification class.
     * 
     * @param task the task to create a notification for
     */
    public TaskNotification(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Cannot create TaskNotification, because task is null.");
        }

        this.task = task;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Returns the assignment of the notification.
     * 
     * @return task task of the notification
     */
    public Task getTask () {
        return this.task;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void unsubscribe(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot unsubscribe user, because user is null.");
        }

        this.task.getNotifier().unsubscribe(user);
    }
}
