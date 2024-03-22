package testing;
import java.util.ArrayList;
import src.DataWriter;
import src.User;
import src.UserList;
import src.MajorList;
import src.CourseList;
import src.DataLoader;
import src.Student;
import src.Advisor;
import src.Course;
import src.Faculty;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FacultyTest 
{

    Faculty faculty = new Faculty("kcm", "password");

    @Test
    void addNormalStudent()
    {
        faculty.addStudent(new Student("kre", "password"));
        assertEquals("kre", faculty.getStudentList().get(0).getUsername());
    }

    @Test
    void addTwoStudents()
    {
        faculty.addStudent(new Student("pmm", "password"));
        faculty.addStudent(new Student("efg", "password"));
        assertEquals("efg", faculty.getStudentList().get(1).getUsername());
    }

}
