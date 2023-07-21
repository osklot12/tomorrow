package no.ntnu.oskarlothe.model;

/**
 * An interface for all notifying classes in the application.
 * The Notifier is responsible for maintaining data for whom to notify about an
 * event.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public interface Notifier {
    /**
     * Returns wheter the Notifying object has the given subscriber or not.
     * 
     * @return true if the subscriber exist, false if not
     */
    boolean hasSubscriber(User user);

    /**
     * Subscribes a user to a notifying object.
     * 
     * @param user the user to subscribe
     * @return true if succesfully added, false if not
     */
    boolean subscribe(User user);

    /**
     * Unsubscribes a user to a notifying object.
     * 
     * @param user the user to unsubscribe
     * @return true if successfylly unsubscribed, false if not
     */
    boolean unsubscribe(User user);
}
