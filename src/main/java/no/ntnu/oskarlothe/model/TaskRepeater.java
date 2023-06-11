package no.ntnu.oskarlothe.model;

import java.time.LocalDate;
import java.util.List;

/**
 * A class responsible for assigning a spesific time a task should be repeated,
 * making it possible to get automatic tasks every monday for example.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskRepeater {
    private Task task;

    private List<String> days;

    private int weekInterval;

    private LocalDate startDate;

    /**
     * Constructor for the TaskRepeater class.
     * 
     * @param task         the task to repeat
     * @param day          the day the task should be repeated
     * @param weekInterval the interval between each week the task should be
     *                     repeated
     * @param startDate    the date the repeating task starts
     */
    public TaskRepeater(Task task, List<String> days, int weekInterval, LocalDate startDate) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }

        if (days.size() < 1) {
            throw new IllegalArgumentException("Repeating task must be assigned to at least one day.");
        }

        if (weekInterval < 1) {
            throw new IllegalArgumentException("Cannot have a week interval smaller than 1.");
        }

        if (startDate == null) {
            throw new IllegalArgumentException("LocalDate startDate cannot be null.");
        }

        this.task = task;
        this.days = days;
        this.weekInterval = weekInterval;
        this.startDate = startDate;
    }

    /**
     * Returns the list of days the task is assigned to.
     * 
     * @return list of days as strings
     */
    public List<String> getDays() {
        return this.days;
    }

    /**
     * Returns the task to be repeated.
     * 
     * @return task object
     */
    public Task getTask() {
        return this.task;
    }

    /**
     * Returns the week interval value.
     * 
     * @return week interval as int
     */
    public int getWeekInterval() {
        return this.weekInterval;
    }

    /**
     * Returns the starting date of the repeating task.
     * 
     * @return date of start
     */
    public LocalDate getStartDate() {
        return this.startDate;
    }
}
