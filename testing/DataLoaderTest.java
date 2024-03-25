package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import org.junit.Test;

import src.Achievement;
import src.Advisor;
import src.Appointment;
import src.Course;
import src.DataLoader;
import src.Faculty;
import src.Major;
import src.Student;
import src.User;


// NOTE: this is not really a complete test, however I know the main bugs with the dataloader and feel it would be 
// better to test overall functionality rather than test the individual methods as they all have the same bugs/
// pretty much do the same thing. Most of the issues come from JSON formatting and null values within the JSON file.

// NOTE #2: for these test to work, must use the test json files inside data/dataTesting instead of the actual database.
public class DataLoaderTest {

    @Test
    public void testLoadStudents() {
        ArrayList<User> students = DataLoader.loadStudents();
        assertNotNull(students);
        assertFalse(students.isEmpty());
    }

    // problem with null values
    @Test
    public void testLoadCourses() {
        ArrayList<Course> courses = DataLoader.loadCourses();
        assertNotNull(courses);
        assertFalse(courses.isEmpty());
    }

    @Test
    public void testFinishCourses() {
        ArrayList<Course> courses = DataLoader.loadCourses();
        assertNotNull(courses);
        assertTrue(courses.isEmpty());

        DataLoader.finishCourses(courses);

        for (Course course : courses) {
            assertNotNull(course.getPrerequisites());
            assertNotNull(course.getCorequisites());
        }
    }

    @Test
    public void testLoadFaculty() {
        ArrayList<User> faculty = DataLoader.loadFaculty();
        assertNotNull(faculty);
        assertFalse(faculty.isEmpty());
    }

    @Test
    public void testFinishFaculty() {
        ArrayList<User> faculty = new ArrayList<>();

        DataLoader.finishFaculty(faculty);

        for (User fac : faculty) {
            assertTrue("Faculty should be an instance of Faculty class", fac instanceof Faculty);
            assertNotNull("Student list should not be null", ((Faculty) fac).getStudentList());
        }
    }

    @Test
    public void testLoadAdvisors() {
        ArrayList<User> advisors = DataLoader.loadAdvisors();
        assertNotNull(advisors);
        assertFalse(advisors.isEmpty());
    }

    @Test
    public void testFinishAdvisors() {
        ArrayList<User> advisors = new ArrayList<>();
        DataLoader.finishAdvisors(advisors);
        for (User advisor : advisors) {
            assertTrue("Advisor should be an instance of Advisor class", advisor instanceof Advisor);
            assertNotNull("Advisee list should not be null", ((Advisor) advisor).getAdviseeList());
            assertNotNull("Appointments should not be null", ((Advisor) advisor).getAppointments());
        }
    }

    @Test
    public void testFinishStudents() {
        ArrayList<User> students = new ArrayList<>();
        DataLoader.finishStudents(students);
        for (User student : students) {
            assertTrue("Student should be an instance of Student class", student instanceof Student);
            assertNotNull("Advisor should not be null", ((Student) student).getAdvisor());
            assertNotNull("Major should not be null", ((Student) student).getMajor());
        }
    }

    @Test
    public void testLoadMajors() {
        ArrayList<Major> majors = DataLoader.loadMajors();
        assertNotNull(majors);
        assertFalse(majors.isEmpty());
    }

    @Test
    public void testFinishMajors() {
        ArrayList<Major> majors = new ArrayList<>();
        DataLoader.finishMajors(majors);
        for (Major major : majors) {
            assertNotNull("Required courses should not be null", major.getRequiredCourses());
            assertFalse("Required courses list should not be empty", major.getRequiredCourses().isEmpty());
        }
    }

    @Test
    public void testLoadAchievements() {
        ArrayList<Achievement> achievements = DataLoader.loadAchievements();
        assertNotNull(achievements);
        assertFalse(achievements.isEmpty());
    }

    @Test
    public void testLoadAppointments() {
        ArrayList<Appointment> appointments = DataLoader.loadAppointments();
        assertNotNull(appointments);
        assertFalse(appointments.isEmpty());
    }
}
