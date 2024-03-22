package src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/**
 * setting up course class
 * 
 * @author Kennedy Marren
 */
public class Course {

    private UUID courseID;
    protected ArrayList<String> courseComments;
    private int courseNumber;
    private String courseCode;
    private String courseName;
    private Faculty instructor;
    private ArrayList<Course> prerequisites = new ArrayList<Course>();
    private ArrayList<Course> corequisites = new ArrayList<Course>();;
    private String description;
    private int totalSeats;
    private int creditWorth;
    private boolean applicationArea;
    private boolean carolinaCore;
    private boolean elective;
    private boolean enrolled;
    private boolean completed;

    private double grade;


    /**
     * Constructor that creates a course object specific to the student.
     * 
     * @param courseComments  The comments for the course.
     * @param courseNumber    The number for the course.
     * @param courseCode      The code for the course.
     * @param courseName      The name of the course.
     * @param instructor      The instructor for the course.
     * @param prerequisites   The prerequisites for the course.
     * @param description     The course description.
     * @param totalSeats      The maximum amount of student allowed to take the
     *                        course.
     * @param creditWorth     The number of credits the course is worth.
     * @param corequisites    The corequisites for the course.
     * @param applicationArea Whether or not the course applies for an application
     *                        area.
     * @param carolinaCore    Whether or not the course counts for a carolina core
     *                        requirement.
     * @param elective        Whether or not the course counts for elective credit.
     * @param grade           The grade a student has earned in the course.
     * @param completed       Whether or not the student has completed the course.
     */
    public Course(ArrayList<String> courseComments, int courseNumber, String courseCode,
            String courseName, Faculty instructor, ArrayList<Course> prerequisites, String description, int totalSeats,
            int creditWorth, ArrayList<Course> corequisites, boolean applicationArea, boolean carolinaCore,
            boolean elective, double grade, boolean enrolled, boolean completed) {
        this.courseID = UUID.randomUUID();
        this.courseComments = courseComments;
        this.courseNumber = courseNumber;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
        this.prerequisites = prerequisites;
        this.description = description;
        this.totalSeats = totalSeats;
        this.creditWorth = creditWorth;
        this.corequisites = corequisites;
        this.applicationArea = applicationArea;
        this.carolinaCore = carolinaCore;
        this.elective = elective;
        this.grade = grade;
        this.enrolled = enrolled;
        this.completed = completed;
    }

    /**
     * Generalized course constructor.
     * 
     * @param courseComments  The comments for the course.
     * @param courseNumber    The number for the course.
     * @param courseCode      The code for the course.
     * @param courseName      The name of the course.
     * @param instructor      The instructor for the course.
     * @param prerequisites   The prerequisites for the course.
     * @param description     The course description.
     * @param totalSeats      The maximum amount of student allowed to take the
     *                        course.
     * @param creditWorth     The number of credits the course is worth.
     * @param corequisites    The corequisites for the course.
     * @param applicationArea Whether or not the course applies for an application
     *                        area.
     * @param carolinaCore    Whether or not the course counts for a carolina core
     *                        requirement.
     * @param elective        Whether or not the course counts for elective credit.
     */
    public Course(ArrayList<String> courseComments, int courseNumber, String courseCode,
            String courseName, Faculty instructor, ArrayList<Course> prerequisites, String description, int totalSeats,
            int creditWorth, ArrayList<Course> corequisites, boolean applicationArea, boolean carolinaCore,
            boolean elective) {

        this.courseID = UUID.randomUUID();
        this.courseComments = courseComments;
        this.courseNumber = courseNumber;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
        this.prerequisites = prerequisites;
        this.description = description;
        this.totalSeats = totalSeats;
        this.creditWorth = creditWorth;
        this.corequisites = corequisites;
        this.applicationArea = applicationArea;
        this.carolinaCore = carolinaCore;
        this.elective = elective;
    }
    // getters and setters

    /**
     * Gets the UUID of the course.
     * 
     * @return The UUID of the course.
     */
    public String getCourseID() {
        return courseID.toString();
    }

    public UUID getRealCourseID() {
        return this.courseID;
    }

    /**
     * Sets the UUID of the course.
     * 
     * @param courseID The UUID to set.
     */
    public void setCourseID(UUID courseID) {
        this.courseID = courseID;
    }

    /**
     * Gets the course comments.
     * 
     * @return The list of comments for the course.
     */
    public ArrayList<String> getCourseComments() {
        return courseComments;
    }

    /**
     * Sets the comments of the course.
     * 
     * @param courseComments The comments to set for the course.
     */
    public void setCourseComments(ArrayList<String> courseComments) {
        this.courseComments = courseComments;
    }

