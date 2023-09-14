package no.ntnu.oskarlothe.view.buttons;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import no.ntnu.oskarlothe.view.StyleApplier;

/**
 * A class representing a button in JavaFX for navigating to previous items in a list.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class PreviousNavigationButton extends Button {
    /**
     * Constructor for the PreviousNavigationButton.
     */
    public PreviousNavigationButton() {
        super();

        StyleApplier.addStyleClass(this, "navigation-button");
        StyleApplier.addStyleSheet(this, "NavigationButton.css");
        
        this.init();
    }

    /**
     * Initializes the content.
     */
    private void init() {
        Text calendarIcon = GlyphsDude.createIcon(FontAwesomeIcons.ARROW_LEFT, "30px");
        this.setGraphic(calendarIcon);
    }
} 
