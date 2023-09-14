package no.ntnu.oskarlothe.view.layout;

import javafx.scene.layout.VBox;
import no.ntnu.oskarlothe.model.Day;
import no.ntnu.oskarlothe.model.DayList;
import no.ntnu.oskarlothe.model.Schedule;
import no.ntnu.oskarlothe.view.StyleApplier;

/**
 * A class representing the main working bench of the application.
 * <p>
 * The WorkBench consists of a datepicker as well as all tasks and reports for a
 * given day.
 * The component is the most central part of the application, making it ideal to
 * dislay the component accordingly.
 * </p>
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class Workbench extends VBox {
    private PeriodNavigator periodNavigator;

    Schedule schedule;

    public Workbench() {
        super();

        StyleApplier.addStyleSheet(this, "Workbench.css");

        this.periodNavigator = new PeriodNavigator();

        this.schedule = new Schedule();

        this.init();
    }

    /**
     * Constructor for the WorkBench class.
     */
    public Workbench(Schedule schedule) {
        super();

        if (schedule == null) {
            throw new IllegalArgumentException("Cannot create workbench, because schedule is null.");
        }

        StyleApplier.addStyleSheet(this, "Workbench.css");

        this.periodNavigator = new PeriodNavigator(schedule);

        this.schedule = schedule;

        this.init();
    }

    /**
     * Initializes the component.
     */
    private void init() {
        this.getChildren().add(periodNavigator);
    }

    /**
     * Sets the schedule of the workbench.
     * 
     * @param schedule schedule to work with
     */
    public void setSchedule(Schedule schedule) {
        if (schedule == null) {
            throw new IllegalArgumentException("Cannot set schedule, because schedule is null.");
        }

        this.schedule = schedule;
    }
 
    /**
     * Sets the text to display for the period display.
     * 
     * @param text text to display
     */
    public void setPeriodDisplayText(String text) {
        this.periodNavigator.setPeriodDisplayText(text);
    }
}
