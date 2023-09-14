package no.ntnu.oskarlothe.controller.command;

import no.ntnu.oskarlothe.controller.PeriodNavigatorController;
import no.ntnu.oskarlothe.model.Day;
import no.ntnu.oskarlothe.model.regionstrategy.NoRegionStrategy;
import no.ntnu.oskarlothe.view.layout.PeriodNavigator;

/**
 * A class representing a command for displaying a spesific day, in the main
 * frame for displaying days.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class DisplayDayCommand implements Command {
    private Day day;

    private PeriodNavigatorController navigatorController;

    /**
     * Constructor for the DisplayDayCommand.
     * 
     * @param day the day to display
     */
    public DisplayDayCommand(Day day, PeriodNavigatorController navigatorController) {
        if (day == null) {
            throw new IllegalArgumentException("Cannot create DisplayDayCommand, because day is null.");
        }

        if (navigatorController == null) {
            throw new IllegalArgumentException(
                    "Cannot create DisplayDayCommand, because navigator controller is null.");
        }

        this.day = day;

        this.navigatorController = navigatorController;
    }

    @Override
    public void execute() {
        System.out.println("Button for " + this.day.getPeriodAsString(new NoRegionStrategy()) + " was clicked!");

        this.navigatorController.setToggle(this.day);
    }
}
