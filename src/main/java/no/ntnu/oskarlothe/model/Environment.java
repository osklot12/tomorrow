package no.ntnu.oskarlothe.model;

/**
 * A class representing an Environment in the application.
 * The Environment class is responsible for managing the schedule, users and
 * news, as well as actions related to them.
 * 
 * <p>
 * An instance of the Environment class holds the current user in the user
 * field, making it only possible to do the tasks that are assigned to this
 * user. The user can also only change tasks that are created by the user,
 * protecting tasks from being changed by someone else.
 * <p/>
 * 
 * <p>
 * The Environment class also holds news with data for individual users, making
 * each user have their personalized news section.
 * <p/>
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class Environment {
    private String name;

    private Schedule schedule;

    private UserList users;

    private User user;

    /**
     * Constructor for the Environment class.
     * 
     * @param name     the name of the environment
     * @param schedule the schedule of the enviroment
     */
    public Environment(String name, Schedule schedule, UserList users, User user) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name of the environment must be defined.");
        }

        if (schedule == null) {
            throw new IllegalArgumentException("Schedule of the environment must be defined.");
        }

        if (users == null) {
            throw new IllegalArgumentException("Cannot create environment, because UserList is null.");
        }

        if (user == null) {
            throw new IllegalArgumentException("Cannot create environment, because user is null.");
        }

        this.name = name;
        this.schedule = schedule;
        this.users = users;
        this.user = user;
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

    /**
     * Sets the user of the environment.
     * Can only set to a user that does exist in the environment.
     * 
     * @param user user to set
     */
    public void setUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot set user, because user is null.");
        }

        if (!this.users.contains(user)) {
            throw new IllegalArgumentException("Cannot set user, because user is not in the environment.");
        }

        this.user = user;
    }

    /**
     * Returns the user using the environment at the moment.
     * 
     * @return user of environment
     */
    public User getUser() {
        return this.user;
    }
}
