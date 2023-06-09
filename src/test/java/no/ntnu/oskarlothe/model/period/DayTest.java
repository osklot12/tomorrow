package no.ntnu.oskarlothe.model.period;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

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
}
