package no.ntnu.oskarlothe.model.notification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A class representing a center for notifications.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class NotificationCenter extends ArrayList<Notification> implements NotificationListener {
    /**
     * Constructor for the NotificationCenter class.
     */
    public NotificationCenter() {
        super();
    }

    public void update(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Cannot update with notification, because notification is null.");
        }

        if (!this.contains(notification)) {
            this.add(notification);
        }
    }

    /**
     * Sorts the list of notifications by their timestamp, in either an ascending or descending way.
     * 
     * @param order "asc" for ascending order, "des" for descending order
     */
    public void sortByTimestamp(String order) {
        if (order == null || order.isBlank()) {
            throw new IllegalArgumentException(
                    "Cannot sort notifications by timestamp, because the order is not defined.");
        }

        if (order.equalsIgnoreCase("asc")) {
            Collections.sort(this, Comparator.comparing(Notification::getTimestamp));
        } else if (order.equalsIgnoreCase("des")) {
            Collections.sort(this, Comparator.comparing(Notification::getTimestamp).reversed());
        } else {
            throw new IllegalArgumentException(
                    "Cannot sort notifications by timestamp, because the order was not recongized.");
        }
    }
}
