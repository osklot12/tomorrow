package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit testing for the ScheduleCleaner class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class ScheduleCleanerTest {
    Schedule schedule;

    ScheduleCleaner scheduleCleaner;

    User user1;

    User user2;

    User user3;

    Task task1;

    Task task2;

    Task task3;

    RepeatingTask repeater1;

    UserList users;

    /**
     * Setting up for the following test methods.
     */
    @BeforeEach
    void setup() {
        user1 = new User("David", "Davidson");

        user2 = new User("Mark", "Markson");

        user3 = new User("Peter", "Competer");

        users = new UserList();

        users.add(user1);

        users.add(user2);

        users.add(user3);

        task1 = new Task("Clean the house", "The house needs to be cleaned", user1);

        task2 = new Task("Mow the lawn", "The grass is now very long", user2);

        task3 = new Task("Repair the car", "The left fronlight is out!", user3);

        Interval interval1 = new Interval(LocalDate.parse("2023-06-13"), 2);

        repeater1 = new RepeatingTask("Water the plants", "Water all plants except the cactuses.", user1, interval1);

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
        Schedule schedule = new Schedule();

        schedule.getDayList().add(day1);

        schedule.getDayList().add(day2);

        schedule.getRepeatingTasks().add(repeater1);

        // creating the schedulecleaner
        scheduleCleaner = new ScheduleCleaner(schedule);
    }

    /**
     * Tests that the getDeadDayTasks() method actually returns a list of all dead
     * tasks in a schedule.
     */
    @Test
    void testGetDeadDayTasks() {
        // removing user3 will make task2 and task3 dead
        users.remove(user3);

        TaskList tasks = scheduleCleaner.getDeadTasks(users);

        assertTrue(tasks.contains(task2));

        assertTrue(tasks.contains(task3));

        assertTrue(tasks.contains(repeater1));

        assertFalse(tasks.contains(task1));
    }
}
