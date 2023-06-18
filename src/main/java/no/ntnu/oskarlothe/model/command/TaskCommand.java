package no.ntnu.oskarlothe.model.command;

import no.ntnu.oskarlothe.model.period.Period;

import no.ntnu.oskarlothe.model.Task;

/**
 * An abstract class setting the common rules for all command objects.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public abstract class TaskCommand implements Command {
    private Task task;

    private Period period;

    /**
     * Constructor for the Command class.
     * 
     * @param task   the task related to the command
     * @param period the peroid related to the task
     */
    public TaskCommand(Task task, Period period) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }

        if (period == null) {
            throw new IllegalArgumentException("Period cannot be null.");
        }

        this.task = task;
        this.period = period;
    }

    /**
     * Returns the Task related to the command.
     * 
     * @return task of command
     */
    public Task getTask() {
        return this.task;
    }

    /**
     * Returns the Period related to the command.
     * 
     * @return period of command
     */
    public Period getPeriod() {
        return this.period;
    }
}
