package no.ntnu.oskarlothe.view.containers;

import javafx.scene.layout.HBox;
import no.ntnu.oskarlothe.view.StyleApplier;
import no.ntnu.oskarlothe.view.buttons.CalendarButton;
import no.ntnu.oskarlothe.view.labels.PeriodDisplay;

/**
 * A class representing a JavaFX component for the current period displayed and
 * a
 * calendar button.
 * The component is in horizontal layout.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class MonthAndCalendar extends HBox {
    public MonthAndCalendar() {
        super();

        StyleApplier.addStyleSheet(this, "MonthAndCalendar.css");
        StyleApplier.addStyleClass(this, "month-and-calendar");

        this.init();
    }

    /**
     * Initializes the content.
     */
    public void init() {
        PeriodDisplay periodDisplay = new PeriodDisplay("November");

        this.getChildren().add(new HBoxFlexContainer(periodDisplay));
        
        this.getChildren().add(new CalendarButton());
    }
}
