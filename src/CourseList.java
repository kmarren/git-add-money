package src;

import java.util.ArrayList;

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

    public void addCourse(Course course)
    {
        courses.add(course);
    }


}
