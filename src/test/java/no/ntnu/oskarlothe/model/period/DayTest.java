package no.ntnu.oskarlothe.model.period;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import no.ntnu.oskarlothe.model.Report;
import no.ntnu.oskarlothe.model.Task;
import no.ntnu.oskarlothe.model.User;

/**
 * JUnit testing for the Day class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class DayTest {
    /**
     * Tests if the getDate() method returns the date of the Day as expected.
     */
    @Test
    void testGetDate() {
        LocalDate date = LocalDate.now();
        Day day = new Day(date);

        LocalDate actualDate = day.getDate();
        assertEquals(date, actualDate);
    }

    /**
     * Tests that the getTaskList from the super class Period, returns the TaskList
     * as expected.
     */
    @Test
    void testGetTaskList() {
        LocalDate date = LocalDate.now();
        Day day = new Day(date);

        assertFalse(day.getTaskList() == null);
    }

    /**
     * Tests that the generateReport() method returns a report object as expected.
     * Also tests that the report generated does not change as the day object
     * change, since a report should represent the state of the day at a spesific
     * instance.
     */
    @Test
    void testGenerateReport() {
        LocalDate date = LocalDate.now();
        User user = new User("John", "Johnson");
        LocalDateTime timestamp = LocalDateTime.now();
        Day day = new Day(date);

        Report report = day.generateReport(user, timestamp);

        // since the period returned by the report is a copy of the original period,
        // they should be equal at this moment
        assertEquals(day, report.getPeriod());

        Task task = new Task("Do laundry", "Do the laundry already!", user);
        day.getTaskList().add(task);

        // now that the original period has changed, the two should not be equal
        assertNotEquals(day, report.getPeriod());
    }
}
