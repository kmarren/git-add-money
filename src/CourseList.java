package src;

import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> courses;

    private CourseList() {
        courses = new ArrayList<>();
    }

    public static CourseList getInstance() {
        if (courseList == null) {
            courseList = new CourseList();
        }
        return courseList;
    }

    public ArrayList<Course> getCourse(String courseName) {
        ArrayList<Course> foundCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getCourseName().equals(courseName)) {
                foundCourses.add(course);
            }
        }
        return foundCourses;
    }

    public Course getCourseByUUID(UUID courseID) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }

    public void addCourse(Course course)
    {
        courses.add(course);
    }


}
