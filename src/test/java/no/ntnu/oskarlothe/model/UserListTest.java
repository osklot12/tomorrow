package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit testing for the UserList class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class UserListTest {
    User user1;

    User user2;

    User user3;

    UserList userList;

    /**
     * Setting up for the following test methods.
     */
    @BeforeEach
    void setup() {
        user1 = new User("John", "Johnson", "Big Johnny");

        user2 = new User("Adrianna", "White", "Little Larve");

        user3 = new User("Mark", "White", "Big man");

        userList = new UserList();

        userList.add(user1);

        userList.add(user2);

        userList.add(user3);
    }

    /**
     * Tests that the searchUsers() method returns the expected result, using a word
     * found in the nickname of two of the users.
     */
    @Test
    void testSearchUsersUsingNickname() {
        String searchKey = "big";

        UserList searchResult = userList.searchUsers(searchKey);

        assertTrue(searchResult.contains(user1));

        assertTrue(searchResult.contains(user3));

        assertFalse(searchResult.contains(user2));

        assertTrue(searchResult.size() == 2);
    }

    /**
     * Tests that the searchUsers() method returns the expected result, using only a
     * few letters and not full words.
     */
    @Test
    void testSearchUsersUsingSomeLetters() {
        String searchKey = "ar";

        UserList searchResult = userList.searchUsers(searchKey);

        assertTrue(searchResult.contains(user2));

        assertTrue(searchResult.contains(user3));

        assertFalse(searchResult.contains(user1));

        assertTrue(searchResult.size() == 2);
    }
}
