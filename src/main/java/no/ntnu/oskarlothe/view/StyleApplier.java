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
     * @param component  component to apply to
     * @param stylesheet stylesheet to apply
     */
    public static void addStyleSheet(Parent component, String stylesheet) {
        component.getStylesheets().add(component.getClass().getResource(stylesheet).toExternalForm());
    }

    /**
     * Applies a CSS stylesheet to a spesific JavaFX component.
     * The method only works if a CSS file with the same name as the class of the
     * component, exists in the same directory.
     * 
     * @param component component to apply to
     */
    public static void addStyleSheet(Parent component) {
        String cssFileName = component.getClass().getSimpleName() + ".css";

        addStyleSheet(component, cssFileName);
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
     * Adds a style class to a spesific JavaFx component.
     * 
     * @param component  the component to add style class to
     * @param styleClass the desired style class name
     */
    public static void addStyleClass(Parent component, String styleClass) {
        component.getStyleClass().add(styleClass);
    }

    /**
     * Removes a style class from a spesific JavaFX component.
     * 
     * @param component  component to remove styleclass from
     * @param styleClass name of styleclass
     */
    public static void removeStyleClass(Parent component, String styleClass) {
        component.getStyleClass().remove(styleClass);
    }
}
