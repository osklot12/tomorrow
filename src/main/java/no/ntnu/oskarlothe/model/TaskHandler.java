package no.ntnu.oskarlothe.model;

import java.time.Period;

/**
 * A class responsible for handling tasks for a spesific period of time.
 * Since not all tasks are held by the Period objects themselves, due to
 * repeating tasks not being directly assigned to periods, it is necessary to
 * have a unit reponsible for loading these tasks into the appropriate period of
 * time.
 * <br/>
 * <br/>
 * The TaskHandler will retrieve all relevant tasks from a RepeatingTaskList,
 * and load them into the Period object. If we were to store these repeating
 * tasks into the period themselves, we would need an infinte amount of Periods,
 * since repeating tasks is infinite until removed.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskHandler {
    private RepeatingTaskList repeatingTasks;

    /**
     * Constructor for the TaskHandler class.
     * 
     * @param period period to load the repeating tasks to
     * @param repeatingTasks repeating tasks to load
     */
    public TaskHandler(Period period, RepeatingTaskList repeatingTasks) {
        if (period == null) {
            throw new IllegalArgumentException("Period cannot be null");
        }

        if (repeatingTasks == null) {
            throw new IllegalArgumentException("RepeatingTaskList cannot be null.");
        }

        this.repeatingTasks = repeatingTasks;
    }

    /**
     * Loads the repeating tasks 
     * @return
     */
    public Period load() {
        return null;
    }
}
