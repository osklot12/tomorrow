package no.ntnu.oskarlothe.model;

import java.util.ArrayList;
import java.util.List;

import no.ntnu.oskarlothe.model.exception.NoSuchUserException;
import no.ntnu.oskarlothe.model.exception.TaskAlreadyCompletedException;
import no.ntnu.oskarlothe.model.exception.UserAlreadyExistsException;

/**
 * A class representing a status for a spesific task.
 * The TaskStatus object indicates if a task is done or not, as well as pointing
 * to who the task is assigned to. While a Task object is static, the TaskStatus
 * is like the variable of the task.
 * <br/>
 * <br/>
 * Whenever a task is done, the TaskStatus object will point to who completed
 * it.
 * ComplexTask objects will not own a TaskStatus object, but rather calculate
 * its status based on its subtasks' statuses.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskStatus {
    private List<User> assignees;

    private User completer;

    /**
     * Constructor for the TaskStatus class.
     */
    public TaskStatus() {
        this.assignees = new ArrayList<>();
        this.completer = null;
    }

    /**
     * Constructor for the TaskStatus class, with a predefined list of assignees.
     * 
     * @param assignees list of users assinged to the task
     */
    public TaskStatus(List<User> assignees) {
        if (assignees == null) {
            throw new IllegalArgumentException("Assignees cannot be null");
        }

        this.assignees = assignees;
        this.completer = null;
    }

    /**
     * Returns wheter the task is done or not.
     * 
     * @return true if task is done, false if not
     */
    public boolean isDone() {
        return !(this.completer == null);
    }

    /**
     * Assignes a user to the TaskStatus object.
     * 
     * @param user user to assign
     */
    public void assign(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot assign to null user.");
        }

        if (this.assignees.contains(user)) {
            throw new UserAlreadyExistsException("User is already assigned.");
        }

        this.assignees.add(user);
    }

    /**
     * Unassignes a user to the TaskStatus object.
     * 
     * @param user user to unassign
     */
    public void unassign(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot unassign null user.");
        }

        if (!(this.assignees.contains(user))) {
            throw new NoSuchUserException("The user is not assigned to the task.");
        }

        this.assignees.remove(user);
    }

    /**
     * Adds a 'completer' to the TaskStatus object.
     * 
     * @param user user that completed the task
     */
    public void complete(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot complete task with null user.");
        }

        if (!(this.assignees.contains(user))) {
            throw new NoSuchUserException("The user is not assigned to the task.");
        }

        if (!(this.completer == null)) {
            throw new TaskAlreadyCompletedException("Another user has already completed the task.");
        }

        this.completer = user;
    }

    /**
     * Returns the list of assignees of the task.
     * 
     * @return list of users assigned to the task
     */
    public List<User> getAssignees() {
        return this.assignees;
    }

    /**
     * Returns the user that completed the task.
     * If the task is not done yet, null is returned.
     * 
     * @return completer of the task, null if task is not done
     */
    public User getCompleter() {
        return this.completer;
    }
}
