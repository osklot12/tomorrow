package no.ntnu.oskarlothe.view.layout;

import java.time.LocalDate;

import javafx.scene.layout.VBox;
import no.ntnu.oskarlothe.controller.PeriodCarouselController;
import no.ntnu.oskarlothe.model.Day;
import no.ntnu.oskarlothe.model.DayList;
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

    private PeriodCarouselController carouselController;

    private Schedule schedule;

    /**
     * Constructor for the PeriodNavigator class.
     */
    public PeriodNavigator() {
        super();

        this.monthAndCalendar = new MonthAndCalendar();

        this.periodCarousel = new PeriodCarousel();

        this.carouselController = new PeriodCarouselController(this.periodCarousel);

        this.schedule = new Schedule();

        this.init();
    }

    /**
     * Constructor for the PeriodNavigator class.
     * 
     * @param schedule the schedule to navigate
     */
    public PeriodNavigator(Schedule schedule) {
        super();

        if (schedule == null) {
            throw new IllegalArgumentException("Cannot create PeriodNavigator, because days is");
        }

        this.monthAndCalendar = new MonthAndCalendar();

        this.periodCarousel = new PeriodCarousel();

        this.carouselController = new PeriodCarouselController(this.periodCarousel);

        this.schedule = schedule;

        this.init();
    }

    /**
     * Initializes the components.
     */
    private void init() {
        this.getChildren().add(this.monthAndCalendar);

        this.getChildren().add(this.periodCarousel);

        this.displayDay(this.schedule.getDay(LocalDate.parse("2023-09-14")));
    }

    /**
     * Returns the schedule of the navigator.
     * 
     * @return schedule of navigator
     */
    public Schedule getSchedule() {
        return this.schedule;
    }

    /**
     * Displays a spesific day from the schedule.
     * 
     * @param focus the day to display
     */
    public void displayDay(Day focus) {
        this.carouselController.display(this.schedule, focus);
    }

    /**
     * Sets the text of the period display.
     * 
     * @param text text to display
     */
    public void setPeriodDisplayText(String text) {
        this.monthAndCalendar.setPeriodDisplayText(text);
    }

    /**
     * Returns the PeriodCarouselController object.
     * 
     * @return carouselcontroller
     */
    public PeriodCarouselController getCarouselController() {
        return this.carouselController;
    };
}
