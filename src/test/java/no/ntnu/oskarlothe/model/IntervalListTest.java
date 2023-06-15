package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import no.ntnu.oskarlothe.model.period.Interval;

/**
 * JUnit testing for the IntervaList class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class IntervalListTest {
    /**
     * Tests that the getIntervalsForDate() method returns the expected intervals;
     * the ones that hit the given date.
     */
    @Test
    void testGetIntervalsForDate() {
        LocalDate date1 = LocalDate.parse("2023-06-15");
        LocalDate date2 = LocalDate.parse("2023-06-08");
        LocalDate date3 = LocalDate.parse("2023-06-01");

        Interval interval1 = new Interval(date3, 2);
        interval1.addWeekday("thursday");

        Interval interval2 = new Interval(date3, 1);
        interval2.addWeekday("thursday");

        IntervalList intervalList = new IntervalList();
        intervalList.add(interval1);
        intervalList.add(interval2);

        // tests that interval1 is returned, as the interval will hit date1
        assertTrue(intervalList.getIntervalsForDate(date1).contains(interval1));
        
        // same case for this one
        assertTrue(intervalList.getIntervalsForDate(date1).contains(interval2));

        // this one should not be returned, as the interval only hits every other week
        // date2 contains the date on the second week on the interval
        assertFalse(intervalList.getIntervalsForDate(date2).contains(interval1));
    }
}
