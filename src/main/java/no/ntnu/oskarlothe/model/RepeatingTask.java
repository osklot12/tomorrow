package no.ntnu.oskarlothe.model;

/**
 * A class representing a repeating task.
 * An instance of the RepeatingTask class contains a task and an interval.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class RepeatingTask extends Task {
    private Interval interval;

    /**
     * Default constructor for the RepeatingTask class.
     * 
     * @param header  the header of the repeating task
     * @param content the descriptive text of the repeating task
     * @param creator the user that created the repeating task
     * @param interval the interval of the repeating task
     */
    public RepeatingTask(String header, String content, User creator, Interval interval) {
        super(header, content, creator);

        if (interval == null) {
            throw new IllegalArgumentException("Interval must be defined.");
        }

        this.interval = interval;
    }

    /**
     * Returns the interval of the repeating task.
     * 
     * @return interval of task
     */
    public Interval getInterval() {
        return this.interval;
    }
}
