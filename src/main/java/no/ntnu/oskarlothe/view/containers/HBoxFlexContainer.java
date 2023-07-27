package no.ntnu.oskarlothe.view.containers;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

/**
 * A class representing a JavaFX element responsible for holding children in a
 * horizontally flexible container.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class HBoxFlexContainer extends Pane {
    /**
     * Constructor for the HBoxFlexContainer class.
     * 
     * @param children the children to add to the container
     */
    public HBoxFlexContainer(Node... children) {
        super(children);
        HBox.setHgrow(this, Priority.ALWAYS);
    }
}
