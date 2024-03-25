package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.UserList;
import src.Student; 
import src.User;
import src.Faculty;
import src.Advisor;

public class UserTest {
    private UserList userList;
    private ArrayList<User> users; 

    @Before
    public void setup() {
        userList = UserList.getInstance();
        users = userList.getUsers();
        users.clear();
        
        
        users.add(new Student("jdoe", "password123")); // Adjusted to use Student
        users.add(new Student("msmith", "password456")); // Adjusted to use Student
        users.add(new Advisor("mkaty", "password333")); // Adjusted to use Advisor
        users.add(new Faculty("jdoe", "password123")); // Adjusted to use Faculty
    }
    
    @After
    public void tearDown() {
        users.clear();
    }
    
    @Test
    public void testUserCreation() {
        Student newUser = new Student("newUser", "newPass"); // Use Student instead of User
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
        Student user1 = new Student("user1", "pass1");
        Student user2 = new Student("user2", "pass2");
        assertNotEquals(user1.getUserID(), user2.getUserID());
    }
    
    @Test
    public void testSetAndGetAttributes() {
        Student user = (Student) users.get(0); 
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("johndoe@example.com");
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("johndoe@example.com", user.getEmail());
    }
    @Test
    public void testUpdateUserEmail() {
    User user = users.get(0); // Assuming this is a Student
    String newEmail = "newemail@example.com";
    user.setEmail(newEmail);
    assertEquals("Email should be updated to new email", newEmail, user.getEmail());
    }

    @Test 
    public void testUserTypeAssignment() {
        User student = users.get(0);
        User advisor = users.get(2);
        assertEquals("User should be of type Student", 1, student.getType());
        assertEquals("User should be of type Advisor", 2, advisor.getType());
    }
    @Test
    public void testPasswordChange() {
        User user = users.get(1); // Assuming this is another Student
        user.setPassword("newSecurePassword123");
        assertTrue("Password should be updated and login should succeed with new password", 
                user.login(user.getUsername(), "newSecurePassword123"));
    }
    

    @Test
    public void testUUIDGeneration() {
    User user1 = new Student("user1", "pass1");
    User user2 = new Student("user2", "pass2");
    assertNotNull(user1.getUserID());
    assertNotNull(user2.getUserID());
    assertNotEquals(user1.getUserID(), user2.getUserID());
    }

    @Test(expected = NullPointerException.class)
    public void testSetFirstNameWithNull() {
    User user = new Student("jdoe", "password123");
    user.setFirstName(null);
    }

    @Test(expected = NullPointerException.class)
    public void testSetLastNameWithNull() {
    User user = new Student("jdoe", "password123");
    user.setLastName(null);
    }

    @Test(expected = NullPointerException.class)
    public void testSetEmailWithNull() {
    User user = new Student("jdoe", "password123");
    user.setEmail(null);
    }

    @Test
    public void testLoginWithNullUsername() {
    assertFalse(userList.login(null, "password123"));
}

    @Test
    public void testLoginWithEmptyPassword() {
    assertFalse(userList.login("jdoe", ""));
}
    @Test
    public void testAddUserWithDuplicateUsername() {
    userList.addUser(new Student("jdoe", "password123"));
    userList.addUser(new Student("jdoe", "newpassword")); // Assuming usernames must be unique
}

}
