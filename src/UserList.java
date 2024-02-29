package src;

import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    private UserList() {
        users = new ArrayList<>();
        ArrayList<User> advi= DataLoader.loadAdvisors();
        ArrayList<User> fac = DataLoader.loadFaculty();
        ArrayList<User> stud = DataLoader.loadStudents();
        users.addAll(advi);
        users.addAll(fac);
        users.addAll(stud);
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

    public boolean login(String userName, String password) {
        return getUser(userName, password) != null;
    }


   
}