package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * JUnit testing for the RepeatingTaskList class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class RepeatingTaskListTest {
    /**
     * Tests that the addRepeater() method works as expected.
     */
    @Test
    void testAddRepeater() {
        RepeatingTaskList list = new RepeatingTaskList();

        LocalDate date = LocalDate.now();

        User creator = new User("John", "Johnson");
        Task task = new Task("This is the task header", "This is the content of the creator", creator);

        List<String> days = new ArrayList<>();
        days.add("Monday");

        TaskRepeater repeater = new TaskRepeater(task, days, 4, date);

        list.addRepeater(repeater);

        assertTrue(list.getRepeaters().contains(repeater));
    }

    /**
     * Tests that the getTasksForDate() method returns repeating tasks for a
     * spesific date as expected.
     */
    @Test
    void testGetTasksForDate() {
        User creator = new User("John", "Johnson");

        Task task1 = new Task("Clean your room", "You need to clean up all the items on your floor", creator);

        Task task2 = new Task("Do dishes", "Remember to do the dishes for you leave the house!", creator);

        Task task3 = new Task("Walk the dog", "The dog needs to poop you know!", creator);

        List<String> task1Days = new ArrayList<>();

        List<String> task2Days = new ArrayList<>();

        List<String> task3Days = new ArrayList<>();

        task1Days.add("Monday");

        task1Days.add("Tuesday");

        task2Days.add("Thursday");

        task2Days.add("Monday");

        task3Days.add("Monday");

        LocalDate startDate1 = LocalDate.parse("2023-06-12");

        LocalDate startDate2 = LocalDate.parse("2023-06-05");

        LocalDate startDate3 = LocalDate.parse("2023-05-29");

        LocalDate targetDate = LocalDate.parse("2023-06-05");

        // creating a TaskRepeater object containing task1, repeated for monday and tuesday, every week
        TaskRepeater repeater1 = new TaskRepeater(task1, task1Days, 1, startDate1);

        // creating a TaskRepeater object containing task2, repeated for thursday and monday, every other week
        TaskRepeater repeater2 = new TaskRepeater(task2, task2Days, 2, startDate2);

        // creating a TaskRepeater object containing task3, repeated for only monday, every third week
        TaskRepeater repeater3 = new TaskRepeater(task3, task3Days, 3, startDate3);

        RepeatingTaskList list = new RepeatingTaskList();

        list.addRepeater(repeater1);

        list.addRepeater(repeater2);

        list.addRepeater(repeater3);

        List<Task> result = list.getTasksForDate(targetDate);

        assertTrue(result.contains(task2));

        assertFalse(result.contains(task1));

        assertFalse(result.contains(task3));
    }
}
