package src;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author Jacob Robertson
 */

public class DataLoader extends DataConstants {

    // load students method
    public static ArrayList<User> loadStudents() {
        ArrayList<User> students = new ArrayList<>();
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
                    // JSONArray achievementsArray = (JSONArray)
                    // studentJsonObj.get(STUDENT_ACHIEVEMENTS);
                    ArrayList<Achievement> achievements = new ArrayList<>();
                    /*
                     * for (Object achievementObj : achievementsArray) {
                     * JSONObject achievementJson = (JSONObject) achievementObj;
                     * String achievementID = (String) achievementJson.get("achievementID");
                     * achievements.add(achievementID);
                     * }
                     */
                    double gpa = (double) studentJsonObj.get(STUDENT_GPA);
                    Advisor advisor = null; // add an advisor later??
                    boolean riskFailing = (boolean) studentJsonObj.get(STUDENT_RISK_FAILING);
                    double hoursCompleted = (double) studentJsonObj.get(STUDENT_HOURS_COMPLETED);
                    String studentID = (String) studentJsonObj.get(STUDENT_ID);
                    UUID uuid = UUID.fromString(studentID);

                    // Create Student object
                    Student student = new Student(gpa, minor, studentComments, achievements, advisor,
                            riskFailing,
                            hoursCompleted, firstName, lastName, email, username, password, major);
                    student.setUserID(uuid);
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
                // JSONArray achievementsArray = (JSONArray)
                // studentJsonObj.get(STUDENT_ACHIEVEMENTS);
                ArrayList<Achievement> achievements = new ArrayList<>();
                /*
                 * for (Object achievementObj : achievementsArray) {
                 * JSONObject achievementJson = (JSONObject) achievementObj;
                 * String achievementID = (String) achievementJson.get("achievementID");
                 * achievements.add(achievementID);
                 * }
                 */
                double gpa = (double) studentJsonObj.get(STUDENT_GPA);
                Advisor advisor = null;
                boolean riskFailing = (boolean) studentJsonObj.get(STUDENT_RISK_FAILING);
                double hoursCompleted = (double) studentJsonObj.get(STUDENT_HOURS_COMPLETED);
                String studentID = (String) studentJsonObj.get(STUDENT_ID);
                UUID uuid = UUID.fromString(studentID);

                // Create Student object
                Student student = new Student(gpa, minor, studentComments, achievements, advisor,
                        riskFailing,
                        hoursCompleted, firstName, lastName, email, username, password, major);
                student.setUserID(uuid);

                // Add student to the list
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    // load courses method
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
                // JSONArray prerequisitesArray = (JSONArray)
                // courseObj.get(COURSE_PREREQUISITES); // not going to be fun
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
                ArrayList<Course> coreqs = new ArrayList<>();
                Boolean appArea = Boolean.parseBoolean(courseObj.get(COURSE_APPLICATION_AREA).toString());
                Boolean carolinaCore = Boolean.parseBoolean(courseObj.get(COURSE_CAROLINA_CORE).toString());
                Boolean elective = Boolean.parseBoolean(courseObj.get(COURSE_ELECTIVE).toString());
                double grade = Double.parseDouble(courseObj.get(COURSE_GRADE).toString());
                Boolean completed = Boolean.parseBoolean(courseObj.get(COURSE_COMPLETED).toString());
                Boolean enrolled = Boolean.parseBoolean(courseObj.get(COURSE_ENROLLED).toString());
                String courseID = (String) courseObj.get(COURSE_ID);
                UUID uuid = UUID.fromString(courseID);
                Course course = new Course(courseComments, courseNumber, courseCode, courseName, instructor,
                        prerequisites, description, totalSeats, creditWorth, coreqs, appArea, carolinaCore, elective);
                course.setCourseID(uuid);
                courses.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }

    // load faculty method
    public static ArrayList<User> loadFaculty() {
        ArrayList<User> facultyList = new ArrayList<>();
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
                String facultyID = (String) facultyObj.get(FACULTY_ID);
                UUID uuid = UUID.fromString(facultyID);
                Faculty faculty = new Faculty(officeHours, studentList, firstName, lastName, email, username, password);
                faculty.setUserID(uuid);
                facultyList.add(faculty);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return facultyList;
    }

