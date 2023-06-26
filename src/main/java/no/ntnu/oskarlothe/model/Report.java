package no.ntnu.oskarlothe.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * A class representing a report for a spesific period of time.
 * The Report class holds an instance of a period object that represents the
 * state of that period object at an instance in time.
 * In other words, the report holds information about a period object at a
 * spesific time.
 * <br/>
 * <br/>
 * Reports can not only be generated for individual days, but also instances of
 * the Interval class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class Report {
    private User creator;

    private LocalDateTime generatedAt;

    private TaskList taskList;

    /**
     * Constructor for the Report class.
     * 
     * @param creator     the creator of the report
     * @param generatedAt the time at which the report was generated
     * @param taskList      the period of time to report
     */
    public Report(User creator, TaskList taskList) {
        if (creator == null) {
            throw new IllegalArgumentException("Creator cannot be null.");
        }

        if (taskList == null) {
            throw new IllegalArgumentException("Period cannot be null.");
        }

        this.creator = creator;
        this.generatedAt = LocalDateTime.now();
        this.taskList = taskList;
    }

    /**
     * Returns the creator of the report.
     * 
     * @return creator of report
     */
    public User getCreator() {
        return this.creator;
    }

    /**
     * Returns the time the report was generated.
     * 
     * @return LocalDateTime of when report was generated
     */
    public LocalDateTime getTimeOfCreation() {
        return this.generatedAt;
    }

    /**
     * Returns the TaskList of the report.
     * 
     * @return TaskList of report
     */
    public TaskList getTaskList() {
        return this.taskList;
    }
}
