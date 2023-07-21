package no.ntnu.oskarlothe.model;

import no.ntnu.oskarlothe.model.notification.ChangedTaskHeaderNotification;
import no.ntnu.oskarlothe.model.notification.Notification;
import no.ntnu.oskarlothe.model.notification.TaskCompletedNotification;

/**
 * A class acting as a basic publisher using the observer pattern, notifying all
 * the subscribers about some event. The class also has behaviour for
 * subscribing and unsubscribing to the subject.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskNotifier implements Notifier {
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
     * Subscribes a user to the notifying object.
     * 
     * @param user the user to subscribe
     * @return true if successfully subscribed, false if not
     */
    public boolean subscribe(User user) {
        return this.subscribers.add(user);
    }

    /**
     * Unsubscribes a user from the notifying object.
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

    /**
     * Creates a new TaskCompletedNotification and sends it to all the subscribed
     * users of the
     * task.
     * 
     * @param task the task which is completed
     */
    public void sendTaskCompletedNotification(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Cannot send TaskCompletedNotification, because task is null.");
        }

        Notification taskCompletedNotification = new TaskCompletedNotification(task, task.getStatus().getCompleter());

        this.sendNotification(taskCompletedNotification);
    }

    /**
     * Creates a new ChangedTaskHeaderNotification and sends it to all the
     * subscribed users of the task.
     * 
     * @param task      the task that had a change to its header
     * @param oldHeader the old header of the task
     */
    public void sendChangedTaskHeaderNotification(Task task, String oldHeader) {
        if (task == null) {
            throw new IllegalArgumentException("Cannot send ChangedTaskHeaderNotification, because task is null.");
        }

        Notification changedTaskHeaderNotification = new ChangedTaskHeaderNotification(task, oldHeader,
                task.getHeader());

        this.sendNotification(changedTaskHeaderNotification);
    }
}
