package no.ntnu.oskarlothe.view.layout;

import javafx.scene.layout.VBox;
import no.ntnu.oskarlothe.model.Day;
import no.ntnu.oskarlothe.model.Schedule;
import no.ntnu.oskarlothe.view.containers.MonthAndCalendar;
import no.ntnu.oskarlothe.view.containers.PeriodCarousel;

/**
 * A class representing a JavaFX component for navigating the period displayed.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class PeriodNavigator extends VBox {
    private MonthAndCalendar monthAndCalendar;

    private PeriodCarousel periodCarousel;

    /**
     * Constructor for the PeriodNavigator class.
     * 
     * @param schedule the schedule to navigate
     */
    public PeriodNavigator() {
        super();

        this.monthAndCalendar = new MonthAndCalendar();

        this.periodCarousel = new PeriodCarousel();

        this.init();
    }

    /**
     * Initializes the components.
     */
    private void init() {
        this.getChildren().add(this.monthAndCalendar);

        this.getChildren().add(this.periodCarousel);
    }

    /**
     * Returns the MonthAndCalendar object.
     * 
     * @return month and calendar for the periodnavigator
     */
    public MonthAndCalendar getMonthAndCalendar() {
        return this.monthAndCalendar;
    }

    /**
     * Returns the PeriodCarousel for the navigator.
     * 
     * @return carousel to navigate the periods
     */
    public PeriodCarousel getPeriodCarousel() {
        return this.periodCarousel;
    }
}
