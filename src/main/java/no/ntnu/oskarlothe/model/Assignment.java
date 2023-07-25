package no.ntnu.oskarlothe.model;

/**
 * An abstract class representing an assignment.
 * Assignments are some data assigned to different users.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public abstract class Assignment {
    private UserList assignees;

    private String header;

    private String content;

    private User creator;

    private TaskNotifier notifier;

    private Category category;

    /**
     * Constructor for the Assignment class.
     * <br/>
     * <br/>
     * The header and creator of a Assignment must be defined.
     * 
     * @param header  the header of the assignment
     * @param content the descriptive text of the assignment
     * @param creator the user that created the assignment
     */
    public Assignment(String header, String content, User creator) {
        if (header == null || header.isBlank()) {
            throw new IllegalArgumentException("Assignment header must be defined.");
        }

        if (creator == null) {
            throw new IllegalArgumentException("Creator of assignment must be defined.");
        }

        this.assignees = new UserList();
        this.header = header;
        this.content = content;
        this.creator = creator;
        this.notifier = new TaskNotifier();
        this.category = null;
    }

    /**
     * Assignes a user to the assignment.
     * 
     * @param user user to assign
     * @return true if user was successfully assigned, false if not
     */
    public boolean assign(User user) {
        return this.assignees.add(user);
    }

    /**
     * Unassignes a user to the assignment.
     * 
     * @param user user to unassign
     * @return true if user is successfully unassigned, false if not
     */
    public boolean unassign(User user) {
        return this.assignees.remove(user);
    }

    /**
     * Returns the list of assignees of the assignment.
     * 
     * @return list of users assigned to the assignment
     */
    public UserList getAssignees() {
        return this.assignees;
    }

    /**
     * Checks if the assignment header matches the header of another assignment.
     * Ignores uppercase.
     * 
     * @param assignment the assignment to compare
     * @return true if header matches, false if not
     */
    public boolean matchHeader(Assignment assignment) {
        return this.header.toLowerCase().equals(assignment.getHeader().toLowerCase());
    }

    /**
     * Returns the header of the assignment.
     * 
     * @return header of assignment
     */
    public String getHeader() {
        return this.header;
    }

    /**
     * Returns the content of the assignment.
     * 
     * @return content of assignment
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Returns the creator of the assignment.
     * 
     * @return creator of assignment
     */
    public User getCreator() {
        return this.creator;
    }

    /**
     * Returns the notifier of the assignment.
     * 
     * @return TaskNotifier object
     */
    public TaskNotifier getNotifier() {
        return this.notifier;
    }

    /**
     * Sets the header of the assignment.
     * 
     * @param header new header to set
     */
    public void setHeader(String header) {
        if (header == null || header.isBlank()) {
            throw new IllegalArgumentException("Cannot set header, because header is not defined.");
        }

        this.header = header;
    }

    /**
     * Sets the content of the task.
     * 
     * @param content new content of task
     */
    public void setContent(String content) {
        if (content == null) {
            throw new IllegalArgumentException("Cannot set content, because content is null.");
        }

        this.content = content;
    }

    /**
     * Sets the category of the task.
     * 
     * @param category category to set
     */
    public void setCategory(Category category) {
        if (!(this.category.equals(category))) {
            this.category = category;
        }
    }

    /**
     * Returns the category of the assignment.
     */
    public Category getCategory() {
        return this.category;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.header.hashCode();
        result = 31 * result + this.content.hashCode();
        result = 31 * result + this.creator.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Task)) {
            return false;
        }

        Task task = (Task) o;
        return this.header.equals(task.getHeader()) && this.content.equals(task.getContent())
                && this.creator.equals(task.getCreator());
    }
}
