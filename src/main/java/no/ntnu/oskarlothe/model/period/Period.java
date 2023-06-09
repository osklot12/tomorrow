package no.ntnu.oskarlothe.model.period;

import no.ntnu.oskarlothe.model.Report;
import no.ntnu.oskarlothe.model.TaskList;

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
     * Generates a report based on the period of time.
     * 
     * @return report object
     */
    abstract Report generateReport();
}
