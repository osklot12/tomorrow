package no.ntnu.oskarlothe.model.regionstrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

/**
 * JUnit testing for the NoRegionStrategy class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class NoRegionStrategyTest {
    /**
     * Tests that the getDateAsNumbers() method returns the expected string.
     */
    @Test
    void testGetDateAsNumbers() {
        NoRegionStrategy region = new NoRegionStrategy();
        LocalDate date = LocalDate.parse("2023-06-10");

        String formattedString = region.getDateAsNumbers(date);

        assertEquals("10.06.2023", formattedString);
    }

    /**
     * Tests that the getDateAsWords() method returns the expected string.
     */
    @Test
    void testGetDateAsWords() {
        NoRegionStrategy region = new NoRegionStrategy();
        LocalDate date = LocalDate.parse("2023-06-10");

        String formattedString = region.getDateAsWords(date);

        assertEquals("Saturday, 10. June 2023", formattedString);
    }
}
