package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import no.ntnu.oskarlothe.model.exception.NoSuchUserException;
import no.ntnu.oskarlothe.model.exception.TaskAlreadyCompletedException;
import no.ntnu.oskarlothe.model.exception.UserAlreadyExistsException;

/**
 * JUnit testing for the TaskStatus class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskStatusTest {
    /**
     * Tests the assign() method with a new user, and checks if the user will be
     * successfully added.
     */
    @Test
    void testAssignNewUser() {
        TaskStatus status = new TaskStatus();
        User user = new User("John", "Johnson");

        status.assign(user);

        assertEquals(user, status.getAssignees().get(0));
    }

    /**
     * Tests that the assign() method with an existing user, will throw an
     * exception.
     */
    @Test
    void testAssignExistingUser() {
        TaskStatus status = new TaskStatus();
        User user = new User("John", "Johnson");

        status.assign(user);

        Throwable exception = assertThrows(UserAlreadyExistsException.class,
                () -> status.assign(user));

        assertEquals("User is already assigned.", exception.getMessage());
    }

    /**
     * Tests that the unassign() method with a user that is already assigned,
     * successfully removes the user from the assignees list.
     */
    @Test
    void testUnassignExistingUser() {
        TaskStatus status = new TaskStatus();
        User user = new User("John", "Johnson");

        status.assign(user);
        status.unassign(user);

        assertFalse(status.getAssignees().contains(user));
    }

    /**
     * Tests that the unassign() method trying to unassign a user that is not
     * already assigned, throws an exception.
     */
    @Test
    void testUnassignNoSuchUser() {
        TaskStatus status = new TaskStatus();
        User user = new User("John", "Johnson");
        User dummyUser = new User("John", "Davidson");

        status.assign(user);
        Throwable exception = assertThrows(NoSuchUserException.class,
                () -> status.unassign(dummyUser));

        assertEquals("The user is not assigned to the task.", exception.getMessage());
    }

    /**
     * Tests that the complete() method adds the given user as the completer, when
     * the given user is assigned to the task.
     */
    @Test
    void testCompleteWithValidUser() {
        TaskStatus status = new TaskStatus();
        User user = new User("John", "Johnson");

        status.assign(user);
        status.complete(user);

        assertEquals(user, status.getCompleter());
    }

    /**
     * Tests that the complete() method with a user that is not assigned to the
     * task, throws an exception.
     */
    @Test
    void testCompleteWithInvalidUser() {
        TaskStatus status = new TaskStatus();
        User user = new User("John", "Johnson");
        User dummyUser = new User("John", "Davidson");

        status.assign(user);
        Throwable exception = assertThrows(NoSuchUserException.class,
                () -> status.complete(dummyUser));

        assertEquals("The user is not assigned to the task.", exception.getMessage());
    }

    /**
     * Tests that the complete() method throws an exception if task is already
     * completed.
     */
    @Test
    void testCompleteAlreadyCompleted() {
        TaskStatus status = new TaskStatus();
        User user = new User("John", "Johnson");

        status.assign(user);
        status.complete(user);
        Throwable exception = assertThrows(TaskAlreadyCompletedException.class,
                () -> status.complete(user));

        assertEquals("Another user has already completed the task.", exception.getMessage());
    }
}