    // Load advisors method
    public static ArrayList<User> loadAdvisors() {
        ArrayList<User> advisorList = new ArrayList<>();
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
                // JSONArray adviseeListArray = (JSONArray)
                // advisorObj.get(ADVISOR_ADVISEE_LIST);
                ArrayList<Student> adviseeList = new ArrayList<>();
                // Assuming adviseeList needs to be populated
                // Advises List

                String schoolOfFocus = (String) advisorObj.get(ADVISOR_SCHOOL_OF_FOCUS);
                // Appointments
                // JSONArray appointmentsArray = (JSONArray)
                // advisorObj.get(ADVISOR_APPOINTMENTS);
                ArrayList<Appointment> appointments = new ArrayList<>();
                // Assuming appointments needs to be populated
                // Appointments

                String firstName = (String) advisorObj.get(ADVISOR_FIRST_NAME);
                String lastName = (String) advisorObj.get(ADVISOR_LAST_NAME);
                String email = (String) advisorObj.get(ADVISOR_EMAIL);
                String username = (String) advisorObj.get(ADVISOR_USERNAME);
                String password = (String) advisorObj.get(ADVISOR_PASSWORD);
                String advisorID = (String) advisorObj.get(ADVISOR_ID);
                UUID uuid = UUID.fromString(advisorID);
                // Create Advisor object and add to the list
                Advisor advisor = new Advisor(office, officeHours, phoneNumber, adviseeList, schoolOfFocus,
                        appointments,
                        firstName, lastName, email, username, password);
                advisor.setUserID(uuid);
                advisorList.add(advisor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return advisorList;
    }

    public static ArrayList<Major> loadMajors() {
        ArrayList<Major> majorList = new ArrayList<>();
        try {
            // Read JSON file
            FileReader reader = new FileReader(MAJOR_FILE_NAME);
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);

            JSONArray majorsArray = (JSONArray) obj;
            // Assuming you have some JSON array of majors
            for (Object majorObj : majorsArray) {
                if (majorObj instanceof JSONObject) {
                    JSONObject majorJson = (JSONObject) majorObj;
                    String title = (String) majorJson.get(MAJOR_TITLE);

                    // JSONArray requiredCoursesJsonArray = (JSONArray)
                    // majorJson.get(MAJOR_REQUIRED_COURSES);
                    ArrayList<Course> requiredCourses = new ArrayList<>();
                    ArrayList<Course> completedCourses = new ArrayList<>();
                    ArrayList<Course> enrolledCourses = new ArrayList<>();
                    int hoursRequired = Integer.parseInt(majorJson.get(MAJOR_HOURS_REQUIRED).toString());
                    int hoursCompleted = Integer.parseInt(majorJson.get(MAJOR_HOURS_COMPLETED).toString());
                    double progression = Double.parseDouble(majorJson.get(MAJOR_PROGRESSION).toString());
                    String majorId = (String) majorJson.get(MAJOR_ID);
                    UUID uuid = UUID.fromString(majorId);
                    // Create Major object and add to list
                    Major major = new Major(title, requiredCourses, completedCourses, hoursRequired, hoursCompleted,
                            progression, enrolledCourses);
                    major.setMajorID(uuid);
                    majorList.add(major);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return majorList;
    }

    public static ArrayList<Achievement> loadAchievements() {
        ArrayList<Achievement> achievementList = new ArrayList<>();
        try {
            // Read JSON file
            FileReader reader = new FileReader(ACHIEVEMENT_FILE_NAME);
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);

            JSONArray achievementsArray = (JSONArray) obj;
            for (Object achievementObj : achievementsArray) {
                if (achievementObj instanceof JSONObject) {
                    JSONObject achievementJson = (JSONObject) achievementObj;
                    String name = (String) achievementJson.get(ACHIEVEMENT_NAME);
                    String type = (String) achievementJson.get(ACHIEVEMENT_TYPE);
                    String benefits = (String) achievementJson.get(ACHIEVEMENT_BENEFITS);
                    String semester = (String) achievementJson.get(ACHIEVEMENT_SEMESTER);
                    String description = (String) achievementJson.get(ACHIEVEMENT_DESCRIPTION);
                    Boolean scholarship = Boolean.parseBoolean(achievementJson.get(COURSE_COMPLETED).toString());

                    // Create Achievement object and add to list
                    Achievement achievement = new Achievement(name, type, benefits, semester,
                            description, scholarship);
                    achievementList.add(achievement);
                }
            }
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }
        return achievementList;
    }
}
