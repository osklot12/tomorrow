package no.ntnu.oskarlothe.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a list for TaskRepeater objects, containing useful
 * methods for searching and manipulating the repeating tasks.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class RepeatingTaskList {
    private List<TaskRepeater> repeaters;

    /**
     * Default constructor for the RepeatingTaskList class.
     */
    public RepeatingTaskList() {
        this.repeaters = new ArrayList<>();
    }

    /**
     * Constructor for the RepeatingTaskList with a predefined list of TaskRepeater
     * objects.
     * 
     * @param repeaters list of TaskRepeater objects
     */
    public RepeatingTaskList(List<TaskRepeater> repeaters) {
        if (repeaters == null) {
            throw new IllegalArgumentException("List of TaskRepeater objects cannot be null.");
        }

        this.repeaters = repeaters;
    }

    /**
     * Adds a repeater to the list.
     * 
     * @param repeater TaskRepeater object to add
     */
    public void addRepeater(TaskRepeater repeater) {
        if (repeater == null) {
            throw new IllegalArgumentException("Cannot add TaskRepeater, because TaskRepeater is null.");
        }

        this.repeaters.add(repeater);
    }

    /**
     * Returns the list of TaskRepeater objects.
     * 
     * @return list of TaskRepeater objects
     */
    public List<TaskRepeater> getRepeaters() {
        return this.repeaters;
    }

    /**
     * Returns a list of tasks that are repeated on the given date.
     * The method is essential for retrieving repeating tasks and adding them to the
     * correct day. A repeating task is only returned if its startdate is equal to
     * or before the given date.
     * 
     * @param date date to get the tasks for
     * @return a list of tasks for the date
     */
    public List<Task> getTasksForDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }

        List<Task> result = new ArrayList<>();

        String weekday = date.getDayOfWeek().toString().toLowerCase();

        this.repeaters.forEach(
                (repeater) -> {
                    boolean matchesDay = repeater.getDays().stream().anyMatch(day -> day.equalsIgnoreCase(weekday));

                    long weeksBetween = ChronoUnit.WEEKS.between(repeater.getStartDate(), date);

                    boolean matchesWeek = (weeksBetween % repeater.getWeekInterval() == 0);

                    boolean isAfterStartDate = date.isAfter(repeater.getStartDate());

                    boolean sameDate = date.equals(repeater.getStartDate());

                    if (matchesDay && matchesWeek && (sameDate || isAfterStartDate)) {
                        result.add(repeater.getTask());
                    }
                });

        return result;
    }
}
