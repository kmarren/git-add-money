package src;
import java.util.ArrayList;
/**
 * setting up faculty class
 * @author Kennedy Marren
 */
public class Faculty 
{
    private String officeHours;
    private ArrayList<Student> studentList;
    public Faculty(String officeHours, ArrayList<Student> studentList)
    {
        this.officeHours = officeHours;
        this.studentList = studentList;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void writeCourseComment(Course course)
    {

    }

    public ArrayList<Student> viewStudents(ArrayList<Student> students)
    {
        return students;
    }

    public String viewStudentProfile(Student student)
    {
        return " ";
    }

    public void addStudent(Student student)
    {

    }

    
}
