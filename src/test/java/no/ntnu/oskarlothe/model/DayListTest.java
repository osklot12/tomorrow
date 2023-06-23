package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit testing for the DayList class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class DayListTest {
    Day day1;
    Day day2;
    DayList dayList;

    @BeforeEach
    void setup() {
        LocalDate date = LocalDate.now();
        day1 = new Day(date);
        day2 = new Day(date);
        dayList = new DayList();
    }

    /**
     * Tests that the add() method does not allow addig of multiple days with the
     * same date.
     */
    @Test
    void testAddDuplicate() {
        dayList.add(day1);

        assertFalse(dayList.add(day2));

        assertTrue(dayList.size() == 1);
    }
}
