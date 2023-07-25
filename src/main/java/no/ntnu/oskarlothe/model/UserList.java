package no.ntnu.oskarlothe.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a list of users.
 * Instances of the class can be used to navigate a set of users more convenient.
 * <br/>
 * <br/>
 * The UserList class extends from {@link java.util.ArrayList}.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class UserList extends ArrayList<User> {
    /**
     * Default constructor for the UserList class.
     */
    public UserList() {
        super();
    }

    /**
     * Constructor for the UserList class with a predefined list of users.
     * 
     * @param users predefined list of users
     */
    public UserList(List<User> users) {
        super(users);
    }

    @Override
    public boolean add(User user) {
        if (!this.contains(user)) {
            return super.add(user);
        }

        return false;
    }

    /**
     * Searches the users in the list by their names and nicknames.
     * 
     * @param searchKey the searchkey to use for the search
     * @return a UserList with all users data matching the searchkey
     */
    public UserList searchUsers(String searchKey) {
        if (searchKey == null) {
            throw new IllegalArgumentException("Searchkey cannot be null.");
        }

        UserList result = new UserList();

        String[] keyWords = searchKey.split("\\s+");

        this.forEach(
            (user) -> {
                String userDataString = (user.getFirstName() + user.getLastName() + user.getNickname()).toLowerCase();

                boolean match = true;

                int counter = 0;

                while (match && counter < keyWords.length) {
                    if (!(userDataString.contains(keyWords[counter].toLowerCase()))) {
                        match = false;
                    }

                    counter++;
                }

                if (match) result.add(user);
            }
        );

        return result;
    }
}
