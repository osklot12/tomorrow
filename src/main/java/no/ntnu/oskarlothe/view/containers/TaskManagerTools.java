package no.ntnu.oskarlothe.view.containers;

import javafx.scene.layout.VBox;
import no.ntnu.oskarlothe.view.StyleApplier;

/**
 * A class representing an overview of functions and services related to a list
 * of tasks in JavaFX. Typical examples include reports and statistics of the
 * associated tasks.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskManagerTools extends VBox {
    /**
     * Constructor for the TaskManagerTools class.
     */
    public TaskManagerTools() {
        super();

        StyleApplier.addStyleClass(this, "task-manager-tools");
        StyleApplier.addStyleClass(this, "task-manager-child");
        StyleApplier.addStyleSheet(this);
        StyleApplier.applyApplicationStyle(this);
    }
}
