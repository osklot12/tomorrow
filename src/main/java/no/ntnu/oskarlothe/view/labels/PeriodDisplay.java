package no.ntnu.oskarlothe.view.labels;

import javafx.scene.control.Label;
import no.ntnu.oskarlothe.view.StyleApplier;

/**
 * A class representing a display for a period of time.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class PeriodDisplay extends Label {
    /**
     * Constructor for the PeriodDisplay class.
     * 
     * @param text the text to display
     */
    public PeriodDisplay(String text) {
        super(text);
        
        StyleApplier.applyApplicationStyle(this);
        StyleApplier.addStyleClass(this, "period-display");
        StyleApplier.addStyleSheet(this, "PeriodDisplay.css");
    }
}
