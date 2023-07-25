package no.ntnu.oskarlothe.model;

/**
 * A class representing an interval of a repeating task.
 * An instance of the RepeatingTaskInstance class is a doable extending from the
 * Task class, while also holding a reference to its creator RepeatingTask.
 * The creator Task object is reffered to as 'mother' in the code.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class RepeatingTaskInstance extends Task {
    RepeatingTask mother;

    /**
     * Constructor for the RepeatingTaskInstance class.
     * 
     * @param header  the header of the task
     * @param content the content of the task
     * @param creator the creator of the task
     */
    public RepeatingTaskInstance(String header, String content, User creator, RepeatingTask mother) {
        super(header, content, creator);

        if (mother == null) {
            throw new IllegalArgumentException("Cannot create RepeatingTaskInstance, because mother is null.");
        }

        this.mother = mother;
    }

    /**
     * Returns the mother of the RepeatingTaskInstance object.
     * 
     * @return mother of the instance, or the creator task
     */
    public RepeatingTask getMother() {
        return this.mother;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.mother.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof RepeatingTaskInstance)) {
            return false;
        }

        RepeatingTaskInstance instance = (RepeatingTaskInstance) o;
        return this.mother.equals(instance.getMother());
    }
}
