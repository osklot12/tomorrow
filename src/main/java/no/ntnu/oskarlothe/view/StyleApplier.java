package no.ntnu.oskarlothe.view;

import javafx.scene.Node;
import javafx.scene.Parent;

/**
 * A class making adding styles to the different JAVAFX components easier.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class StyleApplier {
    /**
     * Applies a CSS stylesheet to a spesific JavaFX component.
     * The stylesheet has to be in the same folder as the component for the method
     * to work.
     * 
     * @param component component to apply to
     * @param stylesheet stylesheet to apply
     */
    public static void addStyleSheet(Parent component, String stylesheet) {
        component.getStylesheets().add(component.getClass().getResource(stylesheet).toExternalForm());
    }

    /**
     * Applies the application styling standard for a component.
     * 
     * @param component the component to apply for
     */
    public static void applyApplicationStyle(Parent component) {
        component.getStylesheets().add(component.getClass().getResource("/css/Application.css").toExternalForm());
    }

    /**
     * Adds a style class to the a spesific JavaFx component.
     * 
     * @param component the component to add style class to
     * @param styleClass the desired style class name
     */
    public static void addStyleClass(Parent component, String styleClass) {
        component.getStyleClass().add(styleClass);
    }
}
