package src;
import java.util.ArrayList;
import java.util.UUID;
/**
 * setting up course class
 * @author Kennedy Marren
 */
public class Course 
{

    private UUID courseID;
    protected ArrayList<String> courseComments;
    private int courseNumber;
    private String courseCode;
    private String courseName;
    private Faculty instructor;
    private ArrayList<Course> prerequisites;
    private String description;
    private int totalSeats;
    private int creditWorth;
    private ArrayList<Course> corequisites;
    private boolean applicationArea;
    private boolean carolinaCore;
    private boolean elective;
    private double grade;
    private boolean completed;
    private boolean enrolled;

    public Course(ArrayList<String> courseComments, int courseNumber, String courseCode, 
    String courseName, Faculty instructor, ArrayList<Course> prerequisites, String description, int totalSeats, 
    int creditWorth, ArrayList<Course> corequisites, boolean applicationArea, boolean carolinaCore, 
    boolean elective, double grade, boolean completed, boolean enrolled)
    {
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
        this.completed = completed;
        this.enrolled = enrolled;
    }

    public Course(ArrayList<String> courseComments, int courseNumber, String courseCode, 
    String courseName, Faculty instructor, ArrayList<Course> prerequisites, String description, int totalSeats, 
    int creditWorth, ArrayList<Course> corequisites, boolean applicationArea, boolean carolinaCore, 
    boolean elective)
    {

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

    public UUID getCourseID() {
        return courseID;
    }

    public void setCourseID(UUID courseID) {
        this.courseID = courseID;
    }

    public ArrayList<String> getCourseComments() {
        return courseComments;
    }

    public void setCourseComments(ArrayList<String> courseComments) {
        this.courseComments = courseComments;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Faculty getInstructor() {
        return instructor;
    }

    public void setInstructor(Faculty instructor) {
        this.instructor = instructor;
    }

    public ArrayList<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(ArrayList<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getCreditWorth() {
        return creditWorth;
    }

    public void setCreditWorth(int creditWorth) {
        this.creditWorth = creditWorth;
    }

    public ArrayList<Course> getCorequisites() {
        return corequisites;
    }

    public void setCorequisites(ArrayList<Course> corequisites) {
        this.corequisites = corequisites;
    }

    public boolean isApplicationArea() {
        return applicationArea;
    }

    public void setApplicationArea(boolean applicationArea) {
        this.applicationArea = applicationArea;
    }

    public boolean isCarolinaCore() {
        return carolinaCore;
    }

    public void setCarolinaCore(boolean carolinaCore) {
        this.carolinaCore = carolinaCore;
    }

    public boolean isElective() {
        return elective;
    }

    public void setElective(boolean elective) {
        this.elective = elective;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }

    public void addPrerequisites(Course prerequisite)
    {

    }

    public void addCorequisites(Course corequisite)
    {

    }














}
