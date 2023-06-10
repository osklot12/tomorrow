package no.ntnu.oskarlothe.model.period;

import java.time.LocalDate;
import java.time.LocalDateTime;

import no.ntnu.oskarlothe.model.Report;
import no.ntnu.oskarlothe.model.TaskList;
import no.ntnu.oskarlothe.model.User;

/**
 * A class representing an period of 24 hours: a full day.
 * The day class is part of the core concept of the application, as it allows
 * users to assign tasks to individual day, like tomorrow.
 * <br/>
 * <br/>
 * The Day class extends from the Period class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class Day extends Period {
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
     * Constructor for the Day class, with an predefined TaskList object.
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
        return new Report(creator, generatedAt, this.copy());
    }

    @Override
    public String getPeriodAsString() {
        return null;
    }

    @Override
    public Period copy() {
        return new Day(this.getDate(), this.getTaskList().copy());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.date.hashCode();
        result = 31 * result + this.getTaskList().hashCode();
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
        return this.getDate().equals(day.getDate()) && this.getTaskList().equals(day.getTaskList());
    }
}
