package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        assertEquals("Task header must be defined.", exception.getMessage());
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
}
