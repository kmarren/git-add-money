package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import org.junit.Test;

import src.Achievement;
import src.Appointment;
import src.Course;
import src.DataLoader;
import src.Major;
import src.User;

public class DataLoaderTest {

    @Test
    public void testLoadStudents() {
        ArrayList<User> students = DataLoader.loadStudents();
        assertNotNull(students);
        assertFalse(students.isEmpty());
    }

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
        // Add assertions to check if faculty are properly finished
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
        // Add assertions to check if advisors are properly finished
    }

    @Test
    public void testFinishStudents() {
        ArrayList<User> students = new ArrayList<>();
        DataLoader.finishStudents(students);
        // Add assertions to check if students are properly finished
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
        // Add assertions to check if majors are properly finished
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
