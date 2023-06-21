package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.ntnu.oskarlothe.model.period.Day;

/**
 * JUnit testing for the DayNavigator class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class DayNavigatorTest {
    LocalDate date1;

    Day day1;

    Day day2;

    Schedule schedule;

    /**
     * Setting up before the following test methods.
     */
    @BeforeEach
    void setup() {
        schedule = new Schedule();

        date1 = LocalDate.parse("2023-06-05");
        LocalDate date2 = LocalDate.parse("2023-06-06");

        day1 = new Day(date1);
        day2 = new Day(date2);

        User creator = new User("John", "Johnson", "Johnny");
        Task task1 = new Task("Walk the dog", "The dog needs to pee", creator);
        Task task2 = new Task("Clean the house", "The house is really messy!", creator);

        day1.getTaskList().add(task1);
        day2.getTaskList().add(task2);

        schedule.getDayList().add(day1);
        schedule.getDayList().add(day2);
    }

    /**
     * Tests that the next() method returns the day for the next date.
     */
    @Test
    void testNext() {
        DayNavigator dayNavigator = new DayNavigator(date1, schedule);

        assertEquals(day2, dayNavigator.next());
    }

    /**
     * Tests that the previous() method returns the day for the previous day.
     */
    @Test
    void testPrevious() {
        DayNavigator dayNavigator = new DayNavigator(date1, schedule);

        dayNavigator.next();

        assertEquals(day1, dayNavigator.previous());
    }
}
