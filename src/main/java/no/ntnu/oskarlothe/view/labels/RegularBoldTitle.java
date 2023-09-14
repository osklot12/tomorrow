package no.ntnu.oskarlothe.view.labels;

import javafx.scene.control.Label;
import no.ntnu.oskarlothe.view.StyleApplier;

/**
 * A class representing a regular sized bold title in javaFX.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class RegularBoldTitle extends Label {
    /**
     * Constructor for the RegularBoldTitle.
     * 
     * @param text text to display
     */
    public RegularBoldTitle(String text) {
        super(text);

        StyleApplier.addStyleClass(this, "regular-bold-title");
        StyleApplier.addStyleSheet(this);
    }
} 
