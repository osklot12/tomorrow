package no.ntnu.oskarlothe.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import no.ntnu.oskarlothe.model.exception.TaskAlreadyExistsException;

/**
 * A class representing a list of Task objects.
 * The TaskList class makes it more convenient to add, remove and search tasks.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskList extends AssignmentList<Task> {
    /**
     * Default constructor for the TaskList class.
     */
    public TaskList() {
        super();
    }

    /**
     * Constructor for the TaskList class, with a predefined list of tasks.
     * 
     * @param assignments predefined list of assignments
     */
    public TaskList(List<Task> tasks) {
        super(tasks);
    }

    @Override
    public boolean add(Task task) {
        return super.add(task);
    }

    /**
     * Returns a list of all the tasks that has been done.
     * 
     * @return list of done tasks
     */
    public TaskList getDoneTasks() {
        TaskList result = new TaskList();

        this.forEach(
                (task) -> {
                    if (task.getStatus().isDone()) {
                        result.add(task);
                    }
                });

        return result;
    }

    /**
     * Returns a list of all the pending tasks; tasks that have not been done yet.
     * 
     * @return list of pending tasks
     */
    public List<Task> getPendingTasks() {
        List<Task> result = new ArrayList<>();

        for (Assignment assignment : this) {
            if (assignment instanceof Task) {
                Task task = (Task) assignment;

                result.add(task);
            }
        }
        result.removeAll(this.getDoneTasks());

        return result;
    }

    /**
     * Returns a copy of the object.
     * 
     * @return TaskList object copy
     */
    public TaskList clone() {
        TaskList clone = new TaskList();
        this.forEach(
                (task) -> {
                    clone.add(task);
                });

        return clone;
    }
}
