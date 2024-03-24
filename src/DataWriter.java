package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    private static ArrayList<Student> students = new ArrayList<Student>();
    private static ArrayList<Faculty> faculties = new ArrayList<Faculty>();;
    private static ArrayList<Advisor> advisors = new ArrayList<Advisor>();;

    private static ArrayList<Course> courses = new ArrayList<Course>();

    private static ArrayList<Major> majors = new ArrayList<Major>();
    private static UserList userList = UserList.getInstance();

    public static void parseUserList() {
        ArrayList<User> users = userList.getUsers();
        for (User user : users) {
            if (user instanceof Student) {
                students.add((Student) user);
            } else if (user instanceof Faculty) {
                faculties.add((Faculty) user);
            } else if (user instanceof Advisor) {
                advisors.add((Advisor) user);
            }
        }

    }

    public static void writeCourses() {
        courses = CourseList.getInstance().getCourses();
        JSONArray courseJSON = new JSONArray();

        for (Course course : courses) {
            courseJSON.add(getCourseJSON(course));
        }

        try (FileWriter file = new FileWriter("data/courses.json")) {

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
        ArrayList<Course> prereqArrayList = course.getPrerequisites();
        ArrayList<String> idPrereqStrings = new ArrayList<>();
        for (Course prereq : prereqArrayList) {
            idPrereqStrings.add(prereq.getCourseID());
        }
        courseJSON.put(COURSE_PREREQUISITES, idPrereqStrings);
        courseJSON.put(COURSE_DESCRIPTION, course.getDescription());
        courseJSON.put(COURSE_TOTAL_SEATS, course.getTotalSeats());
        courseJSON.put(COURSE_CREDIT_WORTH, course.getCreditWorth());
        ArrayList<Course> coreqArrayList = course.getCorequisites();
        ArrayList<String> idCoreqList = new ArrayList<>();
        for (Course coreq : coreqArrayList) {
            idCoreqList.add(coreq.getCourseID());
        }
        courseJSON.put(COURSE_COREQUISITES, idCoreqList);
        courseJSON.put(COURSE_APPLICATION_AREA, course.isApplicationArea());
        courseJSON.put(COURSE_CAROLINA_CORE, course.isCarolinaCore());
        courseJSON.put(COURSE_ELECTIVE, course.isElective());
        courseJSON.put(COURSE_GRADE, course.getGrade());
        courseJSON.put(COURSE_ENROLLED, course.isEnrolled());
        courseJSON.put(COURSE_COMPLETED, course.isCompleted());

        return courseJSON;
    }

    public static void writeMajors() {
        majors = MajorList.getInstance().getMajors();
        JSONArray majorJSON = new JSONArray();

        for (Major major : majors) {
            majorJSON.add(getMajorJSON(major));
        }

        try (FileWriter file = new FileWriter("data/majors.json")) {

            file.write(majorJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static JSONObject getMajorJSON(Major major) {
        JSONObject majorJSON = new JSONObject();
        JSONArray reqCourseID = new JSONArray();

        majorJSON.put(MAJOR_ID, major.getMajorID());
        majorJSON.put(MAJOR_TITLE, major.getTitle());
        majorJSON.put(MAJOR_HOURS_REQUIRED, major.getHoursRequired());

        ArrayList<Course> reqCourses = major.getRequiredCourses();
        for (Course course : reqCourses) {
            reqCourseID.add(getCourseID(course));
        }
        majorJSON.put(MAJOR_REQUIRED_COURSES, reqCourseID);

        return majorJSON;
    }

    // curious about the proper way to write the data, should be convert from user
    // to student somehow??
    public static void writeStudents() {
        JSONArray studentJSON = new JSONArray();

        for (Student student : students) {
            studentJSON.add(getStudentJSON(student));
        }

        try (FileWriter file = new FileWriter("data/students.json")) {

            file.write(studentJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static JSONObject getStudentJSON(Student student) {
        JSONObject studentJSON = new JSONObject();
        JSONArray enrolledCourseID = new JSONArray();
        JSONArray completedCourseID = new JSONArray();
        JSONArray achievementID = new JSONArray();


        studentJSON.put(STUDENT_FIRST_NAME, student.getFirstName());
        studentJSON.put(STUDENT_LAST_NAME, student.getLastName());
        studentJSON.put(STUDENT_ID, student.getUserID().toString());
        studentJSON.put(STUDENT_EMAIL, student.getEmail());
        studentJSON.put(STUDENT_USERNAME, student.getUsername());
        studentJSON.put(STUDENT_PASSWORD, student.getPassword());
        Major studentMajor = student.getMajor();
        if (studentMajor != null && studentMajor.getMajorID() != null) {
            studentJSON.put(STUDENT_MAJOR_ID, studentMajor.getMajorID().toString());
        } else {
            studentJSON.put(STUDENT_MAJOR_ID, null);
        }
        studentJSON.put(STUDENT_MINOR, student.hasMinor());
        studentJSON.put(STUDENT_COMMENTS, student.getStudentComments());
        studentJSON.put(STUDENT_GPA, student.getGpa());
        Advisor advisor = student.getAdvisor();
        if (advisor != null && advisor.getUserStringID() != null) {
            studentJSON.put(STUDENT_ADVISOR, advisor.getUserStringID());
        } else {
            studentJSON.put(STUDENT_ADVISOR, null);
        }
        // studentJSON.put(STUDENT_ADVISOR,
        // student.getAdvisor().getUserID().toString());
        studentJSON.put(STUDENT_RISK_FAILING, student.isRiskFailing());
        studentJSON.put(STUDENT_HOURS_COMPLETED, student.getHoursCompleted());

        ArrayList<Course> enrolledCourses = student.getEnrolledCourses();
        for (Course course : enrolledCourses) {
            enrolledCourseID.add(getCourseID(course));
        }
        studentJSON.put(STUDENT_COMPLETED_COURSES, enrolledCourseID);

        ArrayList<Course> completedCourses = student.getCompletedCourses();
        for (Course course : completedCourses) {
            completedCourseID.add(getCourseID(course));
        }
        studentJSON.put(STUDENT_COMPLETED_COURSES, completedCourseID);

        ArrayList<Achievement> achievements = student.getAchievements();
        for (Achievement achievement : achievements) {
            achievementID.add(getAchievementID(achievement));
        }
        studentJSON.put(STUDENT_ACHIEVEMENTS, achievementID);

        return studentJSON;
    }

    public static void writeAdvisors() {
        JSONArray advisorJSON = new JSONArray();

        for (Advisor advisor : advisors) {
            advisorJSON.add(getAdvisorJSON(advisor));
        }

        try (FileWriter file = new FileWriter("data/advisors.json")) {

            file.write(advisorJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static JSONObject getAdvisorJSON(Advisor advisor) {
        JSONObject advisorJSON = new JSONObject();
        JSONArray studentIDs = new JSONArray();
        JSONArray appointmentIDs = new JSONArray();

        advisorJSON.put(ADVISOR_FIRST_NAME, advisor.getFirstName());
        advisorJSON.put(ADVISOR_LAST_NAME, advisor.getLastName());
        advisorJSON.put(ADVISOR_ID, advisor.getUserID().toString());
        advisorJSON.put(ADVISOR_EMAIL, advisor.getEmail());
        advisorJSON.put(ADVISOR_USERNAME, advisor.getUsername());
        advisorJSON.put(ADVISOR_PASSWORD, advisor.getPassword());
        advisorJSON.put(ADVISOR_OFFICE, advisor.getOffice());
        advisorJSON.put(ADVISOR_OFFICE_HOURS, advisor.getOfficeHours());
        advisorJSON.put(ADVISOR_PHONE_NUMBER, advisor.getPhoneNumber());
        ArrayList<Student> students = advisor.getAdviseeList();
        for (Student student : students) {
            studentIDs.add(getStudentID(student));
        }
        advisorJSON.put(ADVISOR_ADVISEE_LIST, studentIDs);
        advisorJSON.put(ADVISOR_SCHOOL_OF_FOCUS, advisor.getSchoolOfFocus());
        ArrayList<Appointment> Appointments = advisor.getAppointments();
        for (Appointment appointment : Appointments) {
            appointmentIDs.add(getAppointmentID(appointment));
        }
        advisorJSON.put(ADVISOR_APPOINTMENTS, appointmentIDs);

        return advisorJSON;
    }

    public static JSONObject getAppointmentID(Appointment appointment) {
        JSONObject appointmentJSON = new JSONObject();
        appointmentJSON.put(APPOINTMENT_ID, appointment.getAppointmentID().toString());
        return appointmentJSON;
        }

    public static void writeFaculty() {
        JSONArray facultyJSON = new JSONArray();

        for (Faculty faculty : faculties) {
            facultyJSON.add(getFacultyJSON(faculty));
        }

        try (FileWriter file = new FileWriter("data/faculty.json")) {

            file.write(facultyJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static JSONObject getFacultyJSON(Faculty faculty) {
        JSONObject facultyJSON = new JSONObject();
        JSONArray studentIDs = new JSONArray();

        facultyJSON.put(FACULTY_FIRST_NAME, faculty.getFirstName());
        facultyJSON.put(FACULTY_LAST_NAME, faculty.getLastName());
        facultyJSON.put(FACULTY_ID, faculty.getUserID().toString());
        facultyJSON.put(FACULTY_EMAIL, faculty.getEmail());
        facultyJSON.put(FACULTY_USERNAME, faculty.getUsername());
        facultyJSON.put(FACULTY_PASSWORD, faculty.getPassword());
        facultyJSON.put(FACULTY_OFFICE_HOURS, faculty.getOfficeHours());
        ArrayList<Student> students = faculty.getStudentList();
        for (Student student : students) {
            studentIDs.add(getStudentID(student));
        }
        facultyJSON.put(FACULTY_STUDENT_LIST, studentIDs);

        return facultyJSON;
    }
    
    public static JSONObject getStudentID(Student student) {
        JSONObject studentJSON = new JSONObject();
        studentJSON.put(STUDENT_ID, student.getUserID().toString());
        return studentJSON;
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

        try (FileWriter file = new FileWriter("data/users.json")) {

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
        userJSON.put(USER_ID, user.getUserID().toString());
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
            userJSON.put(STUDENT_ID, user.getUserID().toString());
        } else if (user.getType() == 2) {
            userJSON.put(ADVISOR_ID, user.getUserID().toString());
        } else if (user.getType() == 3) {
            userJSON.put(FACULTY_ID, user.getUserID().toString());
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
