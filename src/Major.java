package src;

import java.util.ArrayList;
import java.util.UUID;

/*
 * !!!!!!!!!!!!!!!!!!!!!!MOVE ENROLLED COURSES HERE!!!!!!!!!!!!!!!!!!!!!!!
 */
/**
 * This class holds all of the degree progession for each student
 * 
 * @author Jacob Robertson
 */
public class Major {
    private UUID majorID;
    private String title;
    private ArrayList<Course> requiredCourses = new ArrayList<Course>();;
    private int hoursRequired;
    private ArrayList<String> requiredCourseUUIDS = new ArrayList<String>();
    
    public Major() {
        this.majorID = UUID.randomUUID();
    }

    /**
     * Constructs a Major object with the specified parameters.
     * 
     * @param title            The title of the major.
     * @param courses          The list of required courses.
     * @param completedCourses The list of completed courses.
     * @param hoursRequired    The total hours required for the major.
     * @param hoursCompleted   The total hours completed for the major.
     * @param progression      The progression percentage of the major completion.
     */
    public Major(String title, ArrayList<Course> courses, int hoursRequired) {
        this();
        this.title = title;
        this.requiredCourses = courses;
        this.hoursRequired = hoursRequired;
    }

    // Getters and setters

    /**
     * Gets the UUID of the major.
     * 
     * @return The UUID of the major.
     */
    public String getMajorID() {
        return majorID.toString();
    }

    /**
     * Sets the UUID of the major.
     * 
     * @param majorID The UUID to set.
     */
    public void setMajorID(UUID majorID) {
        this.majorID = majorID;
    }

    /**
     * Gets the title of the major.
     * 
     * @return The title of the major.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the major.
     * 
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the list of required courses for the major.
     * 
     * @return The list of required courses.
     */
    public ArrayList<Course> getRequiredCourses() {
        return requiredCourses;
    }

    public ArrayList<String> getRequiredCourseUUID()
    {
        for (Course course : requiredCourses)
        {
            String courseID = course.getCourseID().toString();
            requiredCourseUUIDS.add(courseID);
        }

        return requiredCourseUUIDS;
    }
    /**
     * Sets the list of required courses for the major.
     * 
     * @param requiredCourses The list of required courses to set.
     */
    public void setRequiredCourses(ArrayList<Course> requiredCourses) {
        this.requiredCourses = requiredCourses;
    }
    /**
     * Retrieves the total hours required for the major.
     * 
     * @return The total hours required for the major.
     */
    public int getHoursRequired() {
        return hoursRequired;
    }

    /**
     * Sets the total hours required for the major.
     * 
     * @param hoursRequired The total hours required to set.
     */
    public void setHoursRequired(int hoursRequired) {
        this.hoursRequired = hoursRequired;
    }

    /**
     * Adds a required course to the major.
     * 
     * @param course The course to add.
     */
    public void addRequiredCourse(Course course) {
        // Add the course to the required courses list
        requiredCourses.add(course);
    }

    public String toString() {
        return title;
    }
}
