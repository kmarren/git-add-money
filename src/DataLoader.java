package src;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

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
                    Major major = null;
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
                     * for (Object achievementObj : achievementsArray) {
                     * JSONObject achievementJson = (JSONObject) achievementObj;
                     * String achievementID = (String) achievementJson.get("achievementID");
                     * achievements.add(achievementID);
                     * }
                     */
                    double gpa = (double) studentJsonObj.get("gpa");
                    JSONArray enrolledCoursesArray = (JSONArray) studentJsonObj.get("enrolledCourses");
                    ArrayList<Course> enrolledCourses = new ArrayList<>();
                    /*
                     * for (Object courseObj : enrolledCoursesArray) {
                     * JSONObject courseJson = (JSONObject) courseObj;
                     * String courseID = (String) courseJson.get("courseID");
                     * enrolledCourses.add(courseID);
                     * }
                     */
                    Advisor advisor = null; // add an advisor later??
                    boolean riskFailing = (boolean) studentJsonObj.get("riskFailing");
                    double hoursCompleted = (double) studentJsonObj.get("hoursCompleted");

                    // Create Student object
                    Student student = new Student(gpa, minor, studentComments, enrolledCourses, achievements, advisor,
                            riskFailing,
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
                Major major = null;
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
                 * for (Object achievementObj : achievementsArray) {
                 * JSONObject achievementJson = (JSONObject) achievementObj;
                 * String achievementID = (String) achievementJson.get("achievementID");
                 * achievements.add(achievementID);
                 * }
                 */
                double gpa = (double) studentJsonObj.get("gpa");
                JSONArray enrolledCoursesArray = (JSONArray) studentJsonObj.get("enrolledCourses");
                ArrayList<Course> enrolledCourses = new ArrayList<>();
                /*
                 * for (Object courseObj : enrolledCoursesArray) {
                 * JSONObject courseJson = (JSONObject) courseObj;
                 * String courseID = (String) courseJson.get("courseID");
                 * enrolledCourses.add(courseID);
                 * }
                 */
                Advisor advisor = new Advisor();
                boolean riskFailing = (boolean) studentJsonObj.get("riskFailing");
                double hoursCompleted = (double) studentJsonObj.get("hoursCompleted");

                // Create Student object
                Student student = new Student(gpa, minor, studentComments, enrolledCourses, achievements, advisor,
                        riskFailing,
                        hoursCompleted, firstName, lastName, email, username, password, major);

                // Add student to the list
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static ArrayList<Course> loadCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray courseArray = (JSONArray) parser.parse(reader);

            for (Object obj : courseArray) {
                JSONObject courseObj = (JSONObject) obj;

                ArrayList<String> courseComments = (ArrayList<String>) courseObj.get(COURSE_COMMENTS);
                int courseNumber = Integer.parseInt(courseObj.get(COURSE_NUMBER).toString());
                String courseCode = (String) courseObj.get(COURSE_CODE);
                String courseName = (String) courseObj.get(COURSE_NAME);
                // Parsing instructor information
                Faculty instructor = null; // also need to add an instructor later
                // Parsing prerequisites
                JSONArray prerequisitesArray = (JSONArray) courseObj.get(COURSE_PREREQUISITES); // not going to be fun
                ArrayList<Course> prerequisites = new ArrayList<>();
                /*
                 * for (Object prereqObj : prerequisitesArray) {
                 * JSONObject prereqJson = (JSONObject) prereqObj;
                 * String prereqCourseID = (String) prereqJson.get("courseID");
                 * // Assuming you have a method to fetch a course by its ID
                 * Course prereqCourse = fetchCourseByID(prereqCourseID);
                 * prerequisites.add(prereqCourse);
                 * }
                 */
                String description = (String) courseObj.get(COURSE_DESCRIPTION);
                int totalSeats = Integer.parseInt(courseObj.get(COURSE_TOTAL_SEATS).toString());
                int creditWorth = Integer.parseInt(courseObj.get(COURSE_CREDIT_WORTH).toString());
                // Parsing corequisites, applicationArea, carolinaCore, elective, grade,
                // completed, and enrolled
                // These fields are straightforward to parse
                // Creating Course object
                Course course = new Course(courseComments, courseNumber, courseCode, courseName, instructor,
                        prerequisites, description, totalSeats, creditWorth, new ArrayList<>(), false, false,
                        false, 0.0, false, false);
                courses.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }

    public static ArrayList<Faculty> loadFaculty() {
        ArrayList<Faculty> facultyList = new ArrayList<>();
        try {
            FileReader reader = new FileReader(FACULTY_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray facultyArray = (JSONArray) parser.parse(reader);

            for (Object obj : facultyArray) {
                JSONObject facultyObj = (JSONObject) obj;

                String firstName = (String) facultyObj.get(FACULTY_FIRST_NAME);
                String lastName = (String) facultyObj.get(FACULTY_LAST_NAME);
                String email = (String) facultyObj.get(FACULTY_EMAIL);
                String username = (String) facultyObj.get(FACULTY_USERNAME);
                String password = (String) facultyObj.get(FACULTY_PASSWORD);
                String officeHours = (String) facultyObj.get(FACULTY_OFFICE_HOURS);

                ArrayList<Student> studentList = new ArrayList<>(); // Defaulting to an empty list

                Faculty faculty = new Faculty(officeHours, studentList, firstName, lastName, email, username, password);
                facultyList.add(faculty);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return facultyList;
    }

    // Load advisors method
    public static ArrayList<Advisor> loadAdvisors() {
        ArrayList<Advisor> advisorList = new ArrayList<>();
        try {
            FileReader reader = new FileReader(ADVISORS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray advisorArray = (JSONArray) parser.parse(reader);

            for (Object obj : advisorArray) {
                JSONObject advisorObj = (JSONObject) obj;

                String office = (String) advisorObj.get(ADVISOR_OFFICE);
                String officeHours = (String) advisorObj.get(ADVISOR_OFFICE_HOURS);
                String phoneNumber = (String) advisorObj.get(ADVISOR_PHONE_NUMBER);
                // Advises List
                JSONArray adviseeListArray = (JSONArray) advisorObj.get(ADVISOR_ADVISEE_LIST);
                ArrayList<Student> adviseeList = new ArrayList<>();
                // Assuming adviseeList needs to be populated
                // Advises List

                String schoolOfFocus = (String) advisorObj.get(ADVISOR_SCHOOL_OF_FOCUS);
                // Appointments
                JSONArray appointmentsArray = (JSONArray) advisorObj.get(ADVISOR_APPOINTMENTS);
                ArrayList<Appointment> appointments = new ArrayList<>();
                // Assuming appointments needs to be populated
                // Appointments

                String firstName = (String) advisorObj.get(ADVISOR_FIRST_NAME);
                String lastName = (String) advisorObj.get(ADVISOR_LAST_NAME);
                String email = (String) advisorObj.get(ADVISOR_EMAIL);
                String username = (String) advisorObj.get(ADVISOR_USERNAME);
                String password = (String) advisorObj.get(ADVISOR_PASSWORD);

                // Create Advisor object and add to the list
                Advisor advisor = new Advisor(office, officeHours, phoneNumber, adviseeList, schoolOfFocus,
                        appointments,
                        firstName, lastName, email, username, password);
                advisorList.add(advisor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return advisorList;
    }
}
