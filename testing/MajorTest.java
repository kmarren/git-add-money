package testing;

import org.junit.Before;
import org.junit.Test;

import src.Course;
import src.Major;
import src.Course;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class MajorTest {
    private Major major;
    private Course programming101;
    private Course programming102;
    private Course electiveCourse;

    @Before
    public void setUp() {
        programming101 = new Course(new ArrayList<>(), 101, "CS101", "Intro to Programming", null, new ArrayList<>(), "Programming basics", 30, 3, new ArrayList<>(), false, false, false, 0.0, false, false);
        programming102 = new Course(new ArrayList<>(), 102, "CS102", "Advanced Programming", null, new ArrayList<>() {{
            add(programming101);
        }}, "Advanced topics in programming", 30, 3, new ArrayList<>(), false, false, false, 0.0, false, false);

        electiveCourse = new Course(new ArrayList<>(), 103, "EL101", "Elective Course", null, new ArrayList<>(), "Some Elective", 30, 3, new ArrayList<>(), true, false, true, 0.0, false, false);

        ArrayList<Course> requiredCourses = new ArrayList<>();
        requiredCourses.add(programming101);
        requiredCourses.add(programming102);

        major = new Major("Computer Science", requiredCourses, 120);
    }

    @Test
    public void testAddingCourseWithPrerequisites() {
        assertTrue("Major should contain the prerequisite course", major.getRequiredCourses().contains(programming101));
        assertTrue("Major should contain the advanced course with prerequisites", major.getRequiredCourses().contains(programming102));
    }

    @Test
    public void testCoursePrerequisitesWithinMajor() {
        Course advancedCourse = major.getRequiredCourses().get(1); // Assuming this is programming102
        assertFalse("Advanced course prerequisites should not be empty", advancedCourse.getPrerequisites().isEmpty());
        assertEquals("Prerequisite for the advanced course should be Intro to Programming", "Intro to Programming", advancedCourse.getPrerequisites().get(0).getCourseName());
    }

    @Test
    public void testElectiveCourseImpact() {
        int initialRequiredHours = major.getHoursRequired();
        major.addRequiredCourse(electiveCourse);

        assertTrue("Elective course should be marked as elective", electiveCourse.isElective());
        assertEquals("Adding an elective course should not change required hours", initialRequiredHours, major.getHoursRequired());
    }

    @Test
    public void testCourseEnrollmentAndCompletion() {
        programming101.setEnrolled(true);
        programming101.setCompleted(true);

        assertTrue("Programming 101 should be marked as enrolled", programming101.isEnrolled());
        assertTrue("Programming 101 should be marked as completed", programming101.isCompleted());
    }

    @Test
    public void testApplicationAreaAndCarolinaCoreCourses() {
        Course applicationAreaCourse = new Course(new ArrayList<>(), 104, "AA101", "Application Area Course", null, new ArrayList<>(), "Application area description", 30, 3, new ArrayList<>(), true, false, false, 0.0, false, false);
        Course carolinaCoreCourse = new Course(new ArrayList<>(), 105, "CC101", "Carolina Core Course", null, new ArrayList<>(), "Carolina core description", 30, 3, new ArrayList<>(), false, true, false, 0.0, false, false);

        major.addRequiredCourse(applicationAreaCourse);
        major.addRequiredCourse(carolinaCoreCourse);

        assertTrue("Application area course should be correctly identified", applicationAreaCourse.isApplicationArea());
        assertTrue("Carolina core course should be correctly identified", carolinaCoreCourse.isCarolinaCore());
    }
    @Test
    public void testDuplicateCourseAddition() {
    int initialSize = major.getRequiredCourses().size();
    major.addRequiredCourse(programming101); // Attempt to add a duplicate
    assertEquals("Major required courses list size should not change after adding a duplicate course", initialSize, major.getRequiredCourses().size());
}

}
