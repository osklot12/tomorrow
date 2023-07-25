package no.ntnu.oskarlothe.model.notification;

import no.ntnu.oskarlothe.model.Assignment;
import no.ntnu.oskarlothe.model.Task;

/**
 * A class representing a notification for a change in the title of a task.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class ChangedTaskHeaderNotification extends TaskNotification {
    private String oldTitle;

    private String newTitle;

    /**
     * Constructor for the ChangedTaskTitleNotification class.
     * 
     * @param task the task of the notification
     * @param oldTitle the old title of the task
     * @param newTitle the new title of the task
     */
    public ChangedTaskHeaderNotification(Task task, String oldTitle, String newTitle) {
        super(task);

        if (oldTitle == null || oldTitle.isBlank()) {
            throw new IllegalArgumentException(
                    "Cannot create ChangedTaskTitleNotification, because old title is not defined.");
        }

        if (newTitle == null || newTitle.isBlank()) {
            throw new IllegalArgumentException(
                    "Cannot create ChangedTaskTitleNotification, because new title is not defined.");
        }

        this.oldTitle = oldTitle;
        this.newTitle = newTitle;
    }

    @Override
    public String getHeader() {
        return "Task '" + this.oldTitle + "' has changed header to '" + this.newTitle + "'";
    }
}
