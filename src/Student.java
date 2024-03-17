package src;

import java.util.ArrayList;
import java.util.Random;

/**
 * class to epresent a student, extends attributes from the User class
 * 
 * @author Jacob Robertson
 */
public class Student extends User {
    private Major major;
    private double gpa;
    private boolean minor;
    protected ArrayList<String> studentComments;
    private ArrayList<Achievement> achievements;
    private Advisor advisor;
    private boolean riskFailing;
    private int hoursCompleted;
    private ArrayList<Course> enrolledCourses = new ArrayList<Course>();
    private ArrayList<Course> completedCourses = new ArrayList<Course>();
    private ArrayList<Course> futureCourses = new ArrayList<Course>();
    private ArrayList<String> enrolledCourseUUIDS = new ArrayList<String>();
    private ArrayList<String> completedCourseUUIDS = new ArrayList<String>();

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
     * @param firstName       The first name of the student.
     * @param lastName        The last name of the student.
     * @param email           The email address of the student.
     * @param username        The username of the student.
     * @param password        The password of the student.
     * @param major           The major/class tracker of the student.
     */
    public Student(double gpa, boolean minor, ArrayList<String> studentComments,
            ArrayList<Achievement> achievements, Advisor advisor, boolean riskFailing,
            String firstName, String lastName, String email, String username, String password,
            Major major, ArrayList<Course> enrolledCourses, ArrayList<Course> completedCourses) {
        super(firstName, lastName, email, username, password, 1);
        this.gpa = gpa;
        this.minor = minor;
        this.studentComments = studentComments;
        this.achievements = achievements;
        this.advisor = advisor;
        this.riskFailing = riskFailing;
        this.major = major;
        this.enrolledCourses = enrolledCourses;
        this.completedCourses = completedCourses;
    }

    /**
     * Constructs a new Student object with the provided first name, last name,
     * email,
     * username, and password. The type of the user is set to 1, indicating a
     * student.
     *
     * @param firstName The first name of the student.
     * @param lastName  The last name of the student.
     * @param email     The email address of the student.
     * @param username  The username of the student.
     * @param password  The password of the student.
     */
    public Student(String firstName, String lastName, String email, String username, String password) {
        super(firstName, lastName, email, username, password, 1);
    }

