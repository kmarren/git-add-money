package src;

import java.util.UUID;

/**
* class that represents a user. Users can be either a student, faculty, or advisor.
* 
* @author Kennedy Marren
*/
public class User {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String viewStudentProfile(Student student) {
        return " ";
    }

}
