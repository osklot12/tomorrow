package no.ntnu.oskarlothe.view.buttons;

import javafx.scene.control.Button;
import no.ntnu.oskarlothe.model.Day;
import no.ntnu.oskarlothe.view.StyleApplier;
import no.ntnu.oskarlothe.view.entities.DayNavigationBox;

/**
 * A class representing a clickable button in JavaFX, that takes you to a
 * spesific day in the UI.
 */
public class DayNavigationButton extends Button {
    /**
     * Constructor for the DayNavigationButton class.
     * 
     * @param day the day associated with the button
     */
    public DayNavigationButton(Day day) {
        super();

        StyleApplier.addStyleClass(this, "day-navigation-button");

        StyleApplier.addStyleSheet(this);

        this.init(day);
    }

    /**
     * Initializes the content of the button.
     * 
     * @param day the day to display
     */
    private void init(Day day) {
        DayNavigationBox content = new DayNavigationBox(day);

        this.setGraphic(content);

        StyleApplier.applyApplicationStyle(this);
        StyleApplier.addStyleSheet(this);
    }
}
