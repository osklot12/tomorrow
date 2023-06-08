package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * JUnit testing for the User class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class UserTest {
    /**
     * Tests that two users who should be equal, are identified as equals.
     */
    @Test
    void testEqualsTrue() {
        User user1 = new User("Nick", "Jonhson");
        User user2 = new User("Nick", "Jonhson");

        boolean isEqual = user1.equals(user2);

        assertEquals(true, isEqual);
    }

    /**
     * Tests that two users with different nicknames, are not identified as equals.
     */
    @Test
    void testEqualsFalse() {
        User user1 = new User("Nick", "Jonhson", "Jonna");
        User user2 = new User("Nick", "Jonhson", "Nickie");

        boolean isEqual = user1.equals(user2);

        assertEquals(false, isEqual);
    }

    /**
     * Tests that an attempt to create a user object with illegal parameters, throws
     * the right exception.
     */
    @Test
    void testCreationOfUserWithIllegalArguments() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new User("", "Robertson"));

        assertEquals("First name must be defined.", exception.getMessage());
    }

    /**
     * Tests that an attempt to create a user object with only whitespace nickname,
     * will create an actual user object with an empty nickname string.
     */
    @Test
    void testCreationWithWhitespaceNickname() {
        User user = new User("John", "Johnson", "   ");

        String nickname = user.getNickname();

        assertEquals("", nickname);
    }
}
