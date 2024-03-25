package testing;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import src.User;
import src.UserList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class UserListTest {
    private UserList userList;
    private User user1;

    @Before
    public void setUp() {
        userList = UserList.getInstance();
        user1 = userList.getUserId(UUID.fromString("112777c5-b3d2-4696-ac27-19321db183bb"));
        userList.loadAll();
    }

    @After
    public void tearDown() {
        userList.clear();
        userList = null;
        user1 = null;
    }

    @Test
    public void testGetInstance() {
        UserList newInstance = UserList.getInstance();
        assertSame(userList, newInstance);
    }

    @Test
    public void testGetUser() {
        ArrayList<User> users = userList.getUsers();
        int size = users.size();
        assertEquals(size, users.size());
        assertTrue(users.contains(user1));
    }

    @Test
    public void testGetUserByID() {
        User foundUser = userList.getUserId(UUID.fromString(user1.getUserStringID()));
        assertEquals(user1, foundUser);
    }

    @Test
    public void testGetUserWithNonexistentUUID() {
        User foundUser = userList.getUserId(UUID.randomUUID());
        assertNull(foundUser);
    }

    @Test
    public void testGetUserWithNullUUID() {
        User foundUser = userList.getUserId(null);
        assertNull(foundUser);
    }

    @Test
    public void testGetUserByUsernameGood() {
        User foundUser = userList.getUser("braxwest");
        assertEquals(user1, foundUser);
    }

    @Test
    public void testGetUserByUsernameBad() {
        User foundUser = userList.getUser("imbrax");
        assertNotEquals(user1, foundUser);
    }

    @Test
    public void testGetUserByUsernameWithNullName() {
        User foundUser = userList.getUser(null);
        assertNull(foundUser);
    }

    @Test
    public void testGetUserByUsernameWithEmptyName() {
        User foundUser = userList.getUser("");
        assertNull(foundUser);
    }

    @Test
    public void testGetUserByUsernameWithDifferentCase() {
        User foundUser = userList.getUser("BRAXWEST");
        assertEquals(user1, foundUser);
    }
    
    @Test
    public void testAddUserNull() {
        int size = userList.getUsers().size();
        userList.addUser(null);
        assertEquals(size, userList.getUsers().size());
    }

    /* 
    @Test
    public void testRemoveUser() {
        userList.removeUser("braxwest");
        assertFalse(userList.getUsers().contains(user1));
    }
    */

    @Test
    public void testClear() {
        userList.clear();
        assertEquals(0, userList.getUsers().size());
    }
}
