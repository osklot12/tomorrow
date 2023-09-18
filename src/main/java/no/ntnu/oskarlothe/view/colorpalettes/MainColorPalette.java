package no.ntnu.oskarlothe.view.colorpalettes;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * A class representing a main color palette for the application.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class MainColorPalette implements ColorPalette {
    /**
     * Constructor for the MainColorPalette class.
     */
    public MainColorPalette() {
        
    }

    public Paint getMainGray() {
        return Color.web("#232323");
    }

    public Paint getSecondaryGray() {
        return Color.web("");
    }
}
