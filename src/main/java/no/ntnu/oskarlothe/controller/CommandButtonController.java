package no.ntnu.oskarlothe.controller;

import javafx.scene.control.Button;

/**
 * A class representing a controller for buttons executing commands.
 * A command will be executed when the button is pressed.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class CommandButtonController {
    Button button;

    Command command;

    /**
     * Constructor for the CommandButtonController class.
     * 
     * @param button  the button to control
     * @param command the command to be executed when button is pressed
     */
    public CommandButtonController(Button button, Command command) {
        if (button == null) {
            throw new IllegalArgumentException("Cannot create CommandButtonController, because button is null.");
        }

        if (command == null) {
            throw new IllegalArgumentException("Cannot create CommandButtonController, because command is null.");
        }

        this.button = button;
        this.command = command;

        button.setOnAction(e -> {
            this.command.execute();
        });
    }
}
