package no.ntnu.oskarlothe.controller.command;

import no.ntnu.oskarlothe.model.Day;
import no.ntnu.oskarlothe.model.regionstrategy.NoRegionStrategy;

/**
 * A class representing a command for displaying a spesific day, in the main
 * frame for displaying days.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class DisplayDayCommand implements Command {
    private Day day;

    /**
     * Constructor for the DisplayDayCommand.
     * 
     * @param day the day to display
     */
    public DisplayDayCommand(Day day) {
        if (day == null) {
            throw new IllegalArgumentException("Cannot create DisplayDayCommand, because day is null.");
        }

        this.day = day;
    }

    @Override
    public void execute() {
        System.out.println("Button for " + this.day.getPeriodAsString(new NoRegionStrategy()) + " was clicked!");
    }
}
