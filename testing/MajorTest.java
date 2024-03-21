package testing;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.UUID;


public class MajorTest {
    private Major major;
    private Course course1;
    private Course course2;

    @Before
    public void setUp() {
        course1 = new Course();
        course2 = new Course();
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        major = new Major("Computer Science", courses, 120);
    }

    @Test
    public void testMajorCreation() {
        assertNotNull("Major ID should not be null", major.getMajorID());
        assertEquals("Title should match", "Computer Science", major.getTitle());
        assertEquals("Hours required should match", 120, major.getHoursRequired());
        assertTrue("Required courses should contain course1", major.getRequiredCourses().contains(course1));
        assertTrue("Required courses should contain course2", major.getRequiredCourses().contains(course2));
    }

    @Test
    public void testAddRequiredCourse() {
        Course course3 = new Course(/* parameters */);
        major.addRequiredCourse(course3);
        assertTrue("Required courses should contain course3", major.getRequiredCourses().contains(course3));
    }

    @Test
    public void testGetRequiredCourseUUIDs() {
        ArrayList<String> uuids = major.getRequiredCourseUUID();
        assertNotNull("UUID list should not be null", uuids);
        assertEquals("UUID list size should match", 2, uuids.size());
        // Further checks can be added to verify the actual UUID values
    }
