package no.ntnu.oskarlothe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import no.ntnu.oskarlothe.controller.CommandButtonController;
import no.ntnu.oskarlothe.controller.TestCommand;
import no.ntnu.oskarlothe.view.buttons.DoButton;

/**
 * A class representing the full application of Tomorrow.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class App extends Application {
    /**
     * Constructor for the App class.
     */
    public App() {
        super();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tomorrow");

        primaryStage.setWidth(1024);
        primaryStage.setHeight(768);

        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(200);

        primaryStage.setResizable(true);

        Pane root = new GridPane();
        
        Button button = new DoButton("Done");

        CommandButtonController controller = new CommandButtonController(button, new TestCommand("Button is working!"));

        root.getChildren().add(button);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    /**
     * Runs the JavaFX application.
     * 
     * @param args console arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
