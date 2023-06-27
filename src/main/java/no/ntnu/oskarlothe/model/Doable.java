package no.ntnu.oskarlothe.model;

/**
 * An interface for all classes representing something doable.
 * The Doable interface is one of the core concepts of the application.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public interface Doable {
    /**
     * Returns whether the doable is done or not.
     * 
     * @return true if done, false if not
     */
    boolean isDone();
}
