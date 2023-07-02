package no.ntnu.oskarlothe.model.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.ntnu.oskarlothe.model.Task;
import no.ntnu.oskarlothe.model.User;

/**
 * JUnit testing for the ChangedTaskTitleNotification class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class ChangedTaskHeaderNotificationTest {
    Task task;

    User user1;

    User user2;

    /**
     * Setting up for the following test methods.
     */
    @BeforeEach
    void setup() {
        User creator = new User("John", "Johnson");

        task = new Task("Go to grocery store", "We need more food for the week", creator);

        user1 = new User("Mickey", "Mouse");

        user2 = new User("Minnie", "Mouse");
    }

    /**
     * Tests that the notification for a changed task header will be created and
     * sent to all users that are assigned to the task.
     */
    @Test
    void testNotificationForAssignedUsers() {
        task.assign(user1);

        task.setHeader("Get groceries");

        // user1 is expected to have 1 notification
        assertTrue(user1.getNotifications().size() == 1);

        // the notification for user1 is expected to have this header
        assertEquals("Task 'Go to grocery store' has changed header to 'Get groceries'",
                user1.getNotifications().get(0).getHeader());

        // user2 is expected to have no notifications
        assertTrue(user2.getNotifications().size() == 0);
    }

    /**
     * Tests that users can still get notifications for a change in a task header by
     * subscribing, even if they are not assigned to the task.
     */
    @Test
    void testNotificationForSubscribedUsers() {
        task.getNotifier().subscribe(user1);

        task.getNotifier().subscribe(user2);

        task.setHeader("Get groceries");

        // user1 is expected to have 1 notification
        assertTrue(user1.getNotifications().size() == 1);

        // user2 is expected to have the same notification
        assertTrue(user2.getNotifications().size() == 1);

        // the notification for user1 is expected to have this header
        assertEquals("Task 'Go to grocery store' has changed header to 'Get groceries'",
                user1.getNotifications().get(0).getHeader());
    }
}
