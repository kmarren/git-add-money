package src;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataWriter extends DataConstants {

    private static ArrayList<User> students = new ArrayList<User>();
    private static ArrayList<User> faculty = new ArrayList<User>();;
    private static ArrayList<User> advisors = new ArrayList<User>();;

    private static ArrayList<Course> courses = new ArrayList<Course>();

    private ArrayList<Major> majors = new ArrayList<Major>();

    public static void parseUserList() {
        for (int i = 0; i < UserList.getInstance().getUsers().size(); i++) {
            if (UserList.getInstance().getUsers().get(i).getType() == 3) {
                faculty.add(UserList.getInstance().getUsers().get(i));
            } else if (UserList.getInstance().getUsers().get(i).getType() == 2) {
                advisors.add(UserList.getInstance().getUsers().get(i));
            } else {
                students.add(UserList.getInstance().getUsers().get(i));
            }
        }
    }

    public static void writeCourses() {

    }

    public static void writeMajors() {

    }

    // need to have this go through the students, advisors etc as well, however i
    // just wanted to get a basic understanding of the datawriter first
    // should be pretty easy though just go through and look for the type then put
    // that users information in
    public static void saveUsers() {
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
        JSONArray userJSON = new JSONArray();

        for (User user : users) {
            userJSON.add(getUserJSON(user));
        }

        try (FileWriter file = new FileWriter("data/userwritetest.json")) {

            file.write(userJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static JSONObject getUserJSON(User user) {
        JSONObject userJSON = new JSONObject();
        userJSON.put(USER_FIRST_NAME, user.getFirstName());
        userJSON.put(USER_LAST_NAME, user.getLastName());
        userJSON.put(USER_ID, user.getUserID());
        userJSON.put(USER_EMAIL, user.getEmail());
        userJSON.put(USER_USERNAME, user.getUsername());
        userJSON.put(USER_PASSWORD, user.getPassword());
        userJSON.put(USER_TYPE, user.getType());
        return userJSON;
    }

    public static void writeAllID() {
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();

        MajorList majorList = MajorList.getInstance();
        ArrayList<Major> majors = majorList.getMajors();

        CourseList courseList = CourseList.getInstance();
        ArrayList<Course> courses = courseList.getCourses();

        // Create JSON array to hold IDs
        JSONArray jsonIDs = new JSONArray();

        // Add user IDs to JSON array
        for (User user : users) {
            jsonIDs.add(getUserID(user));
        }

        // Add major IDs to JSON array
        for (Major major : majors) {
            jsonIDs.add(getMajorID(major));
        }

        // Add course IDs to JSON array
        for (Course course : courses) {
            jsonIDs.add(getCourseID(course));
        }

        ArrayList<Achievement> achievements = DataLoader.loadAchievements();
        for (Achievement ach : achievements) {
            jsonIDs.add(getAchievementID(ach));
        }

        try (FileWriter file = new FileWriter("data/ids.json")) {

            file.write(jsonIDs.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // faculty 3, student 1
    public static JSONObject getUserID(User user) {
        JSONObject userJSON = new JSONObject();
        if (user.getType() == 1) {
            userJSON.put(STUDENT_ID, user.getUserID());
        } else if (user.getType() == 2) {
            userJSON.put(ADVISOR_ID, user.getUserID());
        } else if (user.getType() == 3) {
            userJSON.put(FACULTY_ID, user.getUserID());
        }
        return userJSON;
    }

    public static JSONObject getMajorID(Major major) {
        JSONObject majorJSON = new JSONObject();
        majorJSON.put(MAJOR_ID, major.getMajorID());
        return majorJSON;
    }

    public static JSONObject getCourseID(Course course) {
        JSONObject courseJSON = new JSONObject();
        courseJSON.put(COURSE_ID, course.getCourseID());
        return courseJSON;
    }

    public static JSONObject getAchievementID(Achievement ach) {
        JSONObject achJSON = new JSONObject();
        achJSON.put(ACHIEVEMENT_ID, ach.getAchievementID().toString());
        return achJSON;
    }
}
