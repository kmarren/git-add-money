import java.util.ArrayList;
import java.util.UUID;

/**
 * This class holds all of the degree progession for each student
 * @author Jacob Robertson
 */
public class Major {
    private UUID majorID;
    private String title;
    private ArrayList<Course> requiredCourses;
    private ArrayList<Course> completedCourses;
    private int hoursRequired;
    private int hoursCompleted;
    private double progression;

    public Major(String title, ArrayList<Course> courses, ArrayList<Course> completedCourses, int hoursRequired, int hoursCompleted, int progression) {
        private UUID majorID;
    private String title;
    private ArrayList<Course> requiredCourses;
    private ArrayList<Course> completedCourses;
    private int hoursRequired;
    private int hoursCompleted;
    private double progression;

    public Major(String title, ArrayList<Course> courses, ArrayList<Course> completedCourses, int hoursRequired, int hoursCompleted, double progression) {
        this.majorID = UUID.randomUUID();
        this.title = title;
        this.requiredCourses = courses;
        this.completedCourses = completedCourses;
        this.hoursRequired = hoursRequired;
        this.hoursCompleted = hoursCompleted;
        this.progression = progression;
    }

    public UUID getMajorID() {
        return majorID;
    }

    public void setMajorID(UUID majorID) {
        this.majorID = majorID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Course> getRequiredCourses() {
        return requiredCourses;
    }

    public void setRequiredCourses(ArrayList<Course> requiredCourses) {
        this.requiredCourses = requiredCourses;
    }

    public ArrayList<Course> getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(ArrayList<Course> completedCourses) {
        this.completedCourses = completedCourses;
    }

    public int getHoursRequired() {
        return hoursRequired;
    }

    public void setHoursRequired(int hoursRequired) {
        this.hoursRequired = hoursRequired;
    }

    public int getHoursCompleted() {
        return hoursCompleted;
    }

    public void setHoursCompleted(int hoursCompleted) {
        this.hoursCompleted = hoursCompleted;
    }

    public double getProgression() {
        return progression;
    }

    public void setProgression(double progression) {
        this.progression = progression;
    }

    public void addRequiredCourse(Course course) {
        // Add the course to the required courses list
    }

    public void addCompletedCourse(Course course) {
        // Add the course to the completed courses list
    }

    public void calculateProgression() {
        // Calculate the progression based on completed and required hours
    }
}
