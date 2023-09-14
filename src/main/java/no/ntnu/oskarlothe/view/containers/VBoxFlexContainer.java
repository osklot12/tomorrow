package no.ntnu.oskarlothe.view.containers;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import no.ntnu.oskarlothe.view.StyleApplier;

/**
 * A class representing a JavaFX component for a container flexing in the vertical direction.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class VBoxFlexContainer extends VBox {
    /**
     * Constructor for the VBoxFlexContainer class.
     * 
     * @param children the children to add 
     */
    public VBoxFlexContainer(Node... children) {
        super(children);
        VBox.setVgrow(this, Priority.ALWAYS);
        this.setAlignment(Pos.CENTER);

        StyleApplier.addStyleClass(this, "vbox-flex-container");
        StyleApplier.addStyleSheet(this, "VBoxFlexContainer.css");
    }
}
