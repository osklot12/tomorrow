package no.ntnu.oskarlothe.view.containers;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import no.ntnu.oskarlothe.view.StyleApplier;

/**
 * A class representing a box container for components displayed horizontally in
 * a TaskManagerPanel in JavaFX.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskManagerBox extends HBox {
    /**
     * Constructor for the TaskManagerBox class.
     */
    public TaskManagerBox() {
        super();

        StyleApplier.addStyleClass(this, "task-manager-box");
        StyleApplier.addStyleSheet(this);
        StyleApplier.addStyleClass(this, "task-manager-child");
        StyleApplier.applyApplicationStyle(this);
    }

    /**
     * Clears the box for content.
     */
    public void empty() {
        this.getChildren().clear();
    }

    /**
     * Adds a component to the box.
     * 
     * @param component component to add
     * @return true if successfully added component, false if not
     */
    public boolean add(Node component) {
        return this.getChildren().add(component);
    }
}
