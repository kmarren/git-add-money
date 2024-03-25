package testing;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import src.Student;
import src.Course;
import src.Major;
import src.Advisor;
import src.Achievement;
import java.util.ArrayList;

public class StudentTest {

    private Student student;
    private Course course1;
    private Course course2;
    private Major major;
    private Advisor advisor;
    
    @Before
    public void setup() {
       
        major = new Major("Computer Science");
        course1 = new Course(null, 0, "Introduction to Computer Science", "CS101", null, null, null, 3, 0, null, false, false, false, 4.0, false, false);
        course2 = new Course(null, 0, "Data Structures", "CS102", null, null, null, 3, 0, null, false, false, false, 3.6, false, false);
        advisor = new Advisor("Jane Doe", "advisor@example.com", "advisorUsername", "password", 2);
        student = new Student(3.5, false, new ArrayList<>(), new ArrayList<>(), advisor, false,
                "John", "Doe", "john.doe@example.com", "johndoe", "password123", major,
                new ArrayList<>(), new ArrayList<>());
    }

    @Test
    public void testAddEnrolledCourse() {
        student.addEnrolledCourse(course1);
        assertEquals(1, student.getEnrolledCourses().size());
        assertTrue(student.getEnrolledCourses().contains(course1));
    }

    @Test
    public void testAddCompletedCourse() {
        student.addCompletedCourse(course1);
        assertEquals(1, student.getCompletedCourses().size());
        assertTrue(student.getCompletedCourses().contains(course1));
    }

    @Test
    public void testCalculateGPA() {
        student.addCompletedCourse(course1); // 4.0 GPA
        student.addCompletedCourse(course2); // 3.6 GPA
        student.calculateGPA();
        assertEquals(3.8, student.getGpa(), 0.1);
    }

    @Test
    public void testAdvisorAssignment() {
        assertEquals(advisor, student.getAdvisor());
    }

    @Test
    public void testRiskFailing() {
        student.setRiskFailing(true);
        assertTrue(student.isRiskFailing());
    }

    @Test
    public void testGetGradeLevel() {
        student.setHoursCompleted(30); // Freshman threshold
        assertEquals("Sophomore", student.getGradeLevel());
    }



}
