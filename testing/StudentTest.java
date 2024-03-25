package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.UserList;
import src.Student; 
import src.User;
import src.Faculty;
import src.Advisor;
import src.Achievement;

public class StudentTest {

    @Test
    public void testConstructorWithParams() {
        ArrayList<String> comments = new ArrayList<>();
        comments.add("Excellent progress");
        ArrayList<Achievement> achievements = new ArrayList<>();
        // Assuming Achievement is a simple class with a name property for demonstration
        achievements.add(new Achievement("Honor Roll"));
        ArrayList<Course> enrolledCourses = new ArrayList<>();
        // Add mock Course objects as needed
        
        Advisor advisor = new Advisor("AdvisorName", "AdvisorEmail"); // Mocked for demonstration
        Student student = new Student(3.5, true, comments, achievements, advisor, false,
                "John", "Doe", "john.doe@example.com", "johndoe", "password123",
                new Major("Computer Science"), enrolledCourses, new ArrayList<>());
                
        assertEquals(3.5, student.getGpa());
        assertTrue(student.hasMinor());
        assertNotNull(student.getStudentComments());
        assertEquals("AdvisorName", student.getAdvisor().getName()); // Assuming Advisor has a getName method
        assertEquals("Computer Science", student.getMajor().getName()); // Assuming Major has a getName method
    }

    @Test
    public void testSetAndGetGpa() {
        Student student = new Student("johndoe", "password123");
        student.setGpa(3.9);
        assertEquals(3.9, student.getGpa());
    }

    @Test
    public void testAddAndGetEnrolledCourses() {
        Student student = new Student("johndoe", "password123");
        Course course = new Course("Intro to Programming", "CS101", 3); // Mocked for demonstration
        student.addEnrolledCourse(course);
        
        assertEquals(1, student.getEnrolledCourses().size());
        assertEquals("Intro to Programming", student.getEnrolledCourses().get(0).getCourseName());
    }

}
