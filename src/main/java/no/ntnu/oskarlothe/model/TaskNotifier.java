package no.ntnu.oskarlothe.model;

import no.ntnu.oskarlothe.model.notification.Notification;

/**
 * A class acting as a basic publisher in the observer pattern, notifying all
 * the subscribers about some event. The class also has behaviour for
 * subscribing and unsubscribing to the
 * subject.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskNotifier {
    private UserList subscribers;

    /**
     * Constructor for the Notifier class.
     */
    public TaskNotifier() {
        this.subscribers = new UserList();
    }

    /**
     * Returns wheter the user is already subscribed or not.
     * 
     * @param user user to check for
     * @return true if subscribed, false if not
     */
    public boolean hasSubscriber(User user) {
        return this.subscribers.contains(user);
    }

    /**
     * Returns the list of subscribers.
     * 
     * @return UserList object with all subscribers
     */
    public UserList getSubscribers() {
        return this.subscribers;
    }

    /**
     * Subscribes a user to the notifier object.
     * 
     * @param user the user to subscribe
     * @return true if successfully subscribed, false if not
     */
    public boolean subscribe(User user) {
        return this.subscribers.add(user);
    }

    /**
     * Unsubscribes a user from the notifier.
     * 
     * @param user the user to unsubscribe
     * @return true if successfully unsubscribed, false if not
     */
    public boolean unsubscribe(User user) {
        return this.subscribers.remove(user);
    }

    /**
     * Sends out a notification to all the subscribers of the notifier.
     * 
     * @param notification the notification to send
     */
    public void sendNotification(Notification notification) {
        this.subscribers.forEach(
                (subscriber) -> {
                    subscriber.getNotifications().add(notification);
                });
    }
}
