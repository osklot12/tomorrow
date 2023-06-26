package no.ntnu.oskarlothe.model;

/**
 * A class representing an Environment for multiple users.
 * The MultiUserEnvironment class allows for multiple users to exist in the
 * environment.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class MultiUserEnvironment extends Environment {
    private UserList users;

    /**
     * Constructor for the MultiUserEnvironment class.
     * 
     * @param name     the name of the environment
     * @param schedule the schedule of the environment
     * @param users    the list of users existing in the environment
     */
    public MultiUserEnvironment(String name, Schedule schedule, UserList users) {
        super(name, schedule);

        if (users == null) {
            throw new IllegalArgumentException(
                    "Cannot make MultiUserEnvironment for the UserList, because UserList is null.");
        }

        this.users = users;
    }

    /**
     * Returns the list of users existing in the environment.
     * 
     * @return list of users
     */
    public UserList getUsers() {
        return this.users;
    }

    @Override
    public Environment transform(TransformStrategy transformator) {
        return transformator.transform();
    }
}
