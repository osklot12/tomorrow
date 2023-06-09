package no.ntnu.oskarlothe.model.interval;

import java.time.LocalDate;

/**
 * A class representing an interval of 24 hours: a full day.
 * The day class is part of the core concept of the application, as it allows
 * users to assign tasks to individual day, like tomorrow.
 * <br/>
 * <br/>
 * An instance of the Day class holds a localDate object from java.time, as well
 * as a list of tasks. Useful methods for manipulating the list of tasks is also
 * held by the class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class Day {
    private LocalDate date;

}
