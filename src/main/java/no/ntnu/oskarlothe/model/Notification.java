package no.ntnu.oskarlothe.model;

/**
 * An interface representing a notification in the application.
 * The Notification interface defines rules for how all classes acting as
 * notifications should behave.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public interface Notification {
    /**
     * Returns the header of the notification.
     * 
     * @return header of notification
     */
    String getHeader();

    // Link getLink();
}
