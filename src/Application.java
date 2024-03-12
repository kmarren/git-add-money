package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * The aplication facade.
 * @author Kennedy Marren
 */
public class Application 
{
    private User user;
    private UserList userList = UserList.getInstance();
    private CourseList courseList = CourseList.getInstance();

    private static Application application;
    
    /**
     * private constructor that will not allow other classes to create a new applicatoin
     */
    private Application()
    {
        
    }

    /**
     * creates an application if there is not one or returns the application if there is one
     * @return the application
     */
    public static Application getInstance()
    {
        if (application == null) {
			application = new Application();
		}
		return application;
    }

    /**
     * takes in the a username and password and returns the user that is trying to login
     * @param username the username attempt
     * @param password the password attempt
     * @return the user who was logged in
     */
    public boolean login(String username, String password) //returns void, sets current user to the user who just logged in
    {
        // go through the user list and finds a match to the username and password, else returns false
        user = userList.getUser(username, password);
        return userList.login(username, password);
        
    }
 
    /**
     * takes in a username and password to create a new user with the corresponding username and password
     * @param username the username given to create the new account
     * @param password the password given to create the new account
     * @return the new user
     */
    public void signUp(String username, String password, int type) // returns void, sets current user to the new user
    {
        if(type == 3)
        {
            Faculty faculty = new Faculty(username, password);
            UserList.getInstance().addUser(faculty);
            user = faculty;
        } 
        else if(type == 2)
        {
            Advisor advisor = new Advisor(username, password);
            UserList.getInstance().addUser(advisor);
            user = advisor;
        }
        else
        {
            Student student = new Student(username, password);
            UserList.getInstance().addUser(student);
            user = student;
        }

    }

    public ArrayList<Course> getCourseList() {
        return courseList.getCourses();
    }

    /**
     * adds a generalized course
     * @param courseComments The comments for the course.
     * @param courseNumber The number for the course.
     * @param courseCode The code for the course.
     * @param courseName The name of the course.
     * @param instructor The instructor for the course.
     * @param prerequisites The prerequisites for the course.
     * @param description The course description. 
     * @param totalSeats The maximum amount of student allowed to take the course.
     * @param creditWorth The number of credits the course is worth.
     * @param corequisites The corequisites for the course.
     * @param applicationArea Whether or not the course applies for an application area.
     * @param carolinaCore Whether or not the course counts for a carolina core requirement.
     * @param elective Whether or not the course counts for elective credit.
     * @return whether or not the course was added
     */
    public void addCourse(ArrayList<String> courseComments, int courseNumber, String courseCode, String courseName, 
    Faculty instructor, ArrayList<Course> prereqisites, String description, int totalSeats, int creditWorth, 
    ArrayList<Course> corequisites, boolean applicationArea, boolean carolinaCore, boolean elective)
    {
        Course course = new Course(courseComments, courseNumber, courseCode, courseName, 
        instructor, prereqisites, description, totalSeats, creditWorth, corequisites, 
        applicationArea, carolinaCore, elective);

        courseList.addCourse(course);
    }

    /**
     * adds adds a course specific to a student experience
     *@param courseComments The comments for the course.
     * @param courseNumber The number for the course.
     * @param courseCode The code for the course.
     * @param courseName The name of the course.
     * @param instructor The instructor for the course.
     * @param prerequisites The prerequisites for the course.
     * @param description The course description. 
     * @param totalSeats The maximum amount of student allowed to take the course.
     * @param creditWorth The number of credits the course is worth.
     * @param corequisites The corequisites for the course.
     * @param applicationArea Whether or not the course applies for an application area.
     * @param carolinaCore Whether or not the course counts for a carolina core requirement.
     * @param elective Whether or not the course counts for elective credit.
     * @param grade The grade a student has earned in the course.
     * @param completed Whether or not the student has completed the course.
     * @param enrolled Whether or not the student is currently enrolled in the course.
     */
    public void addStudentCourse(ArrayList<String> courseComments, int courseNumber, String courseCode, String courseName, 
    Faculty instructor, ArrayList<Course> prereqisites, String description, int totalSeats, int creditWorth, 
    ArrayList<Course> corequisites, boolean applicationArea, boolean carolinaCore, boolean elective, double grade, 
    boolean completed, boolean enrolled)
    {
        Course course = new Course(courseComments, courseNumber, courseCode, courseName, 
        instructor, prereqisites, description, totalSeats, creditWorth, corequisites, 
        applicationArea, carolinaCore, elective, grade, completed, enrolled);

        courseList.addCourse(course);
    }

    /**
     * Gets the major map of a specified major
     * @param major the specified major
     * @return a string of each class within the major's requirements
     */
    public String viewMajorMap(Major major)
    {
        return " ";
    }

    /**
     * Creates a student with all of the student's specified information. 
     * @param gpa             The GPA of the student.
     * @param minor           Whether the student has a minor.
     * @param studentComments Comments given to a student by an advisor.
     * @param enrolledCourses Courses in which the student is enrolled.
     * @param achievements    Achievements earned by the student (scholarships etc.)
     * @param advisor         The advisor assigned to the student.
     * @param riskFailing     Whether the student is at risk of failing.
     * @param hoursCompleted  The number of completed hours by the student.
     * @param studentID       The ID of the student.
     * @param firstName       The first name of the student.
     * @param lastName        The last name of the student.
     * @param email           The email address of the student.
     * @param username        The username of the student.
     * @param password        The password of the student.
     * @param major           The mojor of the student.
     */
    public void addStudent(double gpa, boolean minor, ArrayList<String> studentComments, ArrayList<UUID> enrolledCourses,
    ArrayList<UUID> achievements, UUID advisor, boolean riskFailing, double hoursCompleted,
    String studentID, String firstName, String lastName, String email, String username, String password )
    {
        Student student = new Student(gpa, minor, studentComments, enrolledCourses, achievements, advisor, riskFailing,
                                  hoursCompleted, firstName, lastName, email, username, password, major);
        userList.addUser(student);
    }

