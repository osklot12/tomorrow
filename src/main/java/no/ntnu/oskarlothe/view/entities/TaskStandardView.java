package no.ntnu.oskarlothe.view.entities;

import no.ntnu.oskarlothe.model.Task;
import javafx.scene.layout.HBox;

/**
 * A class representing a JavaFX component for displaying tasks in their regular
 * view.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskStandardView extends HBox {
    Task task;

    /**
     * Constructor for the TaskStandardView class.
     * 
     * @param task the task to display
     */
    public TaskStandardView(Task task) {
        super();

        if (task == null) {
            throw new IllegalArgumentException("Cannot create TaskStandardView, because task is null.");
        }

        this.task = task;
    }
}
