package src;

import java.util.UUID;

/**
 * class that represents a user. Users can be either a student, faculty, or
 * advisor.
 * 
 * @author Kennedy Marren
 */
public abstract class User {
    private String firstName;
    private String lastName;
    private UUID userID;
    private String email;
    protected String username;
    protected String password;
    protected int type;

    /**
     * Constructs a new User object with a randomly generated userID.
     */
    public User() {
        this.userID = UUID.randomUUID();
    }

    /**
     * Constructs a new User object with a randomly generated userID, username,
     * password, and type.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @param type     The type of the user (e.g., student, faculty, advisor).
     */
    public User(String username, String password, int type) {
        this();
        this.password = password;
        this.username = username;
        this.type = type;
    }

    /**
     * Constructs a new User object with a randomly generated userID.
     *
     * @param firstName The first name of the user.
     * @param lastName  The last name of the user.
     * @param email     The email address of the user.
     * @param username  The username of the user.
     * @param password  The password of the user.
     * @param type      The type of the user (e.g., student, faculty, advisor).
     */
    public User(String firstName, String lastName, String email, String username, String password, int type) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    /**
     * Gets the first name of the user.
     * 
     * @return The user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name.
     * 
     * @param firstName The first name to set for the user.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user.
     * 
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user's last name.
     * 
     * @param firstName The last name to set for the user.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the UUID of the user.
     * 
     * @return The UUID of the user.
     */
    public UUID getUserID() {
        return userID;
    }

    /**
     * Sets the UUID of the user.
     * 
     * @param majorID The UUID to set.
     */
    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    /**
     * Gets the email of the user.
     * 
     * @return The user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     * 
     * @param email The email to be set for the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's username.
     * 
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     * 
     * @param username The username to set for the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the users password.
     * 
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     * 
     * @param password The password to be set to the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the type of user (1, 2, or 3) to indicate whether the user is a student,
     * faculty, or advisor
     * 
     * @return
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the type of the user.
     * 
     * @param type The type to set for the user, either 1 2 or 3.
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * User login is verified if the username and password they enter are correct
     * 
     * @param username the username attempt the user enters when prompted
     * @param password the password attempt the user enters when promted
     * 
     * @return whether or not the login is verified
     */
    public boolean login(String username, String password) {
        if (username.equals(getUsername()) && password.equals(getPassword())) {
            return true;
        }
        return false;
    }

}
