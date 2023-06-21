package no.ntnu.oskarlothe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
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

        assertEquals("The task is already in the list.", exception.getMessage());
    }

    /**
     * Tests that the searchByHeader() method returns the expected searchs result.
     */
    @Test
    void testSearchByHeaderFound() {
        Task task1 = new Task("TestTask", null, new User("John", "Johnson", "Johnny"));
        Task task2 = new Task("TestTaskToo", null, new User("John", "Johnson", "Johnny"));
        Task task3 = new Task("TextTaskToo", null, new User("John", "Johnson", "Johnny"));
        TaskList list = new TaskList();

        list.add(task1);
        list.add(task2);
        list.add(task3);

        List<Task> result = list.searchByHeader("test");

        assertTrue(result.contains(task1));
        assertTrue(result.contains(task2));
        assertFalse(result.contains(task3));
    }

    /**
     * Tests that the searchByHeader() method returns an empty list if no matches
     * are found.
     */
    @Test
    void testSearchByHeaderNoResult() {
        Task task1 = new Task("TestTask", null, new User("John", "Johnson", "Johnny"));
        Task task2 = new Task("TestTaskToo", null, new User("John", "Johnson", "Johnny"));
        Task task3 = new Task("TextTaskToo", null, new User("John", "Johnson", "Johnny"));
        TaskList list = new TaskList();

        list.add(task1);
        list.add(task2);
        list.add(task3);

        List<Task> result = list.searchByHeader("nonexistent");

        assertTrue(result.isEmpty());
    }

    /**
     * Tests that the searchByContent() method returns the expected search result.
     */
    @Test
    void testSearchByContentSuccess() {
        Task task1 = new Task("TestTask", "This is the content", new User("John", "Johnson", "Johnny"));
        Task task2 = new Task("TestTaskToo", "This is also the content", new User("John", "Johnson", "Johnny"));
        Task task3 = new Task("TextTaskToo", "This isn't the content. Wait, it is!",
                new User("John", "Johnson", "Johnny"));
        TaskList list = new TaskList();

        list.add(task1);
        list.add(task2);
        list.add(task3);

        List<Task> result = list.searchByContent("this is ");

        assertTrue(result.contains(task1));
        assertTrue(result.contains(task2));
        assertFalse(result.contains(task3));
    }

    /**
     * Tests that the searchByCreator() method returns the expected search result.
     */
    @Test
    void testSearchByCreatorSuccess() {
        User creator1 = new User("John", "Johnson", "Johnny");
        User creator2 = new User("Bill", "Gatsby", "Billyboy");
        Task task1 = new Task("TestTask", "This is the content", creator2);
        Task task2 = new Task("TestTaskToo", "This is also the content", creator1);
        Task task3 = new Task("TextTaskToo", "This isn't the content. Wait, it is!", creator1);
        TaskList list = new TaskList();

        list.add(task1);
        list.add(task2);
        list.add(task3);

        List<Task> result = list.searchByCreator(creator1);

        assertTrue(result.contains(task2));
        assertTrue(result.contains(task3));
        assertFalse(result.contains(task1));
    }

    /**
     * Tests that the searchByAssignee() method returns the expected search result.
     */
    @Test
    void testSearchByAssigneeSuccess() {
        User creator = new User("John", "Johnson", "Johnny");
        User assignee1 = new User("Peter", "Park", null);
        User assignee2 = new User("Mia", "Miamor", null);

        Task task1 = new Task("Testtask1", null, creator);
        Task task2 = new Task("Testtask2", null, creator);
        Task task3 = new Task("Testtask3", null, creator);

        TaskList list = new TaskList();

        list.add(task1);
        list.add(task2);
        list.add(task3);

        task1.getStatus().assign(assignee1);
        task1.getStatus().assign(assignee2);

        task2.getStatus().assign(assignee2);

        task3.getStatus().assign(assignee1);

        List<Task> result = list.searchByAssignee(assignee1);

        assertTrue(result.contains(task1));
        assertTrue(result.contains(task3));
        assertFalse(result.contains(task2));
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

        task2.getStatus().assign(creator);
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

        task2.getStatus().assign(creator);
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
        TaskList copy = list.copy();

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

    /**
     * Tests that the getRepeatingTasksForDate() method returns a list of repeating
     * tasks as expected.
     */
    @Test
    void testGetRepeatingTasksForDate() {
        User creator = new User("John", "Johnny", "");
        
        Task task1 = new Task("Empty the trash", "The trash is full and needs to be emptied.", creator);
        
        LocalDate startDate = LocalDate.parse("2023-06-05");

        Interval interval = new Interval(startDate, 1);

        interval.addWeekday("monday");

        RepeatingTask repeater = new RepeatingTask("Mop the floor", "The floor is dirty.", creator, interval);

        TaskList taskList = new TaskList();

        taskList.add(task1);

        taskList.add(repeater);

        List<RepeatingTask> result = taskList.getRepeatingTasksForDate(startDate);

        assertTrue(result.contains(repeater));

        assertFalse(result.contains(task1));
    }
}
