package no.ntnu.oskarlothe.controller;

/**
 * A class representing a command purely for testing purposes.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TestCommand implements Command {
    String testString;

    /**
     * Constructor for the TestCommand class.
     * 
     * @param text the text to be displayed in the terminal
     */
    public TestCommand(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Text must be defined.");
        }

        this.testString = text;
    }

    public void execute() {
        System.out.println(this.testString);
    }
}
