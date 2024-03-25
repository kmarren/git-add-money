package testing;
import src.Student;
import src.Faculty;
import static org.junit.jupiter.api.Assertions.*;
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
    void addEmptyStudent()
    {
        faculty.addStudent(new Student("", ""));
        assertEquals("", faculty.getStudentList().get(0).getUsername());
    }

    @Test
    void addTwoStudents()
    {
        faculty.addStudent(new Student("pmm", "password"));
        faculty.addStudent(new Student("efg", "password"));
        assertEquals("efg", faculty.getStudentList().get(1).getUsername());
    }

    @Test
    void toStringNullTester()
    {
        assertEquals(null + " " + null, faculty.toString());
    }

    @Test
    void toStringTester()
    {
        faculty.setFirstName("Kennedy");
        faculty.setLastName("Marren");
        assertEquals("Kennedy Marren", faculty.toString());
    }

    

}
