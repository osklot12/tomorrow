package no.ntnu.oskarlothe.model;

/**
 * A class representing an Environment in the application.
 * An environment consist of a list of users, as well as a schedule, and manages their relations.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public abstract class Environment {
    private String name;

    private Schedule schedule;
}
