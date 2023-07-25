package no.ntnu.oskarlothe.model;

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
    LocalDate date1;

    LocalDate date2;

    LocalDate date3;

    Task task1;

    Task task2;

    RepeatingTask repeater1;

    RepeatingTask repeater2;

    Schedule schedule;

    @BeforeEach
    void setup() {
        User creator = new User("John", "Johnson");

        // creating localdate objects
        date1 = LocalDate.parse("2023-07-11");

        date2 = LocalDate.parse("2023-07-18");

        date3 = LocalDate.parse("2023-07-25");

        // creating task objects
        task1 = new Task("Finish homework", "Finish your math homework", creator);

        task2 = new Task("Walk the dog", "The dog needs to pee you know?!", creator);

        // creating day objects
        Day day1 = new Day(date3);

        day1.add(task1);

        Day day2 = new Day(date2);

        day2.add(task2);

        // creating intervals and repeatingtask objects
        Interval interval1 = new Interval(date1, 2);

        interval1.addWeekday("tuesday");

        Interval interval2 = new Interval(date2, 2);

        interval2.addWeekday("tuesday");

        interval2.addWeekday("friday");

        repeater1 = new RepeatingTask("Clean the bathroom", "Clean the bathroom with water and soap",
                creator, interval1);

        repeater2 = new RepeatingTask("Empty garbage", "Empty the garbage before it gets full", creator,
                interval2);

        // creating the schedule object
        schedule = new Schedule();

        schedule.addDay(day1);

        schedule.addDay(day2);

        schedule.addRepeatingTask(repeater1);

        schedule.addRepeatingTask(repeater2);
    }

    /**
     * Tests that the getDay() method returns a day as expected.
     * The day is expected to contain all the tasks registered to the day, as well
     * as instances of repeating tasks hitting the date of the day.
     */
    @Test
    void testGetDay1() {
        Day generatedDay = schedule.getDay(date3);

        assertTrue(generatedDay.contains(task1));

        assertTrue(generatedDay.contains(repeater1.getInstance()));
    }

    /**
     * Tests that the getDay() method returns a day as expected.
     * In this test, no day is currently available for the date in the schedule,
     * which means that the generator has to create a new day.
     */
    @Test
    void testGetDay2() {
        Day generatedDay = schedule.getDay(date1);

        assertTrue(generatedDay.contains(repeater1.getInstance()));

        assertTrue(generatedDay.size() == 1);
    }
}
