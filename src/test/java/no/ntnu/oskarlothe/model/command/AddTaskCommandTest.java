package no.ntnu.oskarlothe.model.command;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import no.ntnu.oskarlothe.model.Day;
import no.ntnu.oskarlothe.model.Task;
import no.ntnu.oskarlothe.model.User;

/**
 * JUnit testing for the AddTaskCommand class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class AddTaskCommandTest {
    /**
     * Tests that the execute() method adds a task to a period as expected.
     */
    @Test
    void testExecute() {
        User creator = new User("John", "Johnson");

        Task task = new Task("Mop floor", "Remember to mop under furniture as well!", creator);

        LocalDate date = LocalDate.now();

        Day day = new Day(date);
        
        AddTaskCommand command = new AddTaskCommand(task, day);
        
        command.execute();

        assertTrue(day.contains(task));
    }
}
