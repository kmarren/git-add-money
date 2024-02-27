package src;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

    public static ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();
    try {
        FileReader reader = new FileReader(STUDENT_FILE_NAME);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(reader);

        if (obj instanceof JSONArray) {
            JSONArray studentJSON = (JSONArray) obj;
            // Process array of students
            for (Object studentObj : studentJSON) {
                JSONObject studentJsonObj = (JSONObject) studentObj;
                // Parse student data and create Student objects
                String firstName = (String) studentJsonObj.get(STUDENT_FIRST_NAME);
                String lastName = (String) studentJsonObj.get(STUDENT_LAST_NAME);
                String email = (String) studentJsonObj.get(STUDENT_EMAIL);
                String username = (String) studentJsonObj.get(STUDENT_USERNAME);
                String password = (String) studentJsonObj.get(STUDENT_PASSWORD);
                Major major = new Major();
                boolean minor = (boolean) studentJsonObj.get(STUDENT_MINOR);
                JSONArray commentsArray = (JSONArray) studentJsonObj.get(STUDENT_COMMENTS);
                ArrayList<String> studentComments = new ArrayList<>();
                for (Object commentObj : commentsArray) {
                    String comment = (String) commentObj;
                    studentComments.add(comment);
                }
                JSONArray achievementsArray = (JSONArray) studentJsonObj.get(STUDENT_ACHIEVEMENTS);
                ArrayList<Achievement> achievements = new ArrayList<>();
                /* 
                for (Object achievementObj : achievementsArray) {
                    JSONObject achievementJson = (JSONObject) achievementObj;
                    String achievementID = (String) achievementJson.get("achievementID");
                    achievements.add(achievementID);
                }
                */
                double gpa = (double) studentJsonObj.get("gpa");
                JSONArray enrolledCoursesArray = (JSONArray) studentJsonObj.get("enrolledCourses");
                ArrayList<Course> enrolledCourses = new ArrayList<>();
                /* 
                for (Object courseObj : enrolledCoursesArray) {
                    JSONObject courseJson = (JSONObject) courseObj;
                    String courseID = (String) courseJson.get("courseID");
                    enrolledCourses.add(courseID);
                }
                */
                Advisor advisor = null; // add an advisor later??
                boolean riskFailing = (boolean) studentJsonObj.get("riskFailing");
                double hoursCompleted = (double) studentJsonObj.get("hoursCompleted");
                
                // Create Student object
                Student student = new Student(gpa, minor, studentComments, enrolledCourses, achievements, advisor, riskFailing,
                hoursCompleted, firstName, lastName, email, username, password, major);
                
                // Add student to the list
                students.add(student);
            }
        } else if (obj instanceof JSONObject) {
            JSONObject studentJsonObj = (JSONObject) obj;
            // Process single student object
            // Parse student data and create Student object
            String firstName = (String) studentJsonObj.get(STUDENT_FIRST_NAME);
            String lastName = (String) studentJsonObj.get(STUDENT_LAST_NAME);
            String email = (String) studentJsonObj.get(STUDENT_EMAIL);
            String username = (String) studentJsonObj.get(STUDENT_USERNAME);
            String password = (String) studentJsonObj.get(STUDENT_PASSWORD);
            Major major = new Major();
            boolean minor = (boolean) studentJsonObj.get(STUDENT_MINOR);
            JSONArray commentsArray = (JSONArray) studentJsonObj.get(STUDENT_COMMENTS);
            ArrayList<String> studentComments = new ArrayList<>();
            for (Object commentObj : commentsArray) {
                String comment = (String) commentObj;
                studentComments.add(comment);
            }
            JSONArray achievementsArray = (JSONArray) studentJsonObj.get(STUDENT_ACHIEVEMENTS);
            ArrayList<Achievement> achievements = new ArrayList<>();
            /* 
            for (Object achievementObj : achievementsArray) {
                JSONObject achievementJson = (JSONObject) achievementObj;
                String achievementID = (String) achievementJson.get("achievementID");
                achievements.add(achievementID);
            }
            */
            double gpa = (double) studentJsonObj.get("gpa");
            JSONArray enrolledCoursesArray = (JSONArray) studentJsonObj.get("enrolledCourses");
            ArrayList<Course> enrolledCourses = new ArrayList<>();
            /* 
            for (Object courseObj : enrolledCoursesArray) {
                JSONObject courseJson = (JSONObject) courseObj;
                String courseID = (String) courseJson.get("courseID");
                enrolledCourses.add(courseID);
            }
            */
            Advisor advisor = new Advisor();
            boolean riskFailing = (boolean) studentJsonObj.get("riskFailing");
            double hoursCompleted = (double) studentJsonObj.get("hoursCompleted");
            
            // Create Student object
            Student student = new Student(gpa, minor, studentComments, enrolledCourses, achievements, advisor, riskFailing,
            hoursCompleted, firstName, lastName, email, username, password, major);
            
            // Add student to the list
            students.add(student);
        } else {
            // Handle unsupported JSON format
            System.err.println("Unsupported JSON format");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return students;
    }
}
