package no.ntnu.oskarlothe.model;

/**
 * A class responsible for cleaning up tasks for a Schedule object.
 * The ScheduleCleaner is useful when removing users from an Environment, making
 * it possible to remove the associated tasks at the same time.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class ScheduleCleaner {
    private Schedule schedule;

    /**
     * Constructor for the ScheduleCleaner class.
     * 
     * @param schedule the schedule to clean
     */
    public ScheduleCleaner(Schedule schedule) {
        if (schedule == null) {
            throw new IllegalArgumentException("Cannot create ScheduleCleaner, because schedule is null.");
        }

        this.schedule = schedule;
    }

    /**
     * Returns the schedule of the ScheduleCleaner.
     * 
     * @return schedule object
     */
    public Schedule getSchedule() {
        return this.schedule;
    }

    /**
     * Returns a TaskList object containing all dead tasks in the schedule.
     * Dead tasks are tasks that is not assigned to any of the users in a UserList
     * object.
     * 
     * @param users users to check for
     * @return TaskList object containing all the dead tasks
     */
    public TaskList getDeadTasks(UserList users) {
        if (users == null) {
            throw new IllegalArgumentException("Cannot get dead tasks, because UserList is null.");
        }

        TaskList result = new TaskList();

        // checks for dead tasks in all tasks from the daylist
        this.schedule.getAllTasks().forEach(
                (task) -> {
                    UserList assignees = task.getStatus().getAssignees();

                    boolean anyMatch = assignees.stream().anyMatch(user -> users.contains(user));

                    if (!anyMatch)
                        result.add(task);
                });

        return result;
    }
}
