package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * class to epresent a student, extends attributes from the User class
 * 
 * @author Jacob Robertson
 */
public class Student extends User {
    private String studentID;
    private double gpa;
    private boolean minor;
    protected ArrayList<String> studentComments;
    private ArrayList<UUID> achievements;
    private ArrayList<UUID> enrolledCourses;
    private UUID advisor;
    private boolean riskFailing;
    private double hoursCompleted;

    /**
     * Constructs a new Student object with the specified attributes.
     *
     * @param gpa             The GPA of the student.
     * @param minor           Whether the student has a minor.
     * @param studentComments Comments given to a student by an advisor.
     * @param enrolledCourses Courses in which the student is enrolled.
     * @param achievements    Achievements earned by the student (scholarships
     *                        etc.)
     * @param advisor         The advisor assigned to the student.
     * @param riskFailing     Whether the student is at risk of failing.
     * @param hoursCompleted  The number of completed hours by the student.
     * @param studentID       The ID of the student.
     * @param firstName       The first name of the student.
     * @param lastName        The last name of the student.
     * @param email           The email address of the student.
     * @param username        The username of the student.
     * @param password        The password of the student.
     * @param type            The type of user (e.g., 1=student, 2=faculty,
     *                        3=advisor).
     */
    public Student(double gpa, boolean minor, ArrayList<String> studentComments, ArrayList<UUID> enrolledCourses,
            ArrayList<UUID> achievements, UUID advisor, boolean riskFailing, double hoursCompleted,
            String studentID, String firstName, String lastName, String email, String username, String password,
            int type) {
        super(firstName, lastName, email, username, password, type);
        this.gpa = gpa;
        this.minor = minor;
        this.studentComments = studentComments;
        this.achievements = achievements;
        this.enrolledCourses = enrolledCourses;
        this.advisor = advisor;
        this.riskFailing = riskFailing;
        this.hoursCompleted = hoursCompleted;
        this.studentID = studentID;
    }

    // Getters
    /**
     * gets the GPA of a student
     * 
     * @return the GPA of the student
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * Returns whether the student has a minor.
     *
     * @return True if the student has a minor, otherwise false.
     */
    public boolean hasMinor() {
        return minor;
    }

    /**
     * Returns the comments given to the student.
     *
     * @return The comments give to the student.
     */
    public ArrayList<String> getStudentComments() {
        return studentComments;
    }

    /**
     * Returns the achievements earned by the student.
     *
     * @return The achievements earned by the student.
     */
    public ArrayList<UUID> getAchievements() {
        return achievements;
    }

    /**
     * Returns the courses in which the student is enrolled.
     *
     * @return The courses in which the student is enrolled.
     */
    public ArrayList<UUID> getEnrolledCourses() {
        return enrolledCourses;
    }

    /**
     * Returns the advisor assigned to the student.
     *
     * @return The advisor assigned to the student.
     */
    public UUID getAdvisor() {
        return advisor;
    }

    /**
     * Returns whether the student is at risk of failing.
     *
     * @return True if the student is at risk of failing, otherwise false.
     */
    public boolean isRiskFailing() {
        return riskFailing;
    }

    /**
     * Returns the number of completed hours by the student.
     *
     * @return The number of completed hours.
     */
    public double getHoursCompleted() {
        return hoursCompleted;
    }

    /**
     * Returns the ID of the student.
     *
     * @return The ID of the student.
     */
    public String getStudentID() {
        return studentID;
    }

    // Setters

    /**
     * Sets the grade point average of the student.
     *
     * @param gpa The grade point average to be set.
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * Sets whether or not the student has a minor.
     *
     * @param minor Whether the student has a minor.
     */
    public void setMinor(boolean minor) {
        this.minor = minor;
    }

    /**
     * Sets the comments given to the student. This will be called by the advisor
     * when adding their advising comments
     *
     * @param studentComments The comments given to the student.
     */
    public void setStudentComments(ArrayList<String> studentComments) {
        this.studentComments = studentComments;
    }

    /**
     * Sets the achievements earned by the student.
     *
     * @param achievements The achievements earned by the student.
     */
    public void setAchievement(ArrayList<UUID> achievements) {
        this.achievements = achievements;
    }

    /**
     * Sets the courses in which the student is enrolled.
     *
     * @param enrolledCourses The courses in which the student is enrolled.
     */
    public void setEnrolledCourse(ArrayList<UUID> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    /**
     * Sets the advisor assigned to the student.
     *
     * @param advisor The advisor assigned to the student.
     */
    public void setAdvisor(UUID advisor) {
        this.advisor = advisor;
    }

    /**
     * Sets whether the student is at risk of failing.
     *
     * @param riskFailing Whether the student is at risk of failing.
     */
    public void setRiskFailing(boolean riskFailing) {
        this.riskFailing = riskFailing;
    }

    /**
     * Sets the number of completed hours by the student.
     *
     * @param hoursCompleted The number of completed hours.
     */
    public void setHoursCompleted(double hoursCompleted) {
        this.hoursCompleted = hoursCompleted;
    }

    /**
     * Sets the ID of the student.
     *
     * @param studentID The ID of the student.
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /*
     * im not sure about these, I forget what they were supposed to do and I think
     * we got rid of them
     * public void sendAdvisorComment(Advisor advisor) {
     * // Implementation goes here
     * }
     * 
     * public void sendInstructorComment(Advisor advisor) {
     * // Implementation goes here
     * }
     */

    /**
     * Views the profile of the specified student.
     *
     * @param student The student whose profile is to be viewed.
     * @return A string representation of the student's profile.
     */
    // I dont think we need to pass in a student here, can just pass in nothing??
    public String viewStudentProfile() {
        // Implementation goes here
        return null; // Placeholder return statement
    }

    /**
     * Adds the given course to the list of enrolled courses for the student.
     *
     * @param enrolledCourse The course to be added.
     */
    public void addEnrolledCourse(UUID enrolledCourse) {
        // Implementation goes here
    }

    /**
     * Simulates a "what-if" scenario where the student changes their major and
     * calculates the impact on their graduation.
     *
     * @param projectedGraduationYear The projected graduation year after the
     *                                change.
     * @param additionalHoursNeeded   Additional hours needed to complete the new
     *                                major.
     * @param newMajor                The new major chosen by the student.
     */
    public void whatIfScenario(int projectedGraduationYear, int additionalHoursNeeded, UUID newMajor) {
        // Implementation goes here
    }

    /**
     * Makes an appointment with the advisor at the specified time and location.
     *
     * @param time     The time of the appointment.
     * @param location The location of the appointment.
     */
    public void makeAppointment(String time, String location) {
        // Implementation goes here
    }

    /**
     * Calculates the GPA for the student and updates it.
     * 
     * Implementation of this method should compute the GPA based on the completed
     * courses
     * and update the GPA of the student.
     */
    public void calculateGPA() {
        // Implementation goes here
        double gpa = 100000000;
        setGpa(gpa);
    }
}