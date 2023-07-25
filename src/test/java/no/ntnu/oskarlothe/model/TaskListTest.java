package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import no.ntnu.oskarlothe.model.exception.TaskAlreadyExistsException;

/**
 * JUnit testing for the TaskList class.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskListTest {
    /**
     * Tests that the addTask() method using a task object that does not already
     * exist in the list, adds the task successfully.
     */
    @Test
    void testAddTaskSuccess() {
        Task task = new Task("TestTask", null, new User("John", "Johnson", "Johnny"));
        TaskList list = new TaskList();

        list.add(task);

        assertEquals(task, list.get(0));
    }

    /**
     * Tests that the addTask() method using a task that already exists in the list,
     * throws an exception.
     */
    @Test
    void testAddTaskAlreadyExists() {
        Task task = new Task("TestTask", null, new User("John", "Johnson", "Johnny"));
        TaskList list = new TaskList();

        list.add(task);
        Throwable exception = assertThrows(TaskAlreadyExistsException.class,
                () -> list.add(task));

        assertEquals("Cannot add task to the list, because task already exists.", exception.getMessage());
    }

    /**
     * Tests that the getDoneTasks() returns all tasks that are done.
     */
    @Test
    void testGetDoneTasks() {
        User creator = new User("John", "Johnson", "Johnny");
        Task task1 = new Task("Testtask1", null, creator);
        Task task2 = new Task("Testtask2", null, creator);
        Task task3 = new Task("Testtask3", null, creator);

        TaskList list = new TaskList();

        list.add(task1);
        list.add(task2);
        list.add(task3);

        task2.assign(creator);
        task2.getStatus().complete(creator);

        List<Task> result = list.getDoneTasks();

        assertTrue(result.contains(task2));
        assertFalse(result.contains(task1));
        assertFalse(result.contains(task3));
    }

    /**
     * Tests that the getPendingTasks() method returns all tasks that are not done
     * yet.
     */
    @Test
    void testGetPendingTasks() {
        User creator = new User("John", "Johnson", "Johnny");
        Task task1 = new Task("Testtask1", null, creator);
        Task task2 = new Task("Testtask2", null, creator);
        Task task3 = new Task("Testtask3", null, creator);

        TaskList list = new TaskList();

        list.add(task1);
        list.add(task2);
        list.add(task3);

        task2.assign(creator);
        task2.getStatus().complete(creator);

        List<Task> result = list.getPendingTasks();

        assertFalse(result.contains(task2));
        assertTrue(result.contains(task1));
        assertTrue(result.contains(task3));
    }

    /**
     * Tests that the copy() method makes a copy of the TaskList object as expected.
     */
    @Test
    void testCopy() {
        TaskList list = new TaskList();
        TaskList copy = list.clone();

        copy.add(new Task("Sampletask", "This is simply a sampletask", new User("Sample user", "sample user")));

        assertNotEquals(list, copy);
    }

    /**
     * Tests that the addAll() method works as expected, and do not add duplicates.
     */
    @Test
    void testAddAll() {
        User creator = new User("John", "The creator", "Johnny");

        Task task1 = new Task("Do the dishes", null, creator);

        Task task2 = new Task("Walk the dog", null, creator);

        List<Task> listOfTasks = new ArrayList<>();

        listOfTasks.add(task1);

        listOfTasks.add(task2);

        TaskList list = new TaskList();

        list.addAll(listOfTasks);

        list.addAll(listOfTasks);

        assertTrue(list.contains(task1));

        assertTrue(list.contains(task2));

        assertTrue(list.size() == 2);
    }
}
