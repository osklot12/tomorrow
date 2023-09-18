package no.ntnu.oskarlothe.view.layout;

import javafx.scene.layout.VBox;
import no.ntnu.oskarlothe.controller.PeriodNavigatorController;
import no.ntnu.oskarlothe.view.StyleApplier;
import no.ntnu.oskarlothe.view.containers.TaskManager;
import no.ntnu.oskarlothe.view.containers.TaskManagerList;
import no.ntnu.oskarlothe.view.containers.TaskManagerPanel;
import no.ntnu.oskarlothe.view.containers.TaskManagerTools;

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

    private TaskManager taskManager;

    /**
     * Constructor for the Workbench class.
     */
    public Workbench() {
        super();

        StyleApplier.addStyleClass(this, "workbench");

        StyleApplier.addStyleSheet(this);

        this.periodNavigator = new PeriodNavigator();

        this.navigatorController = new PeriodNavigatorController(this.periodNavigator);

        this.taskManager = new TaskManager();

        this.init();
    }

    /**
     * Initializes the component.
     */
    private void init() {
        TaskManagerPanel buttonPanel = new TaskManagerPanel();



        TaskManagerPanel panel = new TaskManagerPanel("Monday 18th", "September 2023");

        TaskManagerList taskList = new TaskManagerList();

        TaskManagerTools taskTools = new TaskManagerTools();

        panel.addComponent(taskList);

        panel.addComponent(taskTools);

        this.taskManager.getChildren().add(panel);

        this.getChildren().add(this.periodNavigator);
        this.getChildren().add(this.taskManager);
    }

    /**
     * Returns the controller for the PeriodNavigator.
     * 
     * @return controller of periodnavigator
     */
    public PeriodNavigatorController getNavigatorController() {
        return this.navigatorController;
    }
}
