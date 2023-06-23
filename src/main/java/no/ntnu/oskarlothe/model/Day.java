package no.ntnu.oskarlothe.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import no.ntnu.oskarlothe.model.regionstrategy.RegionStrategy;

/**
 * A class representing an period of 24 hours: a full day.
 * The day class is part of the core concept of the application, as it allows
 * users to assign tasks to individual day, like tomorrow.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class Day extends TaskList implements Period {
    private LocalDate date;

    /**
     * Constructor for the Day class.
     * 
     * @param date the date of the day
     */
    public Day(LocalDate date) {
        super();

        if (date == null) {
            throw new IllegalArgumentException("LocalDate must be defined.");
        }

        this.date = date;
    }

    /**
     * Constructor for the Day class, with a predefined TaskList object.
     * 
     * @param date  the date of the day
     * @param tasks predefined TaskList object
     */
    public Day(LocalDate date, TaskList tasks) {
        super(tasks);

        if (date == null) {
            throw new IllegalArgumentException("LocalDate must be defined.");
        }

        this.date = date;
    }

    /**
     * Returns the date of the day.
     * 
     * @return date of the day
     */
    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public Report generateReport(User creator, LocalDateTime generatedAt) {
        return new Report(creator, generatedAt, this.clone());
    }

    @Override
    public String getPeriodAsString(RegionStrategy region) {
        return region.getDateAsWords(this.date);
    }

    @Override
    public TaskList clone() {
        return new Day(this.getDate(), super.clone());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.date.hashCode();
        result = 31 * result + super.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Day)) {
            return false;
        }

        Day day = (Day) o;
        return this.getDate().equals(day.getDate()) && super.equals(day);
    }
}
