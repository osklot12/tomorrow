package no.ntnu.oskarlothe.view.containers;

import javafx.scene.layout.VBox;
import no.ntnu.oskarlothe.view.StyleApplier;

/**
 * A class representing a list of tasks for a TaskManager in JavaFX.
 * The TaskManagerList lets the user interact with the tasks for a given period,
 * like completing, navigating and modifying the tasks.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskManagerList extends VBox {
    /**
     * Constructor for the TaskManagerList class.
     */
    public TaskManagerList() {
        super();

        StyleApplier.addStyleClass(this, "task-manager-list");
        StyleApplier.addStyleClass(this, "task-manager-child");
        StyleApplier.addStyleSheet(this);
        StyleApplier.applyApplicationStyle(this);
    }
}
