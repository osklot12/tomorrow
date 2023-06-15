package no.ntnu.oskarlothe.model;

import java.util.ArrayList;

/**
 * A class representing a list of Days.
 * The WeekdayList class only allows valid weekdays, as well as only one
 * instance of each weekday.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class WeekdayList extends ArrayList<String> {
    private static final String[] VALID_WEEKDAYS = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
            "Sunday" };

    @Override
    public boolean add(String weekday) {
        if (isValidWeekday(weekday) && !(this.contains(weekday.toLowerCase()))) {
            return super.add(weekday.toLowerCase());
        }

        return false;
    }

    /**
     * Checks wheter the string given is a valid weekday or not.
     * 
     * @param weekday string to be checked
     * @return true if valid, false if not
     */
    private boolean isValidWeekday(String weekday) {
        for (String validWeekday : VALID_WEEKDAYS) {
            if (validWeekday.equalsIgnoreCase(weekday)) {
                return true;
            }
        }
        return false;
    }
}
