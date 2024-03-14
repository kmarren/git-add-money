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
    private ArrayList<Course> enrolledCourses = new ArrayList<Course>();
    private ArrayList<Course> completedCourses = new ArrayList<Course>();;
    private int hoursRequired;
    private int hoursCompleted;
    private double progression;
    private ArrayList<String> requiredCourseUUIDS = new ArrayList<String>();
    private ArrayList<String> enrolledCourseUUIDS = new ArrayList<String>();
    private ArrayList<String> completedCourseUUIDS = new ArrayList<String>();
    
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
    public Major(String title, ArrayList<Course> courses, ArrayList<Course> completedCourses, int hoursRequired,
            int hoursCompleted, double progression, ArrayList<Course> enrolledCourses) {
        this();
        this.title = title;
        this.requiredCourses = courses;
        this.completedCourses = completedCourses;
        this.hoursRequired = hoursRequired;
        this.hoursCompleted = hoursCompleted;
        this.progression = progression;
        this.enrolledCourses = enrolledCourses;
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

    public ArrayList<String> getEnrolledCourseUUID()
    {
        for (Course course : enrolledCourses)
        {
            String courseID = course.getCourseID().toString();
            enrolledCourseUUIDS.add(courseID);
        }

        return enrolledCourseUUIDS;
    }

    public ArrayList<String> getCompletedCourseUUID()
    {
        for (Course course : completedCourses)
        {
            String courseID = course.getCourseID().toString();
            completedCourseUUIDS.add(courseID);
        }

        return completedCourseUUIDS;
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
     * Retrieves the list of completed courses for the major.
     * 
     * @return The list of completed courses.
     */
    public ArrayList<Course> getCompletedCourses() {
        return completedCourses;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    /**
     * Sets the list of completed courses for the major.
     * 
     * @param completedCourses The list of completed courses to set.
     */
    public void setCompletedCourses(ArrayList<Course> completedCourses) {
        this.completedCourses = completedCourses;
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
     * Retrieves the total hours completed for the major.
     * 
     * @return The total hours completed for the major.
     */
    public int getHoursCompleted() {
        return hoursCompleted;
    }

    /**
     * Sets the total hours completed for the major.
     * 
     * @param hoursCompleted The total hours completed to set.
     */
    public void setHoursCompleted(int hoursCompleted) {
        this.hoursCompleted = hoursCompleted;
    }

    /**
     * Retrieves the progression percentage of the major completion.
     * 
     * @return The progression percentage of the major.
     */
    public double getProgression() {
        return progression;
    }

    /**
     * Sets the progression percentage of the major completion.
     * 
     * @param progression The progression percentage to set.
     */
    public void setProgression(double progression) {
        this.progression = progression;
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

    /**
     * Adds a completed course to the major.
     * 
     * @param course The course to add.
     */
    public void addCompletedCourse(Course course) {
        // add the course to the completed courses list
        completedCourses.add(course);
    }

    public void addEnrolledCourse(Course course) {
        enrolledCourses.add(course);
    }

    /**
     * Calculates the progression of the major based on completed and required
     * hours.
     */
    public void calculateProgression() {
        // Calculate the progression based on completed and required hours
    }

    public String toString() {
        return title;
    }
}
