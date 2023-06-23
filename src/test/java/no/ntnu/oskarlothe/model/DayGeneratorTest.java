package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit testing for the DayGenerator class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class DayGeneratorTest {
    Day day1;

    DayList dayList;

    LocalDate dayDate;

    Task task1;

    Task task2;

    RepeatingTask repeater1;

    RepeatingTask repeater2;

    TaskList repeaters;

    /**
     * Setting up for the following test methods.
     */
    @BeforeEach
    void setup() {
        User creator = new User("John", "Johnson", "Johnny");
        task1 = new Task("Do the dishes", "The dishes needs to be done by the end of the day.", creator);
        task2 = new Task("Empty garbage", "The garbage bin is too full now.", creator);

        TaskList list = new TaskList();
        list.add(task1);
        list.add(task2);

        dayDate = LocalDate.parse("2023-06-12");

        day1 = new Day(dayDate, list);

        dayList = new DayList();
        dayList.add(day1);

        LocalDate startDate1 = LocalDate.parse("2023-05-29");
        Interval interval1 = new Interval(startDate1, 2);
        interval1.addWeekday("monday");
        Interval interval2 = new Interval(startDate1, 3);
        interval2.addWeekday("sunday");
        repeater1 = new RepeatingTask("Walk the dog", "The dog needs to pee u know!", creator, interval1);
        repeater2 = new RepeatingTask("Water the plants", "Your plants are dying!", creator, interval2);

        repeaters = new TaskList();
        repeaters.add(repeater1);
        repeaters.add(repeater2);
    }

    /**
     * Tests that the generateDay() method generates a day with data from a previous
     * day.
     */
    @Test
    void testGenerateDayExistingDay() {
        Day day2 = DayGenerator.generate(dayDate, dayList, repeaters);

        // checks that the date is correct
        assertTrue(day2.getDate().equals(dayDate));

        // checks that the day contains repeatingtask 1
        assertTrue(day2.contains(repeater1));

        // checks that the day does not contain repeatingtask 2
        assertFalse(day2.contains(repeater2));

        // checks that the day contains task1
        assertTrue(day2.contains(task1));

        // checks that the day contains task2
        assertTrue(day2.contains(task2));

        // making sure a change to the new day does not change the original day
        day2.remove(task1);

        // day 1 should still hold task1, since we only removed it from day2
        assertTrue(day1.contains(task1));
    }

    /**
     * Tests that the generateDay() method generates a day even if no data from a
     * previous day is found.
     */
    @Test
    void testGenerateDayDeadDay() {
        LocalDate newDate = LocalDate.parse("2023-06-04");

        Day day2 = DayGenerator.generate(newDate, dayList, repeaters);

        // checks that day2 contains the proper repeating task
        assertTrue(day2.contains(repeater2));

        // checks that day2 does not contain the wrong repeating task
        assertFalse(day2.contains(repeater1));

        // checks that day 2 does not contain any of the tasks from day1, since the date is different
        assertFalse(day2.contains(task1));

        assertFalse(day2.contains(task2));
    }
}
