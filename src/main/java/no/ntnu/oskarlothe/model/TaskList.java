package no.ntnu.oskarlothe.model;

import java.util.ArrayList;
import java.util.List;

import no.ntnu.oskarlothe.model.exception.NoSuchTaskException;
import no.ntnu.oskarlothe.model.exception.TaskAlreadyExistsException;

/**
 * A class representing a list of Task objects.
 * The TaskList class makes it more convenient to add, remove and search tasks.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskList extends ArrayList<Task> {
    /**
     * Default constructor for the TaskList class.
     */
    public TaskList() {
        super();
    }

    /**
     * Constructor for the TaskList class with an existing list of task objects.
     * 
     * @param tasks list of task objects
     */
    public TaskList(List<Task> tasks) {
        super(tasks);
    }

    /**
     * Adds a task to the list.
     * Cannot add a task that already exists in the list.
     * 
     * @param task task to add
     */
    @Override
    public boolean add(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Cannot add task to TaskList, because task is null.");
        }

        if (this.contains(task)) {
            throw new TaskAlreadyExistsException("The task is already in the list.");
        }

        return super.add(task);
    }

    /**
     * Searches the list of tasks by their header, returning a list of all tasks
     * that contain the search key in their header.
     * <br/>
     * This search ignores uppercase.
     * 
     * @param key search key
     * @return list of tasks matching the search key
     */
    public List<Task> searchByHeader(String key) {
        if (key.isBlank() || key == null) {
            throw new IllegalArgumentException("Search key cannot be blank or null.");
        }

        List<Task> result = new ArrayList<>();

        this.forEach(
                (task) -> {
                    if (task.getHeader().toLowerCase().contains(key.toLowerCase())) {
                        result.add(task);
                    }
                });

        return result;
    }

    /**
     * Searches the list of tasks by their content, returning a list of all tasks
     * that contain the search key in their content.
     * 
     * @param key search key
     * @return list of tasks matching the search key
     */
    public List<Task> searchByContent(String key) {
        if (key.isBlank() || key == null) {
            throw new IllegalArgumentException("Search key cannot be blank or null.");
        }

        List<Task> result = new ArrayList<>();

        this.forEach(
                (task) -> {
                    if (task.getContent().toLowerCase().contains(key.toLowerCase())) {
                        result.add(task);
                    }
                });

        return result;
    }

    /**
     * Searches the list of tasks by their creator, returning a list of all tasks
     * that is created by the given creator.
     * 
     * @param creator search key
     * @return list of tasks created by the creator
     */
    public List<Task> searchByCreator(User creator) {
        if (creator == null) {
            throw new IllegalArgumentException("Cannot search for creator, because creator is null.");
        }

        List<Task> result = new ArrayList<>();

        this.forEach(
                (task) -> {
                    if (task.getCreator().equals(creator)) {
                        result.add(task);
                    }
                });

        return result;
    }

    /**
     * Searches the list of tasks by their assignees, returning a list of all tasks
     * that is assigned to the given user.
     * 
     * @param assignee search key
     * @return list of tasks assigned to the given assignee
     */
    public List<Task> searchByAssignee(User assignee) {
        if (assignee == null) {
            throw new IllegalArgumentException("Cannot search for assignee, because creator is null.");
        }

        List<Task> result = new ArrayList<>();

        this.forEach(
            (task) -> {
                if (task.getStatus().getAssignees().contains(assignee)) {
                    result.add(task);
                }
            }
        );

        return result;
    }

    /**
     * Returns a list of all the tasks that has been done.
     * 
     * @return list of done tasks
     */
    public List<Task> getDoneTasks() {
        List<Task> result = new ArrayList<>();

        this.forEach(
            (task) -> {
                if (task.getStatus().isDone()) {
                    result.add(task);
                }
            }
        );

        return result;
    }

    /**
     * Returns a list of all the pending tasks; tasks that have not been done yet.
     * 
     * @return list of pending tasks
     */
    public List<Task> getPendingTasks() {
        List<Task> result = new ArrayList<>();

        result.addAll(this);
        result.removeAll(this.getDoneTasks());

        return result;
    }

    /**
     * Returns a copy of the object.
     * 
     * @return TaskList object copy
     */
    public TaskList copy() {
        TaskList copy = new TaskList();
        this.forEach(
            (task) -> {
                copy.add(task);
            }
        );

        return copy;
    }
}
