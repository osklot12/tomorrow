package no.ntnu.oskarlothe.model.period;

import java.time.LocalDate;
import java.time.LocalDateTime;

import no.ntnu.oskarlothe.model.Report;
import no.ntnu.oskarlothe.model.TaskList;
import no.ntnu.oskarlothe.model.User;
import no.ntnu.oskarlothe.model.WeekdayList;
import no.ntnu.oskarlothe.model.regionstrategy.RegionStrategy;

/**
 * A class representing an interval of time.
 * Instead of being assigned to a single date or point in time, the tasks of an
 * Interval is assigned to multiple points in time, occuring every time the
 * interval hits.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class Interval extends Period {
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
     * Constructor for the Interval class, using a predefined tasklist.
     * 
     * @param tasks the TaskList object to add
     * @param startDate    the starting date for the interval
     * @param weekInterval the amount of weeks between each iteration
     */
    public Interval(TaskList tasks, LocalDate startDate, int weekInterval) {
        super(tasks);

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

    @Override
    public Period copy() {
        return new Interval(this.getTaskList(), startDate, weekInterval);
    }

    @Override
    public Report generateReport(User creator, LocalDateTime generatedAt) {
        return new Report(creator, generatedAt, this);
    }

    @Override
    public String getPeriodAsString(RegionStrategy region) {
        return null;
    }
}
 