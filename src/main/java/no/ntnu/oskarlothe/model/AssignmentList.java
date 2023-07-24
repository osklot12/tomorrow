package no.ntnu.oskarlothe.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import no.ntnu.oskarlothe.model.exception.AssignmentAlreadyExistsException;

/**
 * A class representing a list of Assignment objects.
 * The class holds helpful methods for manipulating the data in the list.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class AssignmentList extends ArrayList<Assignment> {
    /**
     * Default constructor for the AssignmentList class.
     */
    public AssignmentList() {
        super();
    }

    /**
     * Constructor for the AssignmentList class with a predefined list of
     * assignments.
     * 
     * @param assignments list of assignments to copy
     */
    public AssignmentList(List<Assignment> assignments) {
        super(assignments);
    }

    @Override
    public boolean add(Assignment assignment) {
        if (assignment == null) {
            throw new IllegalArgumentException("Cannot add assignment, because assignment is null.");
        }

        if (this.contains(assignment)) {
            throw new AssignmentAlreadyExistsException(
                    "Cannot add assignment, because the assignment already exists in the list.");
        }

        return super.add(assignment);
    }

    @Override
    public boolean addAll(Collection<? extends Assignment> c) {
        for (Assignment assignment : c) {
            if (!this.contains(assignment)) {
                this.add(assignment);
            }
        }
        return true;
    }

    /**
     * Searches the list of assignments by their header, returning a list of all
     * assignments
     * that contain the search key in their header.
     * <br/>
     * This search ignores uppercase.
     * 
     * @param key search key
     * @return list of assignments matching the search key
     */
    public List<Assignment> searchByHeader(String key) {
        if (key.isBlank() || key == null) {
            throw new IllegalArgumentException("Search key cannot be blank or null.");
        }

        List<Assignment> result = new ArrayList<>();

        this.forEach(
                (assignment) -> {
                    if (assignment.getHeader().toLowerCase().contains(key.toLowerCase())) {
                        result.add(assignment);
                    }
                });

        return result;
    }

    /**
     * Searches the list of assignments by their content, returning a list of all
     * assignments
     * that contain the search key in their content.
     * 
     * @param key search key
     * @return list of assignments matching the search key
     */
    public List<Assignment> searchByContent(String key) {
        if (key.isBlank() || key == null) {
            throw new IllegalArgumentException("Search key cannot be blank or null.");
        }

        List<Assignment> result = new ArrayList<>();

        this.forEach(
                (assignment) -> {
                    if (assignment.getContent().toLowerCase().contains(key.toLowerCase())) {
                        result.add(assignment);
                    }
                });

        return result;
    }

    /**
     * Searches the list of assignments by their creator, returning a list of all
     * assignments
     * that is created by the given creator.
     * 
     * @param creator search key
     * @return list of assignments created by the creator
     */
    public List<Assignment> searchByCreator(User creator) {
        if (creator == null) {
            throw new IllegalArgumentException("Cannot search for creator, because creator is null.");
        }

        List<Assignment> result = new ArrayList<>();

        this.forEach(
                (assignment) -> {
                    if (assignment.getCreator().equals(creator)) {
                        result.add(assignment);
                    }
                });

        return result;
    }

    /**
     * Searches the list of assignments by their assignees, returning a list of all
     * assignments
     * that is assigned to the given user.
     * 
     * @param assignee search key
     * @return list of assignments assigned to the given assignee
     */
    public List<Assignment> searchByAssignee(User assignee) {
        if (assignee == null) {
            throw new IllegalArgumentException("Cannot search for assignee, because creator is null.");
        }

        List<Assignment> result = new ArrayList<>();

        this.forEach(
                (assignment) -> {
                    if (assignment.getAssignees().contains(assignee)) {
                        result.add(assignment);
                    }
                });

        return result;
    }

    @Override
    public AssignmentList clone() {
        AssignmentList list = new AssignmentList();

        this.forEach(
                (assignment) -> {
                    list.add(assignment);
                });

        return list;
    }
}