    /**
     * Gets the course number.
     * 
     * @return The number of the course.
     */
    public int getCourseNumber() {
        return courseNumber;
    }

    /**
     * Sets the number for the course
     * 
     * @param courseNumber The number to be set for the course.
     */
    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    /**
     * Gets the course code.
     * 
     * @return The code of the course.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Sets the code for the course
     * 
     * @param courseCode The code to be set for the course.
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Gets the course name.
     * 
     * @return The name of the course.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the name of the course.
     * 
     * @param courseName The name to set for the course.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the course instructor(s).
     * 
     * @return The instructor(s) of the course.
     */
    public Faculty getInstructor() {
        return instructor;
    }

    /**
     * Sets the instrructor of the course.
     * 
     * @param instructor The instructor for the course.
     */
    public void setInstructor(Faculty instructor) {
        this.instructor = instructor;
    }

    /**
     * Gets the list of prerequisites for the course.
     * 
     * @return The course prerequisites.
     */
    public ArrayList<Course> getPrerequisites() {
        return prerequisites;
    }

    /**
     * Sets the prerequisites for the course.
     * 
     * @param prerequisites the list of prerequisites for the course.
     */
    public void setPrerequisites(ArrayList<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    /**
     * Gets the course description.
     * 
     * @return The description of the course.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the course.
     * 
     * @param description The description to set for the course.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the maximum amount of student that can take the course.
     * 
     * @return The max student number for the course.
     */
    public int getTotalSeats() {
        return totalSeats;
    }

    /**
     * Sets the total seats for the course.
     * 
     * @param totalSeats The max student number for the course.
     */
    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    /**
     * Gets the amount of credits the course is worth.
     * 
     * @return The amount of credits that the course is worth.
     */
    public int getCreditWorth() {
        return creditWorth;
    }

    /**
     * Sets the amount of credits the course is worth.
     * 
     * @param creditWorth The amount of credit hours the course is worth.
     */
    public void setCreditWorth(int creditWorth) {
        this.creditWorth = creditWorth;
    }

    /**
     * Gets the list of corequisites for the course.
     * 
     * @return The course corequisites.
     */
    public ArrayList<Course> getCorequisites() {
        return corequisites;
    }

    /**
     * Sets the corequisites for the course.
     * 
     * @param prerequisites the list of corequisites for the course.
     */
    public void setCorequisites(ArrayList<Course> corequisites) {
        this.corequisites = corequisites;
    }

    /**
     * Gets the boolean value of whether the course is an application area class.
     * 
     * @return Whether or not the course is an application area class.
     */
    public boolean isApplicationArea() {
        return applicationArea;
    }

    /**
     * Sets whether or not the course is an application area course.
     * 
     * @param applicationArea Whether or not the course applies for an application
     *                        area.
     */
    public void setApplicationArea(boolean applicationArea) {
        this.applicationArea = applicationArea;
    }

    /**
     * Gets the boolean value of whether the course is a carolina core class.
     * 
     * @return Whether or not the course is a carolina core class.
     */
    public boolean isCarolinaCore() {
        return carolinaCore;
    }

    /**
     * Sets whether or not the course is a carolina core course.
     * 
     * @param applicationArea Whether or not the course applies for carolina core.
     */
    public void setCarolinaCore(boolean carolinaCore) {
        this.carolinaCore = carolinaCore;
    }

    /**
     * Gets the boolean value of whether the course is an elective.
     * 
     * @return Whether or not the course is an elective.
     */
    public boolean isElective() {
        return elective;
    }

    /**
     * Sets whether or not the course is an elective.
     * 
     * @param applicationArea Whether or not the course is an elective.
     */
    public void setElective(boolean elective) {
        this.elective = elective;
    }

    /**
     * Gets the grade the a student earned in the course.
     * 
     * @return The grade a student earned in the course.
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Sets the grade a student has earned in a course.
     * 
     * @param grade The grade a student has earned in the course.
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setEnrolled(boolean enrolled)
    {
        this.enrolled = enrolled;
    }

    public boolean isEnrolled()
    {
        return enrolled;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public boolean isCompleted()
    {
        return completed;
    }


    /**
     * adds a prerequisite to the course's list of prerequisites
     * 
     * @param prerequisite a course that must be taken before the course
     */
    public void addPrerequisites(Course prerequisite) {
        prerequisites.add(prerequisite);
    }

    /**
     * adds a corequisite to the course's list of prerequisites
     * 
     * @param prerequisite a course that must be taken at the same time as the
     *                     course
     */
    public void addCorequisites(Course corequisite) {
        corequisites.add(corequisite);
    }

    /**
     * concatinates the course information to display for user
     */
    public String toString() {
        return courseName;
    }

    public void writeCourseComment(String comment)
    {
        courseComments.add(comment);
    }

}
