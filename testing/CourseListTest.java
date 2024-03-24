package testing;

import org.junit.Test;

import src.Course;
import src.CourseList;
import src.Faculty;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;

public class CourseListTest {
    private CourseList courseList;
    private Course course1;

    @Before
    public void setUp() {
        courseList = CourseList.getInstance();
        course1 = courseList.getCourseByUUID(UUID.fromString("65541aa4-b637-4d42-84f0-a9dfae30bf9d"));
        courseList.loadAll();
    }

    @After
    public void tearDown() {
        courseList.clear();
        courseList = null;
        course1 = null;
    }

    @Test
    public void testGetInstance() {
        CourseList newInstance = CourseList.getInstance();
        assertSame(courseList, newInstance);
    }

    @Test
    public void testGetCourses() {
        ArrayList<Course> courses = courseList.getCourses();
        int size = courses.size();
        assertEquals(size, courses.size());
        assertTrue(courses.contains(course1));
    }

    @Test
    public void testGetCourseByUUID() {
        Course foundCourse = courseList.getCourseByUUID(UUID.fromString(course1.getCourseID()));
        assertEquals(course1, foundCourse);
    }

    @Test
    public void testGetCourseByUUIDWithNonExistingUUID() {
        Course foundCourse = courseList.getCourseByUUID(UUID.randomUUID());
        assertNull(foundCourse);
    }

    @Test
    public void testGetCourseByUUIDWithNullUUID() {
        Course foundCourse = courseList.getCourseByUUID(null);
        assertNull(foundCourse);
    }

    @Test
    public void testGetCourseByCourseNameBad() {
        Course foundCourse = courseList.getCourseByCourseName("Math");
        assertNotEquals(course1, foundCourse);
    }

    @Test
    public void testGetCourseByCourseNameWithNullName() {
        Course foundCourse = courseList.getCourseByCourseName(null);
        assertNull(foundCourse);
    }

    @Test 
    public void testGetCourseByCourseNameWithEmptyName() {
        Course foundCourse = courseList.getCourseByCourseName("");
        assertNull(foundCourse);
    }

    @Test
    public void testGetCourseByCourseNameGood() {
        Course foundCourse = courseList.getCourseByCourseName(course1.getCourseName());
        assertEquals(course1, foundCourse);
    }

    @Test
    public void testGetCourseWithDifferentCase() {
        Course foundCourse = courseList.getCourseByCourseName(course1.getCourseName().toUpperCase());
        assertEquals(course1, foundCourse);
    }

    @Test
    public void testGetCourseWithPartialNameMatching() {
        Course foundCourse = courseList.getCourseByCourseName("CSCE");
        assertNull(foundCourse);
    }


    @Test
    public void testAddCourse() {
        ArrayList<String> courseComments = new ArrayList<>();
        courseComments.add("Great course!");
        int courseNumber = 101;
        String courseCode = "CS101";
        String courseName = "Introduction to Computer Science";
        Faculty instructor = new Faculty("John Doe", "CS Department");
        ArrayList<Course> prerequisites = new ArrayList<>();
        String description = "An introductory course to computer science concepts.";
        int totalSeats = 50;
        int creditWorth = 3;
        ArrayList<Course> corequisites = new ArrayList<>();
        boolean applicationArea = true;
        boolean carolinaCore = false;
        boolean elective = true;
        Course newCourse = new Course(courseComments, courseNumber, courseCode, courseName, instructor, prerequisites, description, totalSeats, creditWorth, corequisites, applicationArea, carolinaCore, elective);
        courseList.addCourse(newCourse);
        assertTrue(courseList.getCourses().contains(newCourse));
    }

    @Test
    public void testGetCourseWithMultipleMatches() {
        Course course2 = course1;
        courseList.addCourse(course1);
        courseList.addCourse(course2); 
        ArrayList<Course> foundCourses = courseList.getCourse(course1.getCourseName());
        assertTrue(foundCourses.contains(course1));
        assertTrue(foundCourses.contains(course2));
    }

    // bug, should not be allowed to add null courses
    @Test
    public void testAddNull() {
        int size = courseList.getCourses().size();
        courseList.addCourse(null);
        assertEquals(size, courseList.getCourses().size());
    }

    @Test
    public void testRemoveCourse() {
        courseList.removeCourse(course1);
        assertFalse(courseList.getCourses().contains(course1));
        assertNull(courseList.getCourseByUUID(UUID.fromString(course1.getCourseID())));
    }

    @Test
    public void testRemoveNull() {
        int size = courseList.getCourses().size();
        courseList.removeCourse(null);
        assertEquals(size, courseList.getCourses().size());
    }

    @Test
    public void testRemoveCourseWithNonExistingCourse() {
        Course course3 = new Course(null, 0, null, null, null, null, null, 0, 0, null, false, false, false);
        int size = courseList.getCourses().size();
        courseList.removeCourse(course3);
        assertEquals(size, courseList.getCourses().size());
    }

    @Test
    public void testClear() {
        courseList.clear();
        assertEquals(0, courseList.getCourses().size());
    }
}
