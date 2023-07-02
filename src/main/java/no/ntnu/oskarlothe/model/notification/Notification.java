package no.ntnu.oskarlothe.model.notification;

import java.time.LocalDateTime;

import no.ntnu.oskarlothe.model.User;

/**
 * An interface for all classes representing a notification in the application.
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

    /**
     * Returns the timestamp for the notification.
     * 
     * @return timestamp for notification
     */
    LocalDateTime getTimestamp();

    /**
     * Unsubscribes the user from similar notifications.
     * 
     * @param user user to unsubscribe
     */
    void unsubscribe(User user);
}
