package no.ntnu.oskarlothe.controller.taskCommands;

import no.ntnu.oskarlothe.controller.Command;
import no.ntnu.oskarlothe.model.Task;

/**
 * A class representing a command for changing the title of a task.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class EditTaskTitleCommand implements Command {
    private Task task;

    private String newTitle;

    /**
     * Constructor for the EditTaskTitleCommand class.
     * 
     * @param task the task to edit
     * @param newTitle the new title of the task
     */
    public EditTaskTitleCommand(Task task, String newTitle) {
        if (task == null) {
            throw new IllegalArgumentException("Cannot create EditTaskTitleCommand, because task is null.");
        }

        if (newTitle == null || newTitle.isBlank()) {
            throw new IllegalArgumentException(
                    "Cannot create EditTaskTitleCommand, because the new title is not defined.");
        }

        this.task = task;
        this.newTitle = newTitle;
    }

    @Override
    public void execute() {
        
    }
}
