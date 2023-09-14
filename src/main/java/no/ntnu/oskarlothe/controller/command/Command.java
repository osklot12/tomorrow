package no.ntnu.oskarlothe.controller.command;

/**
 * An interface representing the rules for all command objects in the
 * application.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public interface Command {
    /**
     * Executes a spesific command.
     */
    void execute();
}
