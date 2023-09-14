package no.ntnu.oskarlothe.view.layout;

import javafx.scene.layout.VBox;
import no.ntnu.oskarlothe.controller.PeriodNavigatorController;
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

    private PeriodNavigatorController navigatorController;

    public Workbench() {
        super();

        StyleApplier.addStyleSheet(this, "Workbench.css");

        this.periodNavigator = new PeriodNavigator();

        this.navigatorController = new PeriodNavigatorController(this.periodNavigator);

        this.init();
    }

    /**
     * Initializes the component.
     */
    private void init() {
        this.getChildren().add(periodNavigator);
    }
}
