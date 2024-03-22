package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.UserList;
import src.Student; // Import the Student class (assuming it's a concrete subclass of User).
import src.User;


public class UserTest {
    private UserList userList;
    private ArrayList<User> users; // Use Student or another concrete subclass of User.

    @Before
    public void setup() {
        userList = UserList.getInstance();
        users = userList.getUsers();
        users.clear();
        
        // Assuming Student is a concrete subclass of User. Replace with actual subclasses.
        users.add(new Student("jdoe", "password123", 1)); // Adjusted to use Student
        users.add(new Student("msmith", "password456", 2)); // Adjusted to use Student
    }
    
    @After
    public void tearDown() {
        users.clear();
    }
    
    @Test
    public void testUserCreation() {
        Student newUser = new Student("newUser", "newPass", 3); // Use Student instead of User
        assertNotNull(newUser.getUserID());
    }
    
    @Test
    public void testLoginSuccess() {
        boolean loginSuccess = userList.login("jdoe", "password123");
        assertTrue(loginSuccess);
    }
    
    @Test
    public void testLoginFailure() {
        boolean loginFailure = userList.login("jdoe", "wrongPassword");
        assertFalse(loginFailure);
    }
    
    @Test
    public void testUniqueUserID() {
        Student user1 = new Student("user1", "pass1", 1);
        Student user2 = new Student("user2", "pass2", 2);
        assertNotEquals(user1.getUserID(), user2.getUserID());
    }
    
    @Test
    public void testSetAndGetAttributes() {
        Student user = (Student) users.get(0); // Assuming the first user is a Student.
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("johndoe@example.com");
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("johndoe@example.com", user.getEmail());
    }
}
