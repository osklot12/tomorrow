package no.ntnu.oskarlothe.view.labels;

import javafx.scene.control.Label;
import no.ntnu.oskarlothe.view.StyleApplier;

/**
 * A class representing a small bold title in JavaFX, perfect for labeling
 * entities.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class SmallBoldTitle extends Label {
    /**
     * Constructor for the SmallBoldTitle class.
     * 
     * @param text the text to display
     */
    public SmallBoldTitle(String text) {
        super(text);

        StyleApplier.applyApplicationStyle(this);
        StyleApplier.addStyleClass(this, "small-bold-title");
        StyleApplier.addStyleSheet(this, "SmallBoldTitle.css");
    }
}
