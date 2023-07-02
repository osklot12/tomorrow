package no.ntnu.oskarlothe.model.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.ntnu.oskarlothe.model.Task;
import no.ntnu.oskarlothe.model.User;

/**
 * JUnit testing for the TaskCompletedNotification class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskCompletedNotificationTest {
    Task task;

    User user1;

    User user2;

    /**
     * Setting up for the following test methods.
     */
    @BeforeEach
    void setup() {
        User creator = new User("John", "Johnson");

        task = new Task("Walk the dog", "The dog really needs to pee.", creator);

        user1 = new User("Mickey", "Mouse");

        user2 = new User("Minnie", "Mouse");
    }

    /**
     * Tests that users assigned to a task will get a notification when the task is
     * completed.
     */
    @Test
    void testNotificationForAssignedUsers() {
        task.assign(user1);

        task.assign(user2);

        // unsubscribes user2 from the notifier, which means user2 should not recieve
        // the notification
        task.getNotifier().unsubscribe(user2);

        task.doTask(user1);

        assertTrue(user1.getNotifications().size() == 1);

        assertEquals("The task 'Walk the dog' has been completed by Mickey Mouse",
                user1.getNotifications().get(0).getHeader());

        assertTrue(user2.getNotifications().size() == 0);
    }
}
