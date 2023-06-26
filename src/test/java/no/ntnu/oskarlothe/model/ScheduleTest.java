package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit testing for the Schedule class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class ScheduleTest {
    Schedule schedule;

    Task task1;

    Task task2;

    Task task3;

    RepeatingTask repeater1;

    RepeatingTask repeater2;

    /**
     * Setting up for the following test methods.
     */
    @BeforeEach
    void setup() {
        User user1 = new User("David", "Davidson");

        User user2 = new User("Mark", "Markson");

        User user3 = new User("Peter", "Competer");

        task1 = new Task("Clean the house", "The house needs to be cleaned", user1);

        task2 = new Task("Mow the lawn", "The grass is now very long", user2);

        task3 = new Task("Repair the car", "The left fronlight is out!", user3);

        LocalDate startDate1 = LocalDate.parse("2023-06-05");

        LocalDate startDate2 = LocalDate.parse("2023-06-05");

        Interval interval1 = new Interval(startDate1, 1);

        Interval interval2 = new Interval(startDate2, 2);

        repeater1 = new RepeatingTask("Water the plants", "The plants does seem a bit thirsty.", user3, interval1);

        repeater2 = new RepeatingTask("Change the bedsheets", "Time to change to clean bedsheets.", user2, interval2);

        // task1 is assigned to all users
        task1.assign(user1);

        task1.assign(user2);

        task1.assign(user3);

        // task2 and task3 are only assigned to user 3
        task2.assign(user3);

        task3.assign(user3);

        // adding the tasks to day objects
        LocalDate date1 = LocalDate.parse("2023-06-05");

        Day day1 = new Day(date1);

        day1.add(task1);

        LocalDate date2 = LocalDate.parse("2023-06-12");

        Day day2 = new Day(date2);

        day2.add(task2);

        day2.add(task3);

        // creating the schedule
        schedule = new Schedule();

        schedule.getDayList().add(day1);

        schedule.getDayList().add(day2);

        schedule.getRepeatingTasks().add(repeater1);

        schedule.getRepeatingTasks().add(repeater2);
    }

    /**
     * Tests that the getAllDayTasks() method returns all the tasks held by
     * individual days.
     */
    @Test
    void testGetAllDayTasks() {
        TaskList result = schedule.getAllDayTasks();

        assertTrue(result.contains(task1));

        assertTrue(result.contains(task2));

        assertTrue(result.contains(task3));

        assertFalse(result.contains(repeater1));

        assertFalse(result.contains(repeater2));
    }

    /**
     * Tests that the getAllTasks() method returns all the tasks in the schedule.
     */
    @Test
    void testGetAllTasks() {
        TaskList result = schedule.getAllTasks();

        assertTrue(result.contains(task1));

        assertTrue(result.contains(task2));

        assertTrue(result.contains(task3));

        assertTrue(result.contains(repeater1));

        assertTrue(result.contains(repeater2));

        assertTrue(result.size() == 5);
    }
}
