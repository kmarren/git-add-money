package src;

import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    private UserList() {
        users = new ArrayList<User>();
    }

    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }


    public User getUser(String userName) {
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public User getUser(String userName, String password) {
        for (User user : users) {
            if (user.getUsername().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user)
    {
        users.add(user);
    }


   
}