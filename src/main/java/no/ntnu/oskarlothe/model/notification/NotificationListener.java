package no.ntnu.oskarlothe.model.notification;

/**
 * An interface for all listeners following the observer design pattern in the
 * application.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public interface NotificationListener {
    /**
     * Updates the observing object, 
     */
    void update(Notification notification);
}
