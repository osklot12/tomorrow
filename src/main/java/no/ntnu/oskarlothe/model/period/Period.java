package no.ntnu.oskarlothe.model.period;

import java.time.LocalDateTime;

import no.ntnu.oskarlothe.model.Report;
import no.ntnu.oskarlothe.model.TaskList;
import no.ntnu.oskarlothe.model.User;
import no.ntnu.oskarlothe.model.regionstrategy.RegionStrategy;

/**
 * An abstract class representing a period of time.
 * The Period class contains a list of tasks assigned to that spesific period of
 * time. A class that inherits from the Period class, defines its own period
 * of time.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public abstract class Period {
    private TaskList tasks;

    /**
     * Default constructor for the Period class.
     */
    public Period() {
        this.tasks = new TaskList();
    }

    /**
     * Contructor for the Period class with an existing TaskList object.
     * 
     * @param tasks TaskList object
     */
    public Period(TaskList tasks) {
        if (tasks == null) {
            throw new IllegalArgumentException("TaskList cannot be null.");
        }

        this.tasks = tasks;
    }

    /**
     * Returns the TaskList.
     * 
     * @return TaskList object
     */
    public TaskList getTaskList() {
        return this.tasks;
    }

    /**
     * Checks if the Period has any tasks.
     * 
     * @return true if any tasks exist, false if not
     */
    public boolean hasTasks() {
        return !(this.tasks.getTasks().isEmpty());
    }

    /**
     * Generates a report based on the period of time.
     * 
     * @return report object
     */
    abstract Report generateReport(User creator, LocalDateTime generatedAt);

    /**
     * Returns the a decriptive text of the period.
     * 
     * @return String explaining period
     */
    abstract String getPeriodAsString(RegionStrategy region);

    /**
     * Returns a copy of the current version of of the period, allowing for storing
     * of the exact state of the period in that instance.
     * 
     * @return copy of the period
     */
    abstract Period copy();
}
