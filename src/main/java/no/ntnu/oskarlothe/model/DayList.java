package no.ntnu.oskarlothe.model;

import java.time.LocalDate;
import java.util.ArrayList;

import no.ntnu.oskarlothe.model.period.Day;

/**
 * A class representing a list of days.
 * The class is useful for navigating the days in the list.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class DayList extends ArrayList<Day> {
    /**
     * Default constructor for the DayList class.
     */
    public DayList() {
        super();
    }

    @Override
    public boolean add(Day day) {
        if (this.containsDayForDate(day.getDate())) return false;

        return super.add(day);
    }

    /**
     * Checks if the list of days contains a day for a spesific date.
     * 
     * @param date date to search for
     * @return true if day with date exists, false if not
     */
    public boolean containsDayForDate(LocalDate date) {
        for (Day day : this) {
            if (day.getDate().equals(date)) return true;
        }

        return false;
    }

    /**
     * Returns the day for the given date.
     * 
     * @param date date of the day
     * @return day for given date, null if no such day is found
     */
    public Day getForDate(LocalDate date) {
        for (Day day : this) {
            if (day.getDate().equals(date)) return day;
        }

        return null;
    }
}
