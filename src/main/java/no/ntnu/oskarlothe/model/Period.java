package no.ntnu.oskarlothe.model;

import java.time.LocalDateTime;

import no.ntnu.oskarlothe.model.regionstrategy.RegionStrategy;

/**
 * An interface setting rules for bevahiour on all elements representing a
 * period of time.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public interface Period {
    /**
     * Generates a Report from from the Period object.
     * 
     * @param creator the creator of the report
     * @return a report of the period
     */
    Report generateReport(User creator);

    /**
     * Returns a descriptive text of the Period as String.
     * 
     * @param region the RegionStrategy object used to generate the string
     * @return a string describing the period
     */
    String getPeriodAsString(RegionStrategy region);

    /**
     * Adds a task object to the Period.
     * 
     * @param task the task to add
     * @return true if task is added, false if not
     */
    boolean add(Task task);
}
