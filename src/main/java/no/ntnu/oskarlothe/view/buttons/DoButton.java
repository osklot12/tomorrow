package no.ntnu.oskarlothe.view.buttons;

import javafx.scene.control.Button;
import no.ntnu.oskarlothe.view.StyleApplier;

/**
 * A class representing a JavaFX component for the do button, allowing users to
 * do a certain task or assignment.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class DoButton extends Button {
    /**
     * Constructor for the DoButton class.
     * 
     * @param text the text to be displayed on the button
     */
    public DoButton(String text) {
        super();
        this.setText(text);

        this.getStyleClass().add("do-button");
        StyleApplier.addStyleSheet(this, "DoButton.css");
    }


}
