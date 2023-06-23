package no.ntnu.oskarlothe.model.command;

import no.ntnu.oskarlothe.model.Period;
import no.ntnu.oskarlothe.model.Task;

/**
 * A class representing a command responsible for adding a task to a spesific
 * Period.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class AddTaskCommand extends TaskCommand {
    public AddTaskCommand(Task task, Period period) {
        super(task, period);
    }

    public void execute() {
        this.getPeriod().add(this.getTask());
    }
}
