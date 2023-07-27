package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit testing for the RepeatingTask class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class RepeatingTaskTest {
    RepeatingTask repeater;

    /**
     * Setting up for the following test methods.
     */
    @BeforeEach
    void setup() {
        LocalDate startDate = LocalDate.parse("2023-07-11");

        Interval interval = new Interval(startDate, 2);

        User creator = new User("John", "Johnson");

        repeater = new RepeatingTask("Walk the dog", "The dog gotta pee", creator, interval);
    }

    /**
     * Tests that the getInstance() method returns an object of the
     * RepeatingTaskInstance class, with the same assignment attributes.
     */
    @Test
    void testGetInstance() {
        Assignment instance = repeater.getInstance();

        assertTrue(instance instanceof RepeatingTaskInstance);

        
    }
}
