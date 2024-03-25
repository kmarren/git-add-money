package testing;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import src.Advisor;
import src.Application;
import src.Appointment;
import src.Student;
import src.User;
import src.UserList;
import src.CourseList;
import src.Faculty;
import src.AppointmentList;
import src.Course;
public class ApplicationTest {

    private Application application;
    private ArrayList<User> users;
    private ArrayList<Course> courses;
    private ArrayList<Appointment> appointments;
    private Student student;
    private Advisor advisor;
    private Faculty faculty;
    private UserList userList;

    @Before
    public void setUp() {
        application = Application.getInstance();
        

        // Initialize the lists
        users = new ArrayList<>();
        courses = new ArrayList<>();
        appointments = new ArrayList<>();
        userList = UserList.getInstance();

        student = new Student("John", "Doe", "john@example.com", "johndoe", "password");
        advisor = new Advisor("username", "password");
        faculty = new Faculty("facultyUsername", "facultyPassword");
        User existingUser = new Student("Braxton", "West", "braxwest@example.com", "braxwest", "password4brax");
        UserList.getInstance().addUser(existingUser);
        users.add(student);
        users.add(advisor);
        users.add(faculty);

        ArrayList<String> courseComments = new ArrayList<>();
        courseComments.add("Important course for the degree");
        ArrayList<Course> prerequisites = new ArrayList<>();
        ArrayList<Course> corequisites = new ArrayList<>();

        Course math101 = new Course(courseComments, 101, "MATH101", "Math 101", 
                                    faculty, prerequisites, "Mathematics fundamentals", 
                                    30, 3, corequisites, false, true, 
                                    false, 0.0, false, false);
        courses.add(math101);

        Appointment appointment = new Appointment(student, "2023-10-01 10:00", "Room 101");
        appointments.add(appointment);
    }

    @Test
    public void testLogin() {
        application.login(student.getUsername(), student.getPassword());
        User loggedInUser = application.getCurrentUser();
        assertTrue(loggedInUser);
        assertEquals(student.getUsername(), loggedInUser.getUsername());
    }
    @Test
    public void testSignUp() {
        application.signUp("janedoe", "password", "student");
        assertTrue(users.stream().anyMatch(user -> user.getUsername().equals("janedoe")));
    }

    @Test
    public void testCourseListing() {
        assertFalse(courses.isEmpty());
    }

    @Test
    public void testAppointmentBooking() {
        Student janeDoe = new Student("Jane", "Doe", "jane@example.com", "janedoe", "securepassword");
        application.bookAppointment(janeDoe, "2023-10-02 10:00", "Room 102", advisor);
        assertFalse(appointments.isEmpty());
    }
    
    @Test
    public void testViewProfile() {
        String profile = application.viewStudentProfile(student);
        assertTrue( profile.contains(student.getFirstName()));
    }


}