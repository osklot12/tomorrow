package no.ntnu.oskarlothe.model;

import java.time.LocalDate;
import java.util.List;

/**
 * A class representing a list for objects of the RepeatingTask class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class RepeatingTaskList extends AssignmentList<RepeatingTask> {
    /**
     * Constructor for the RepeatingTaskList class.
     */
    public RepeatingTaskList() {
        super();
    }

    /**
     * Constructor for the RepeatingTaskList class with a predefined list of
     * repeating tasks.
     * 
     * @param repeaters
     */
    public RepeatingTaskList(List<RepeatingTask> repeaters) {
        super(repeaters);
    }

    @Override
    public boolean add(RepeatingTask repeater) {
        return super.add(repeater);
    }

    /**
     * Returns all repeating tasks in the list that hits a certain date.
     * 
     * @param date the date to search for
     * @return a list of repeating tasks
     */
    public RepeatingTaskList getRepeatingTasksForDate(LocalDate date) {
        RepeatingTaskList result = new RepeatingTaskList();

        for (RepeatingTask repeater : this) {
            if (repeater.getInterval().hitsDate(date))
                result.add(repeater);
        }

        return result;
    }

    @Override
    public RepeatingTaskList clone() {
        return new RepeatingTaskList(this);
    }
}
