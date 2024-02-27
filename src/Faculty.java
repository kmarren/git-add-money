package src;
import java.util.ArrayList;
/**
 * setting up faculty class
 * @author Kennedy Marren
 */
public class Faculty extends User
{
    private String officeHours;
    private ArrayList<Student> studentList;
    /**
     * Constructs a new faculty object with office hours and a list of students
     * @param officeHours The office hours of the faculty member.
     * @param studentList The student list of the faculty member.
     * @param firstName The first name of the faculty member
     * @param lastName The last name of the faculty member
     * @param email The email of the faculty member
     * @param username The username of the faculty member
     * @param password The password of the faculty member
     */
    public Faculty(String officeHours, ArrayList<Student> studentList, 
    String firstName, String lastName, String email, String username, String password)
    {
        super(firstName, lastName, email, username, password, 3);
        this.officeHours = officeHours;
        this.studentList = studentList;
    }

    // getters and setters

    /**
     * Gets the office hours of the faculty member
     * @return The faculty member's office hours
     */
    public String getOfficeHours() {
        return officeHours;
    }
    /**
     * Sets the faculty member's office hours.
     * 
     * @param officeHours The faculty's office hours.
     */
    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
    /**
     * Gets the faculty member's assigned list of students
     * @return The faculty's list of students
     */
    public ArrayList<Student> getStudentList() {
        return studentList;
    }
    /**
     * Sets the faculty members assigned list of students
     * @param studentList The faculty's list of students.
     */
    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
    /**
     * Allows faculty members to write a note about a specific course.
     * @param course The specific course that the faculty wishes to write a comment for.
     */
    public void writeCourseComment(Course course)
    {

    }
    /**
     * Allows a faculty member to view their list of students.
     * @param students the faculty members list of students.
     */
    public ArrayList<Student> viewStudents(ArrayList<Student> students)
    {
        return students;
    }

    /**
     * Allows the faculty member to view a student's profile.
     * @param student ths specific student whose profile will be viewed.
     * @return the students profile containing their information.
     */
    public String viewStudentProfile(Student student)
    {
        return " ";
    }

    /**
     * Adds a student to a faculty member's list of students.
     * @param student the student who will be added.
     */
    public void addStudent(Student student)
    {

    }

    
}
