package no.ntnu.oskarlothe.model;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;

/**
 * JUnit testing for the SingleUserEnvironmentTransformator class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class SingleUserEnvironmentTransformatorTest {
    Schedule multiUserSchedule;

    Schedule singleUserSchedule;

    /**
     * Setting up for the following test methods, creating a few instances of all the required classes.
     */
    @BeforeEach
    void setup() {
        // creating users
        User user1 = new User("John", "Johnson");

        User user2 = new User("David", "HoldOn", "Holly Dave");

        User user3 = new User("Nick", "Dick", "NickleSmickle");

        // creating tasks
        Task task1 = new Task("Clean the kitchen", "The kitchen needs cleaning.", user1);

        Task task2 = new Task("Apply for a god damn job", "You need money i think...", user2);

        // creating days and adding the tasks
        Day day1 = new Day(LocalDate.parse("2023-06-05"));

        Day day2 = new Day(LocalDate.parse("2023-06-05"));

        day1.add(task1);

        day2.add(task2);

        // creating userlist
        UserList multiUserUsers = new UserList();

        multiUserUsers.add(user1);

        multiUserUsers.add(user2);

        multiUserUsers.add(user3);

        // creating schedules
        multiUserSchedule = new Schedule();

        multiUserSchedule.getDayList().add(day1);
    }
}
