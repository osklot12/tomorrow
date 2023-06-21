package no.ntnu.oskarlothe.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * A class representing an interval of time.
 * An instance of the Interval class has a set start date, which defines the
 * starting date of the interval, as well as a weekday list and week interval,
 * both deciding when which days the interval hits.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class Interval {
    private LocalDate startDate;

    private WeekdayList days;

    private int weekInterval;

    /**
     * Constructor for the Interval class.
     * 
     * @param startDate    the starting date for the interval
     * @param weekInterval the amount of weeks between each iteration
     */
    public Interval(LocalDate startDate, int weekInterval) {
        super();

        if (startDate == null) {
            throw new IllegalArgumentException("Start date cannot be null.");
        }

        if (weekInterval < 1) {
            throw new IllegalArgumentException("Week interval cannot be smaller than 1.");
        }

        this.startDate = startDate;
        this.days = new WeekdayList();
        this.weekInterval = weekInterval;
    }

    /**
     * Returns the start date of the interval.
     * 
     * @return start date
     */
    public LocalDate getStartDate() {
        return this.startDate;
    }

    /**
     * Returns the weekdays of the interval.
     * 
     * @return weekdays of the interval
     */
    public WeekdayList getDays() {
        return this.days;
    }

    /**
     * Returns the amount of weeks between each iteration.
     * 
     * @return week interval
     */
    public int getWeekInterval() {
        return this.weekInterval;
    }

    /**
     * Adds a weekday to the interval.
     * 
     * @param weekday weekday to add
     * @return true if added successfully, false if not
     */
    public boolean addWeekday(String weekday) {
        return this.days.add(weekday);
    }

    /**
     * Removes a weekday from the interval.
     * 
     * @param weekday weekday to remove
     * @return true if removed successfully, false if not
     */
    public boolean removeWeekday(String weekday) {
        return this.days.remove(weekday);
    }

    /**
     * Checks wheter the repeating task hits a certain date.
     * 
     * @param date the date to check for
     * @return true if task hits, false if not
     */
    public boolean hitsDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }

        LocalDate intervalStartDate = this.getStartDate();

        boolean isAfterOrOn = date.isAfter(intervalStartDate) || date.equals(intervalStartDate);

        String weekday = date.getDayOfWeek().toString();

        boolean hitsDay = this.days.containsIgnoreCase(weekday);

        long weeksBetween = ChronoUnit.WEEKS.between(intervalStartDate, date);

        boolean hitsWeek = (weeksBetween % this.getWeekInterval() == 0);

        return (isAfterOrOn && hitsDay && hitsWeek);
    }
}
