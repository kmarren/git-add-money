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
        Course course3 = new Course();
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

        public void setUp() {
            course1 = new Course("Course1", "101", 3); // Assuming Course class constructor Course(String name, String courseID, int creditHours)
            course2 = new Course("Course2", "102", 4); // You'll need to adjust these constructors based on the actual Course class
    
            ArrayList<Course> courses = new ArrayList<>();
            courses.add(course1);
            major = new Major("Computer Science", courses, 120);
        }
    
        @Test
        public void testMajorCreation() {
            Assert.assertNotNull("Major ID should not be null", major.getMajorID());
            Assert.assertEquals("Title should be 'Computer Science'", "Computer Science", major.getTitle());
            Assert.assertEquals("Hours required should be 120", 120, major.getHoursRequired());
            Assert.assertTrue("Required courses should contain course1", major.getRequiredCourses().contains(course1));
        }
    
        @Test
        public void testSetAndGetTitle() {
            major.setTitle("Mathematics");
            Assert.assertEquals("Title should now be 'Mathematics'", "Mathematics", major.getTitle());
        }
    
        @Test
        public void testAddRequiredCourse() {
            major.addRequiredCourse(course2);
            Assert.assertTrue("Required courses should contain course2", major.getRequiredCourses().contains(course2));
            Assert.assertEquals("Required courses size should be 2", 2, major.getRequiredCourses().size());
        }
    
        @Test
        public void testGetRequiredCourseUUIDs() {
            major.addRequiredCourse(course2);
            ArrayList<String> uuids = major.getRequiredCourseUUID();
            Assert.assertEquals("There should be 2 UUIDs in the list", 2, uuids.size());
            // This test assumes the Course class has a properly working getCourseID method returning a UUID
        }
    }