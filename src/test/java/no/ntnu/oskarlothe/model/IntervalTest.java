package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit testing for the Interval class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class IntervalTest {
    Interval interval;

    /**
     * Setting up for the following test methods.
     */
    @BeforeEach
    void setup() {
        LocalDate startDate = LocalDate.parse("2023-06-05");
        interval = new Interval(startDate, 2);
        interval.addWeekday("monday");
        interval.addWeekday("friday");
    }

    /**
     * Tests that the hitsDate() method returns true if the interval hits a
     * certain date.
     */
    @Test
    void testHitsDateTrue() {
        LocalDate hitDate1 = LocalDate.parse("2023-06-09");
        LocalDate hitDate2 = LocalDate.parse("2023-06-19");

        assertTrue(interval.hitsDate(hitDate1));
        assertTrue(interval.hitsDate(hitDate2));
    }

    /**
     * Tests that the hitsDate() method returns false if the interval does not
     * hit a certain date.
     */
    @Test
    void testHitsDateFalse() {
        LocalDate hitDate1 = LocalDate.parse("2023-06-06");
        LocalDate hitDate2 = LocalDate.parse("2023-06-12");

        assertFalse(interval.hitsDate(hitDate1));
        assertFalse(interval.hitsDate(hitDate2));
    }
}
