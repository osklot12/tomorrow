package no.ntnu.oskarlothe.view.colorpalettes;

import javafx.scene.paint.Paint;

/**
 * An interface for all color palettes in the application.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public interface ColorPalette {
    /**
     * Returns the main gray for the application.
     * 
     * @return main gray
     */
    Paint getMainGray();

    /**
     * Returns the secondary gray for the application.
     * 
     * @return secondary gray
     */
    Paint getSecondaryGray();
}
