package no.ntnu.oskarlothe.model.command;

/**
 * A common interface for all command classes.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public interface Command {
    /**
     * Executes the command.
     */
    abstract void execute();
}
