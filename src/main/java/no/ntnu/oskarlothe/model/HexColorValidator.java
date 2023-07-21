package no.ntnu.oskarlothe.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class responsible for validating hex colors used in the application.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class HexColorValidator {
    /**
     * Checks if the given hex code is a valid hex code for color.
     * 
     * @param hexCode hex color code to check
     * @return true if hex code is valid, false if not
     */
    public static boolean isValidColorHex(String hexCode) {
        String regex = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(hexCode);

        return matcher.matches();
    }
}
