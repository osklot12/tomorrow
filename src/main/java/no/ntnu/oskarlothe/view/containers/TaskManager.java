package no.ntnu.oskarlothe.view.containers;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.VBox;
import no.ntnu.oskarlothe.view.StyleApplier;

/**
 * A class representing a TaskManager in JavaFX.
 * A TaskManager object consists of "panels", containing some data or services
 * regarding tasks for a spesific period.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskManager extends VBox {
    /**
     * Constructor for the TaskManager class.
     */
    public TaskManager() {
        super();

        StyleApplier.addStyleClass(this, "task-manager");
        StyleApplier.addStyleSheet(this);
        StyleApplier.applyApplicationStyle(this);
    }
}
