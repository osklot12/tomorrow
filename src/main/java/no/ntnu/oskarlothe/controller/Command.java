package no.ntnu.oskarlothe.controller;

/**
 * An interface for all commands in the application.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public interface Command {
    /**
     * Executes the command.
     */
    void execute();
}
