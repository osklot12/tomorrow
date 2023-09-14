package no.ntnu.oskarlothe.view.entities;

import java.time.DayOfWeek;

import javafx.scene.layout.VBox;
import no.ntnu.oskarlothe.model.Day;
import no.ntnu.oskarlothe.model.WeekdayList;
import no.ntnu.oskarlothe.model.regionstrategy.NoRegionStrategy;
import no.ntnu.oskarlothe.view.StyleApplier;
import no.ntnu.oskarlothe.view.labels.RegularBoldTitle;
import no.ntnu.oskarlothe.view.labels.SmallBoldTitle;

/**
 * A class acting a JavaFX component for a box representing a link to a day in the application.
 * The component shows the date for the day, as well as the progress.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class DayNavigationBox extends VBox {
    /**
     * Constructor for the DayNavigationBox class.
     * 
     * @param day the day associated with the box
     */
    public DayNavigationBox(Day day) {
        super();

        StyleApplier.addStyleClass(this, "day-navigation-box");
        
        StyleApplier.addStyleSheet(this);

        this.init(day);
    }

    /**
     * Initializes the content of the box.
     * 
     * @param day the day to display
     */
    private void init(Day day) {
        if (day == null) {
            throw new IllegalArgumentException("Cannot initialize content, because day is null.");
        }

        String focusedString = String.valueOf(day.getDate().getDayOfMonth());

        RegularBoldTitle focusedLabel = new RegularBoldTitle(focusedString);

        String secondaryString = day.getDate().getDayOfWeek().name().substring(0, 3);
        
        SmallBoldTitle secondaryLabel = new SmallBoldTitle(secondaryString);

        this.getChildren().add(focusedLabel);

        this.getChildren().add(secondaryLabel);
    }
    
}
