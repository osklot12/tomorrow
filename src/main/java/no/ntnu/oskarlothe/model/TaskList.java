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
public class TaskList {
    private List<Task> tasks;

    /**
     * Default constructor for the TaskList class.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructor for the TaskList class with an existing list of task objects.
     * 
     * @param tasks list of task objects
     */
    public TaskList(List<Task> tasks) {
        if (tasks == null) {
            throw new IllegalArgumentException("List of tasks cannot be null.");
        }

        this.tasks = tasks;
    }

    /**
     * Returns the list of tasks.
     * 
     * @return list of task objects
     */
    public List<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Adds a task to the list.
     * Cannot add a task that already exists in the list.
     * 
     * @param task task to add
     */
    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Cannot add task to TaskList, because task is null.");
        }

        if (this.tasks.contains(task)) {
            throw new TaskAlreadyExistsException("The task is already in the list.");
        }

        this.tasks.add(task);
    }

    /**
     * Removes a task from the list.
     * 
     * @param task task to remove
     */
    public void removeTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Cannot remove task from TaskList, because task is null.");
        }

        if (!(this.tasks.contains(task))) {
            throw new NoSuchTaskException("There is no such task in the list.");
        }

        this.tasks.remove(task);
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

        this.tasks.forEach(
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

        this.tasks.forEach(
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

        this.tasks.forEach(
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

        this.tasks.forEach(
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

        this.tasks.forEach(
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

        result.addAll(this.tasks);
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
        this.tasks.forEach(
            (task) -> {
                copy.addTask(task);
            }
        );

        return copy;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.tasks.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof TaskList)) {
            return false;
        }

        TaskList taskList = (TaskList) o;
        return this.getTasks().equals(taskList.getTasks());
    }
}