    /**
     * Creates an advisor with all of the advisor's specified information.
     * @param advisorId     The ID of the advisor.
     * @param office        The location of the advisor's office
     * @param officeHours   The office hours of the advisor.
     * @param phoneNumber   The advisor's phone number.
     * @param adviseeList   A list of all the students the advisor has to advise.
     * @param schoolOfFocus The school the advisor focuses on.
     * @param appointments  A list of all the appointments the advisor has available.
     * @param firstName     The first name of the advisor.
     * @param lastName      The last name of the advisor.
     * @param email         The email address of the advisor.
     * @param username      The username of the advisor.
     * @param password      The password of the advisor.
     */
    public void addAdvisor(String office, String officeHours,
    String phoneNumber, ArrayList<UUID> adviseeList, String schoolOfFocus,
    ArrayList<UUID> appointments, String firstName, String lastName,
    String email, String username, String password)
    {
        Advisor advisor = new Advisor(office, officeHours, phoneNumber, adviseeList, schoolOfFocus, appointments,
                firstName, lastName, email, username, password);
        UserList.getInstance().addUser(advisor);
    }

    /**
     * Creates a new faculty member. 
     * @param officeHours The office hours of the faculty member.
     * @param studentList The student list of the faculty member.
     * @param firstName The first name of the faculty member
     * @param lastName The last name of the faculty member
     * @param email The email of the faculty member
     * @param username The username of the faculty member
     * @param password The password of the faculty member
     */
    public void addFaculty(String officeHours, ArrayList<Student> studentList, 
    String firstName, String lastName, String email, String username, String password)
    {
        Faculty faculty = new Faculty(officeHours, studentList, firstName, lastName, email, username, password);
        UserList.getInstance().addUser(faculty);
    }

    /**
     * Takes in a search field from the user and returns a list of related coursed
     * @param keyword the name, number, or code of the course, or something similar 
     * @return a list of courses that contain the keyword in their information
     */
    public ArrayList<Course> findCourse(String keyword)
    {
        ArrayList<Course> courseList = new ArrayList<Course>();
        return courseList;
    }

    /**
     * Allows a student to book an appointment with their advisor based on the time, location, and advisor they enter
     * @param time the time of the appointment
     * @param location where the appointment will take place
     * @param advisor the students assigned advisor
     */
    public void bookAppointment(String time, String location, Advisor advisor)
    {
        
    }

    /**
     * Allows a student to view their degree path if they were to change their major
     * @param newMajor the major the student wishes to view for a potential major change
     * @return the major map of the new major with the students specific information and completed classes included
     */
    public String viewWhatIf(Major newMajor)
    {
       return " ";
    }

    /**
     * Allows the student to 
     * @param student the student the advisor wishes to send the comment to
     * @param comment the comment the advisor wishes to send
     */
    public void sendStudentComment(Student student, String comment)
    {
        ArrayList<String> comments = student.getStudentComments();
        comments.add(comment);
        student.setStudentComments(comments);
    }

    /**
     * Adds an achievement to the students list of achievements
     * @param achievement the achievement being added to the students list
     * @return A string representation of the advisor's list of advisees.
     */
    public void addAchievement(Achievement achievement)
    {

    }

    /**
     * Gets the advisors list of advisees
     */
    public String viewAdvisees() {
        StringBuilder result = new StringBuilder();
    ArrayList<Student> advisees = Advisor.viewAdvisees(); //

    if (advisees.isEmpty()) {
        result.append("No advisees.");
    } else {
        result.append("Advisees:\n");
        for (Student student : advisees) {
            result.append(student.getFirstName()).append(" ").append(student.getLastName()).append("\n");
        }
    }
    return result.toString();
    }

    /**
     * Takes in a student from the user and returns their information as a String
     * @param student the student whos information will be displayed
     * @return the students information
     */
    public String viewStudent(Student student)
    {
        return " ";
    }

    /**
     * Retrieves an advisors list of available appointments
     * @return the advisors available appointments
     */
    public ArrayList<Appointment> getAppointments()
    {
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        return appointments;
    }

    /**
     * Allows an advisor to add a student to their list of advisees
     * @param advisor The advisor to whom the student will be added as an advisee.
     * @param student the student to be added to the list 
     */
    public void addAdvisee(Advisor advisor, Student student)
    {
        advisor.addAdvisee(student);
    }

    /**
     * Allows an advisor to add an appointment to their list of available appointments
     * @param advisor the advisor whose list of appointments will be added to
     * @param time the time of the new appointment
     * @param location the location of the new appointment
     * @return whether or not the new appointment is added successfully
     */
    public boolean addAppointment(Advisor advisor, String time, String location)
    {
        return true;
    }


    /**
     * takes in a course and returns the information about the course
     * @param course the course's information to be viewed
     */
    public String viewCourse(Course course)
    {
        return course.toString();
    }



}
