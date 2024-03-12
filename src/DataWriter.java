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
    private static ArrayList<User> faculties = new ArrayList<User>();;
    private static ArrayList<User> advisors = new ArrayList<User>();;

    private static ArrayList<Course> courses = new ArrayList<Course>();

    private static ArrayList<Major> majors = new ArrayList<Major>();

    public static void parseUserList() {
        for (int i = 0; i < UserList.getInstance().getUsers().size(); i++) {
            if (UserList.getInstance().getUsers().get(i).getType() == 3) {
                faculties.add(UserList.getInstance().getUsers().get(i));
            } else if (UserList.getInstance().getUsers().get(i).getType() == 2) {
                advisors.add(UserList.getInstance().getUsers().get(i));
            } else {
                students.add(UserList.getInstance().getUsers().get(i));
            }
        }
    }

    public static void writeCourses() 
    {
        courses = CourseList.getInstance().getCourses();
        JSONArray courseJSON = new JSONArray();

        for(Course course : courses)
        {
            courseJSON.add(getCourseJSON(course));
        }

        try (FileWriter file = new FileWriter("data/dataTesting/coursewritetest.json")) {

            file.write(courseJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public static JSONObject getCourseJSON(Course course) {
        JSONObject courseJSON = new JSONObject();

        courseJSON.put(COURSE_COMMENTS, course.getCourseComments());
        courseJSON.put(COURSE_NUMBER, course.getCourseNumber());
        courseJSON.put(COURSE_ID, course.getCourseID());
        courseJSON.put(COURSE_CODE, course.getCourseCode());
        courseJSON.put(COURSE_NAME, course.getCourseName());
        courseJSON.put(COURSE_INSTRUCTOR, course.getInstructor());
        courseJSON.put(COURSE_PREREQUISITES, course.getPrerequisites());
        courseJSON.put(COURSE_DESCRIPTION, course.getDescription());
        courseJSON.put(COURSE_TOTAL_SEATS, course.getTotalSeats());
        courseJSON.put(COURSE_CREDIT_WORTH, course.getCreditWorth());
        courseJSON.put(COURSE_COREQUISITES, course.getCorequisites());
        courseJSON.put(COURSE_APPLICATION_AREA, course.isApplicationArea());
        courseJSON.put(COURSE_CAROLINA_CORE, course.isCarolinaCore());
        courseJSON.put(COURSE_ELECTIVE, course.isElective());
        courseJSON.put(COURSE_GRADE, course.getGrade());
        courseJSON.put(COURSE_ENROLLED, course.isEnrolled());
        courseJSON.put(COURSE_COMPLETED, course.isCompleted());

        return courseJSON;
    }

    public static void writeMajors() 
    {
        majors = MajorList.getInstance().getMajors();
        JSONArray majorJSON = new JSONArray();

        for(Major major : majors)
        {
            majorJSON.add(getMajorJSON(major));
        }

        try (FileWriter file = new FileWriter("data/dataTesting/majorwritetest.json")) {

            file.write(majorJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static JSONObject getMajorJSON(Major major) {
        JSONObject majorJSON = new JSONObject();

        majorJSON.put(MAJOR_ID, major.getMajorID());
        majorJSON.put(MAJOR_TITLE, major.getTitle());
        majorJSON.put(MAJOR_REQUIRED_COURSES, major.getRequiredCourses());
        majorJSON.put(MAJOR_COURSE_ID, major.getCompletedCourses());
        majorJSON.put(MAJOR_HOURS_REQUIRED, major.getHoursRequired());
        majorJSON.put(MAJOR_HOURS_COMPLETED, major.getHoursCompleted());
        majorJSON.put(MAJOR_PROGRESSION, major.getProgression());

        return majorJSON;
    }

    //curious about the proper way to write the data, should be convert from user to student somehow??
    public static void writeStudents()
    {
        JSONArray studentJSON = new JSONArray();

        for(User student : students)
        {
            studentJSON.add(getStudentJSON(student));
        }

        try (FileWriter file = new FileWriter("data/dataTesting/studentwritetest.json")) {

            file.write(studentJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static JSONObject getStudentJSON(User student)
    {
        JSONObject studentJSON = new JSONObject();

        studentJSON.put(USER_FIRST_NAME, student.getFirstName());
        studentJSON.put(USER_LAST_NAME, student.getLastName());
        studentJSON.put(USER_ID, student.getUserID());
        studentJSON.put(USER_EMAIL, student.getEmail());
        studentJSON.put(USER_USERNAME, student.getUsername());
        studentJSON.put(USER_PASSWORD, student.getPassword());
        studentJSON.put(USER_TYPE, student.getType());

        return studentJSON;
    }

    public static void writeAdvisors()
    {
        JSONArray advisorJSON = new JSONArray();

        for(User advisor : advisors)
        {
            advisorJSON.add(getAdvisorJSON(advisor));
        }

        try (FileWriter file = new FileWriter("data/dataTesting/advisorwritetest.json")) {

            file.write(advisorJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static JSONObject getAdvisorJSON(User advisor)
    {
        JSONObject advisorJSON = new JSONObject();

        advisorJSON.put(USER_FIRST_NAME, advisor.getFirstName());
        advisorJSON.put(USER_LAST_NAME, advisor.getLastName());
        advisorJSON.put(USER_ID, advisor.getUserID());
        advisorJSON.put(USER_EMAIL, advisor.getEmail());
        advisorJSON.put(USER_USERNAME, advisor.getUsername());
        advisorJSON.put(USER_PASSWORD, advisor.getPassword());
        advisorJSON.put(USER_TYPE, advisor.getType());

        return advisorJSON;
    }

    public static void writeFaculty()
    {
        JSONArray facultyJSON = new JSONArray();

        for(User faculty : faculties)
        {
            facultyJSON.add(getFacultyJSON(faculty));
        }

        try (FileWriter file = new FileWriter("data/dataTesting/facultywritetest.json")) {

            file.write(facultyJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static JSONObject getFacultyJSON(User faculty)
    {
        JSONObject facultyJSON = new JSONObject();

        facultyJSON.put(USER_FIRST_NAME, faculty.getFirstName());
        facultyJSON.put(USER_LAST_NAME, faculty.getLastName());
        facultyJSON.put(USER_ID, faculty.getUserID());
        facultyJSON.put(USER_EMAIL, faculty.getEmail());
        facultyJSON.put(USER_USERNAME, faculty.getUsername());
        facultyJSON.put(USER_PASSWORD, faculty.getPassword());
        facultyJSON.put(USER_TYPE, faculty.getType());

        return facultyJSON;
    }



    // need to have this go through the students, advisors etc as well, however i
    // just wanted to get a basic understanding of the datawriter first
    // should be pretty easy though just go through and look for the type then put
    // that users information in
    public static void writeUsers() {
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
        JSONArray userJSON = new JSONArray();

        for (User user : users) {
            userJSON.add(getUserJSON(user));
        }

        try (FileWriter file = new FileWriter("data/dataTesting/userwritetest.json")) {

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

        AchievementList achievementList = AchievementList.getInstance();
        ArrayList<Achievement> achievements = achievementList.getAchievements();

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

        for (Achievement ach : achievements) {
            jsonIDs.add(getAchievementID(ach));
        }

        try (FileWriter file = new FileWriter("data/dataTesting/ids.json")) {

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