    /**
     * Constructs a new Student with a username and password
     * 
     * @param username the students username
     * @param password the students password
     */
    public Student(String username, String password) {
        super(username, password, 1);
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
    public ArrayList<Achievement> getAchievements() {
        return achievements;
    }

    /**
     * Returns the advisor assigned to the student.
     *
     * @return The advisor assigned to the student.
     */
    public Advisor getAdvisor() {
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
     * Retrieves the total hours completed for the student.
     * 
     * @return The total hours completed for the student.
     */
    public int getHoursCompleted() {
        for (Course course : completedCourses) {
            int curr = course.getCreditWorth();
            hoursCompleted += curr;
        }
        return hoursCompleted;
    }

    public void resetHoursCompleted() {
        hoursCompleted = 0;
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
     * Sets the achievements earned by the student.
     *
     * @param achievements The achievements earned by the student.
     */
    public void setAchievement(ArrayList<Achievement> achievements) {
        this.achievements = achievements;
    }

    /**
     * Sets the advisor assigned to the student.
     *
     * @param advisor The advisor assigned to the student.
     */
    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public void setMajor(String uuid) {
        major = MajorList.getInstance().getMajorID(uuid);
    }

    public Major getMajor() {
        return major;
    }

    /**
     * Sets whether the student is at risk of failing.
     *
     * @param riskFailing Whether the student is at risk of failing.
     */
    public void setRiskFailing(boolean riskFailing) {
        this.riskFailing = riskFailing;
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
    public String viewProfile() {
        return "Name: " + getFirstName() + " " + getLastName() + "\n" +
                "Major: " + getMajor() + "\n" +
                "Classification: " + getGradeLevel() + "\n" +
                "GPA: " + gpa + "\n" +
                "Degree Progression: " + calculateProgressionAsPercentage();

    }

    public String viewCompletedCourseInfo() {
        ArrayList<Course> completedCourses = this.getCompletedCourses();
        StringBuilder completedInfo = new StringBuilder();

        for (Course course : completedCourses) {
            String courseName = course.getCourseName();
            double grade = course.getGrade();

            String result;
            if (grade < 70.0) { // Assuming 70 or below is failing
                result = "Failed";
            } else {
                result = "Did not fail";
            }

            String courseInfo = "Course Name: " + courseName + "\n" +
                    "Grade: " + grade + "\n" +
                    "Result: " + result + "\n\n";
            completedInfo.append(courseInfo);
        }

        return completedInfo.toString();
    }

    /**
     * Adds the given course to the list of enrolled courses for the student.
     *
     * @param enrolledCourse The course to be added.
     */
    public void addEnrolledCourse(Course enrolledCourse) {
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
    public void whatIfScenario(int projectedGraduationYear, int additionalHoursNeeded, Major newMajor) {
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

    public void addStudentComment(String comment) {
        studentComments.add(comment);
    }

    public void addAchievement(Achievement achievement) {
        achievements.add(achievement);
    }

    public ArrayList<String> getAchievementIDs() {
        ArrayList<String> achievementIDS = new ArrayList<String>();
        for (Achievement achievement : achievements) {
            String add = achievement.getAchievementID().toString();
            achievementIDS.add(add);
        }
        return achievementIDS;
    }

    public String toString() {
        return this.username;
    }

    public ArrayList<String> getEnrolledCourseUUID() {
        for (Course course : enrolledCourses) {
            String courseID = course.getCourseID().toString();
            enrolledCourseUUIDS.add(courseID);
        }

        return enrolledCourseUUIDS;
    }

    public ArrayList<String> getCompletedCourseUUID() {
        for (Course course : completedCourses) {
            String courseID = course.getCourseID().toString();
            completedCourseUUIDS.add(courseID);
        }

        return completedCourseUUIDS;
    }

    public ArrayList<Course> getCompletedCourses() {
        return completedCourses;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(ArrayList<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public void setCompletedCourses(ArrayList<Course> completedCourses) {
        this.completedCourses = completedCourses;
    }

    public void addCompletedCourse(Course course) {
        completedCourses.add(course);
    }

    /**
     * Calculates the progression of the major based on completed and required
     * hours.
     */
    public String calculateProgressionAsFraction() {
        resetHoursCompleted();
        return String.valueOf(getHoursCompleted()) + "/" + String.valueOf(getMajor().getHoursRequired());
    }

    public String calculateProgressionAsCreditsNeeded() {
        resetHoursCompleted();
        return String.valueOf(getMajor().getHoursRequired() - getHoursCompleted());
    }

    public String calculateProgressionAsPercentage() {
        resetHoursCompleted();
        double percent = (getHoursCompleted() * 100) / getMajor().getHoursRequired();
        return String.valueOf(percent) + "%";
    }

    public String getGradeLevel() {
        if (getHoursCompleted() < 30) {
            return "Freshman";
        } else if (getHoursCompleted() > 30 && getHoursCompleted() < 60) {
            return "Sophomore";
        } else if (getHoursCompleted() > 60 && getHoursCompleted() < 90) {
            return "Junion";
        } else {
            return "Senior";
        }
    }

    public ArrayList<Course> getFutureCourses()
    {
        for(Course course : getMajor().getRequiredCourses())
        {
            if(isTaking(course) || hasTaken(course))
            {
                continue;
            }
            else
            {
                futureCourses.add(course);
            }
        }
        return futureCourses;
    }

    public boolean isTaking(Course aCourse)
    {
        for(Course course : enrolledCourses)
        {
            if(course.getCourseID() == aCourse.getCourseID())
                return true;
        }
        return false;
    }

    public boolean hasTaken(Course aCourse)
    {
        for(Course course : completedCourses)
        {
            if(course.getCourseID() == aCourse.getCourseID())
                return true;
        }
        return false;
    }


}