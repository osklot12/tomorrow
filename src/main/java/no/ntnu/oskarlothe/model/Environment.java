package no.ntnu.oskarlothe.model;

/**
 * A class representing an Environment in the application.
 * The Environment class is responsible for managing the schedule and users as
 * well as actions related to the two.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class Environment {
    private String name;

    private Schedule schedule;

    private UserList users;

    /**
     * Constructor for the Environment class.
     * 
     * @param name     the name of the environment
     * @param schedule the schedule of the enviroment
     */
    public Environment(String name, Schedule schedule, UserList users) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name of the environment must be defined.");
        }

        if (schedule == null) {
            throw new IllegalArgumentException("Schedule of the environment must be defined.");
        }

        if (users == null) {
            throw new IllegalArgumentException("Cannot create environment, because UserList is null.");
        }

        this.name = name;
        this.schedule = schedule;
        this.users = users;
    }

    /**
     * Returns the name of the environment.
     * 
     * @return name of environment
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the schedule of the environment.
     * 
     * @return schedule of the environment
     */
    public Schedule getSchedule() {
        return this.schedule;
    }

    /**
     * Returns the users of the Environment.
     * 
     * @return UserList of environment
     */
    public UserList getUsers() {
        return this.users;
    }

    /**
     * Returns a new ScheduleCleaner object for the schedule of the environment.
     * 
     * @return new ScheduleCleaner object
     */
    public ScheduleCleaner createScheduleCleaner() {
        return new ScheduleCleaner(this.schedule);
    }
}
