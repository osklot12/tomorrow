package no.ntnu.oskarlothe.model.period;

import java.time.LocalDate;

import no.ntnu.oskarlothe.model.Report;

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
     */
    public Day(LocalDate date) {
        super();

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

    public Report generateReport() {
        return null;
    }
}
