package no.ntnu.oskarlothe.model;

/**
 * A class representing an Environment in the application.
 * An environment consist of a list of users, as well as a schedule, and manages
 * their relations.
 * Environments allows for abstracting a group of people signed to a group of
 * tasks.
 * Giving the environment a name makes it easier for the user to recognize
 * different environments and switch between them.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public abstract class Environment {
    private String name;

    private Schedule schedule;

    /**
     * Constructor for the Environment class.
     * 
     * @param name     the name of the environment
     * @param schedule the schedule of the enviroment
     */
    public Environment(String name, Schedule schedule) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name of the environment must be defined.");
        }

        if (schedule == null) {
            throw new IllegalArgumentException("Schedule of the environment must be defined.");
        }

        this.name = name;
        this.schedule = schedule;
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
     * Transforms the environment into another type of environment.
     * The method uses a transformator to transform the environment.
     * 
     * @param transformator the transformator to use for the transformation
     * @return the new transformed environment
     */
    abstract Environment transform(TransformStrategy transformator);
}
