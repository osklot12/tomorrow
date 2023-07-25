package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * JUnit testing for the Task class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskTest {
    /**
     * Tests that a creation of a task instance is done successfully, using valid
     * arguments.
     */
    @Test
    void testCreationOfTaskValidArguments() {
        User creator = new User("The Creator", "Himself", "Developer");
        String header = "The main task";
        String content = "This is the main big task!";
        Task task = new Task(header, content, creator);

        String actualHeader = task.getHeader();
        String actualContent = task.getContent();
        User actualCreator = task.getCreator();

        assertEquals(header, actualHeader);
        assertEquals(content, actualContent);
        assertEquals(creator, actualCreator);
    }

    /**
     * Tests that an attempt to create an instance of Task class using illegal
     * header argument, throws an exception.
     */
    @Test
    void testCreationOfTaskWithInvalidHeader() {
        User creator = new User("The Creator", "Himself", "Developer");
        String header = "   ";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Task(header, "", creator));

        assertEquals("Assignment header must be defined.", exception.getMessage());
    }

    /**
     * Tests if the matchHeader() method returns true if the header of two tasks
     * matches, ignoring uppercase letters.
     */
    @Test
    void testMatchHeader() {
        User creator = new User("The Creator", "Himself", "Developer");
        Task task1 = new Task("TestHeader", "Some content", creator);
        Task task2 = new Task("Testheader", "Some other content", creator);

        boolean matching = task1.matchHeader(task2);

        assertTrue(matching);
    }

    /**
     * Tests that the assign() method returns true is a user is successfully
     * assigned to the task.
     */
    @Test
    void testAssignTrue() {
        User creator = new User("John", "Johnson");

        Task task = new Task("Do the dishes", "Time to do the dishes now!", creator);

        User user = new User("Mark", "SuckerBerg");

        boolean assigned = task.assign(user);

        assertTrue(assigned);

        boolean userAdded = task.getAssignees().contains(user);

        assertTrue(userAdded);
    }

    /**
     * Tests that the assign() method returns false if a user already exists as an
     * assignee, and that the method does not assign the user.
     */
    @Test
    void testAssignFalse() {
        User creator = new User("John", "Johnson");

        Task task = new Task("Do the dishes", "Time to do the dishes now!", creator);

        User user = new User("Mark", "SuckerBerg");

        task.assign(user);

        boolean assigned = task.assign(user);

        assertFalse(assigned);

        assertTrue(task.getAssignees().size() == 1);
    }

    /**
     * Tests that the unassign() method returns true is a user is successfully
     * unassigned.
     */
    @Test
    void testUnassignTrue() {
        User creator = new User("John", "Johnson");

        Task task = new Task("Do the dishes", "Time to do the dishes now!", creator);

        User user = new User("Mark", "SuckerBerg");

        task.assign(user);

        boolean unassigned = task.unassign(user);

        assertTrue(unassigned);

        assertFalse(task.getStatus().getAssignees().contains(user));
    }

    /**
     * Tests that the unassign() method returns false if a user is not unassigned,
     * due to the user not existing as an assignee.
     */
    @Test
    void testUnassignFalse() {
        User creator = new User("John", "Johnson");

        Task task = new Task("Do the dishes", "Time to do the dishes now!", creator);

        User user = new User("Mark", "SuckerBerg");

        boolean unassigned = task.unassign(user);

        assertFalse(unassigned);
    }
}
