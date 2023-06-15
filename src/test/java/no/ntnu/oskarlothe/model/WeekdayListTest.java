package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * JUnit testing for WeekdayList class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class WeekdayListTest {
    /**
     * Tests that the add() method adds a weekday to the list as expected.
     * This method also tests the isValidWeekday() as well,
     * since the add() method uses it.
     */
    @Test
    void testAddSuccess() {
        WeekdayList list = new WeekdayList();

        assertTrue(list.add("monday"));
    }

    /**
     * Tests that the add() method does not add a string that is not valid.
     */
    @Test
    void testAddNotValid() {
        WeekdayList list = new WeekdayList();

        assertFalse(list.add("chair"));
    }

    /**
     * Tests that the add() method does not add a string that already exists in the list.
     */
    @Test
    void testAddAlreadyExists() {
        WeekdayList list = new WeekdayList();

        list.add("friday");

        assertFalse(list.add("friday"));
    }
}
