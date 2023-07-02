package no.ntnu.oskarlothe.model;

import no.ntnu.oskarlothe.model.notification.NotificationCenter;

/**
 * A class representing a user of the application.
 * Having users is essential in the situation of 'enviroments', where tasks is
 * created and completed by indiviual users.
 * <br/>
 * <br/>
 * Two users with the exact same name would cause problems.
 * For this reason, a string 'nickname' was implemented.
 * Each time a new user has the exact name as an existing user in a system, the
 * user will be asked to provide a nickname, resulting in a unique hashcode even
 * for users with the same names.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class User {
    private String firstName;

    private String lastName;

    private String nickname;

    private NotificationCenter notifications;

    /**
     * Constructor for users without a nickname.
     * 
     * @param firstName the first name of the user
     * @param lastName  the last name of the user
     */
    public User(String firstName, String lastName) {
        if (firstName.isBlank() || firstName == null) {
            throw new IllegalArgumentException("First name must be defined.");
        }

        if (lastName.isBlank() || lastName == null) {
            throw new IllegalArgumentException("Last name must be defined.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = "";
        this.notifications = new NotificationCenter();
    }

    /**
     * Constructor for users with a nickname.
     * 
     * @param firstName the first name of the user
     * @param lastName  the last name of the user
     * @param nickname  the nickname of the user
     */
    public User(String firstName, String lastName, String nickname) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name must be defined.");
        }

        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name must be defined.");
        }

        this.firstName = firstName;
        this.lastName = lastName;

        if (nickname == null || nickname.isBlank()) {
            this.nickname = "";
        } else {
            this.nickname = nickname;
        }
    }

    /**
     * Returns the first name of the user.
     * 
     * @return users' first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the last name of the user.
     * 
     * @return users' last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Returns the nickname of the user.
     * 
     * @return users' nickname, null if user does not have one
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * Returns the notification center for the user.
     * 
     * @return notification center for user
     */
    public NotificationCenter getNotifications() {
        return this.notifications;
    }

    /**
     * Returns a string representation of the user.
     * Returns the nickname if any, or full name if no nickname is set.
     * 
     * @return a string representation of the user
     */
    public String getStringRepresentation() {
        if (!this.nickname.isBlank()) {
            return this.nickname;
        }

        return this.firstName + " " + this.lastName;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.firstName.hashCode();
        result = 31 * result + this.lastName.hashCode();
        result = 31 * result + this.nickname.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;
        return this.firstName.equals(user.getFirstName()) && this.lastName.equals(user.getLastName())
                && this.nickname.equals(user.getNickname());
    }
}
