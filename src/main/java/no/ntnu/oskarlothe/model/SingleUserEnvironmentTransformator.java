package no.ntnu.oskarlothe.model;

/**
 * A class representing a transformator, transformating environments into
 * SingleUserEnvironment objects.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class SingleUserEnvironmentTransformator implements TransformStrategy {
    private Environment environment;

    private String newName;

    private User user;

    /**
     * Constructor for the SingleUserEnvironmentTransformator class.
     * 
     * @param environment the environment to transform
     * @param newName the new name for the transformed environment
     * @param user the user of the new environment
     */
    public SingleUserEnvironmentTransformator(Environment environment, String newName, User user) {
        if (environment == null) {
            throw new IllegalArgumentException("Environment cannot be null.");
        }

        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("The new name cannot be null or blank.");
        }

        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }

        this.environment = environment;
        this.newName = newName;
        this.user = user;
    }

    /**
     * Returns the environment to transform.
     * 
     * @return environment to transform
     */
    public Environment getEnvironment() {
        return this.environment;
    }

    /**
     * Returns the new name for the new environment.
     * 
     * @return new name for the new environment
     */
    public String getNewName() {
        return this.newName;
    }

    /**
     * Returns the user for the new environment.
     * 
     * @return the user of the new environment
     */
    public User getUser() {
        return this.user;
    }

    @Override
    public Environment transform() {
        if (this.environment instanceof MultiUserEnvironment) {
            MultiUserEnvironment multiUserEnvironment = (MultiUserEnvironment) this.environment;

            Schedule schedule = multiUserEnvironment.getSchedule();

            return new SingleUserEnvironment(this.newName, schedule, user);
        }

        return this.environment;
    }
}
