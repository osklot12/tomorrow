package no.ntnu.oskarlothe.model;

/**
 * A class representing an Environment for a sigle user.
 * The SingleUserEnvironment class only allows for a single user to exist in the
 * environment.
 * The environment can be transformed into other types of environments, making
 * it possible to add more users to the same schedule.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class SingleUserEnvironment extends Environment {
    private User user;

    /**
     * Constructor for the SingleUserEnvironment class.
     * 
     * @param name     the name of the environment
     * @param schedule the schedule of the environment
     * @param user     the user of the environment
     */
    public SingleUserEnvironment(String name, Schedule schedule, User user) {
        super(name, schedule);

        if (user == null) {
            throw new IllegalArgumentException("User must be defined.");
        }

        this.user = user;
    }

    /**
     * Returns the user of the SingleUserEnvironment.
     * 
     * @return the user of the environment
     */
    public User getUser() {
        return this.user;
    }

    @Override
    public Environment transform(TransformStrategy transformator) {
        if (transformator == null) {
            throw new IllegalArgumentException("Cannot transform environment, cause transformator is null.");
        }

        return transformator.transform();
    }
}
