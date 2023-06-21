package no.ntnu.oskarlothe.model;

import java.time.LocalDate;

import no.ntnu.oskarlothe.model.period.Day;

/**
 * A class responsible for generating days.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class DayGenerator {
    /**
     * Generates a new day based on a day object and a list of repeating tasks.
     * 
     * @param day day object
     * @param repeaters repeating tasks to add to day
     * @return a new day object
     */
    public static Day generate(LocalDate date, DayList days, TaskList repeaters) {
        if (date == null) {
            throw new IllegalArgumentException("LocalDate must be defined.");
        }

        if (repeaters == null) {
            throw new IllegalArgumentException("TaskList must be defined.");
        }

        Day day = days.getForDate(date);
        if (day == null) {
            day = new Day(date);
        } else {
            day = new Day(date, day.getTaskList().copy());
        }

        for (RepeatingTask repeater : repeaters.getRepeatingTasksForDate(date)) {
            day.getTaskList().add(repeater.copy());
        }

        return day;
    }
}
