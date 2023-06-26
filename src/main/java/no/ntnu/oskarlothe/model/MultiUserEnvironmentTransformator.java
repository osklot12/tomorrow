package no.ntnu.oskarlothe.model;

/**
 * A class representing a transformator, transformating environments into
 * MultiUserEnvironment objects.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class MultiUserEnvironmentTransformator implements TransformStrategy {
    private Environment environment;

    private String newName;

    public MultiUserEnvironmentTransformator(Environment environment, String newName) {
        if (environment == null) {
            throw new IllegalArgumentException(
                    "Cannot create MultiUserEnvironmentTransformator, because environment is null.");
        }

        if (newName == null || newName.isBlank()) {

            throw new IllegalArgumentException("The new name cannot be null or blank");
        }

        this.environment = environment;
        this.newName = newName;
    }

    @Override
    public Environment transform() {
        if (this.environment instanceof SingleUserEnvironment) {
            SingleUserEnvironment singleUserEnvironment = (SingleUserEnvironment) this.environment;

            UserList users = new UserList();
            users.add(singleUserEnvironment.getUser());

            return new MultiUserEnvironment(this.newName, environment.getSchedule(), users);
        }

        return this.environment;
    }
}
