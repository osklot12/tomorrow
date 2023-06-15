package no.ntnu.oskarlothe.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import no.ntnu.oskarlothe.model.period.Interval;

/**
 * A class repsonsible for nagivating lists of intervals.
 * Intervals containing only a single task is referred to as a repeating task,
 * while Intervals containing multiple tasks is reffered to as plans.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class IntervalList extends ArrayList<Interval> {
    /**
     * Constructor for the IntervalList class.
     */
    public IntervalList() {
        super();
    }

    /**
     * Returns a list of tasks that are repeated on the given date.
     * The method is essential for retrieving repeating tasks or plans for a
     * specific day.
     * <br/>
     * <br/>
     * 
     * @param date date to get the tasks for
     * @return a list of tasks for the date
     */
    public List<Interval> getIntervalsForDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }

        List<Interval> result = new ArrayList<>();

        String weekday = date.getDayOfWeek().toString().toLowerCase();

        this.forEach(
                (interval) -> {
                    boolean matchesDay = interval.getDays().stream().anyMatch(day -> day.equalsIgnoreCase(weekday));

                    long weeksBetween = ChronoUnit.WEEKS.between(interval.getStartDate(), date);

                    boolean matchesWeek = (weeksBetween % interval.getWeekInterval() == 0);

                    boolean isAfterStartDate = date.isAfter(interval.getStartDate());

                    boolean sameDate = date.equals(interval.getStartDate());

                    // the three conditions needs to be met, for interval to match the date
                    if (matchesDay && matchesWeek && (sameDate || isAfterStartDate)) {
                        result.add(interval);
                    }
                });

        return result;
    }
}
