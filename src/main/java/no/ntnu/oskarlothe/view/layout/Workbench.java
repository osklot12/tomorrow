package no.ntnu.oskarlothe.view.layout;

import javafx.scene.layout.GridPane;
import no.ntnu.oskarlothe.view.StyleApplier;
import no.ntnu.oskarlothe.view.containers.MonthAndCalendar;
import no.ntnu.oskarlothe.view.labels.PeriodDisplay;

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
public class Workbench extends GridPane {
    private PeriodDisplay periodDisplay;

    /**
     * Constructor for the WorkBench class.
     */
    public Workbench() {
        super();
        StyleApplier.addStyleSheet(this, "Workbench.css");

        this.init();
    }

    /**
     * Initializes the component.
     */
    private void init() {
        this.add(new MonthAndCalendar(), 0, 0);
    }
}
