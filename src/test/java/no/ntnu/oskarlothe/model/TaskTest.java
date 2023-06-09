package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
