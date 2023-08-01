package no.ntnu.oskarlothe.view.containers;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import no.ntnu.oskarlothe.view.StyleApplier;

/**
 * A class representing a JavaFX element responsible for holding children in a
 * horizontally flexible container.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class HBoxFlexContainer extends HBox {
    /**
     * Constructor for the HBoxFlexContainer class.
     * 
     * @param children the children to add to the container
     */
    public HBoxFlexContainer(Node... children) {
        super(children);
        HBox.setHgrow(this, Priority.ALWAYS);

        StyleApplier.addStyleClass(this, "hbox-flex-container");
        StyleApplier.addStyleSheet(this, "HBoxFlexContainer.css");
    }
}
