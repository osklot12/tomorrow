package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * JUnit testing for the HexColorValidator class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class HexColorValidatorTest {
    /**
     * Tests that the isValidColorHex() method returns true given a valid hex color.
     */
    @Test
    void testValidHexColor() {
        assertTrue(HexColorValidator.isValidColorHex("#5d478b"));
    }

    /**
     * Tests that the isValidColorHex() method returns false given an invalid hex
     * color.
     */
    @Test
    void testInvalidHexColor() {
        assertFalse(HexColorValidator.isValidColorHex("#5d478bk"));
        
        assertFalse(HexColorValidator.isValidColorHex("5d478b"));
    }
}
