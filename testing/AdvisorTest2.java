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
import src.Faculty;
import src.Course;
import src.Major;
import src.Appointment;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AdvisorTest 
{
    Advisor advisor = new Advisor("kcm", "password");
    Student student = new Student("Parker", "Martin", "pmartin@email.sc.edu", "pmm", "password");
    Major major = new Major("Computer Science");
    @BeforeEach
    void reset()
    {
        advisor.getAdviseeList().clear();
        advisor.getAppointments().clear();
        String id = major.getMajorID();
        student.setMajor(id);
    }

    @Test
    void testViewAdviseesNormal()
    {
        advisor.addAdvisee(student);
        assertEquals("List of Advisees:\n" + "Name: Parker Martin\n" + "Email: pmartin@email.sc.edu" + "\n", advisor.viewAdvisees());
    }

    @Test
    void testViewAdviseesThree()
    {
        advisor.addAdvisee(student);
        advisor.addAdvisee(new Student("Emma", "Grace", "egrace@email.sc.edu", "efg", "password"));
        advisor.addAdvisee(new Student("Kyla", "Wilson", "kwilson@email.sc.edu", "klw", "password"));
        assertEquals(
        "List of Advisees:\n" + 
        "Name: Parker Martin\n" + "Email: pmartin@email.sc.edu" + "\n"+ 
        "Name: Emma Grace\n" + "Email: egrace@email.sc.edu" + "\n"+ 
        "Name: Kyla Wilson\n" + "Email: kwilson@email.sc.edu" + "\n", advisor.viewAdvisees());
    }

    @Test
    void testViewAppointmentsNormal()
    {
        advisor.addAppointment(new Appointment("2:30 PM", "Swearingen A101"));
        assertEquals("List of Available Appointments:\n" + "Time: 2:30 PM\n" + "Location: Swearingen A101" + "\n", advisor.viewAppointments());
    }

    @Test
    void testViewAppointmentsThree()
    {
        advisor.addAppointment(new Appointment("2:30 PM", "Swearingen A101"));
        advisor.addAppointment(new Appointment("3:00 PM", "Swearingen A101"));
        advisor.addAppointment(new Appointment("3:30 PM", "Swearingen A101"));
        assertEquals(
        "List of Available Appointments:\n" + 
        "Time: 2:30 PM\n" + "Location: Swearingen A101" + "\n"+ 
        "Time: 3:00 PM\n" + "Location: Swearingen A101" + "\n"+ 
        "Time: 3:30 PM\n" + "Location: Swearingen A101" + "\n", advisor.viewAppointments());
    }

    @Test
    void testSearchForStudentNameNormal()
    {
        advisor.addAdvisee(student);
        assertEquals(advisor.searchByName("Parker"), advisor.getAdviseeList().get(0).viewProfile());
    }

    @Test
    void testSearchForStudentNameDifferentCase()
    {
        advisor.addAdvisee(student);
        assertEquals(advisor.searchByName("pArkER"), advisor.getAdviseeList().get(0).viewProfile());
    }

    @Test
    void testSearchForStudentNameNotInList()
    {
        advisor.addAdvisee(student);
        assertNotEquals(advisor.searchByName("Kennedy"), advisor.getAdviseeList().get(0).viewProfile());
    }@Test
    void testSearchForStudentIDNormal()
    {
        advisor.addAdvisee(student);
        String id = advisor.getAdviseeList().get(0).getUserStringID();
        assertEquals(advisor.searchByID(id), advisor.getAdviseeList().get(0).viewProfile());
    }

    @Test
    void testSearchForStudentIDNotInList()
    {
        advisor.addAdvisee(student);
        assertNotEquals(advisor.searchByID("9587cd29-4aa7-4d78-94fd-505b213b7fca"), advisor.getAdviseeList().get(0).viewProfile());
    }@Test
    void testSearchForStudentUNNormal()
    {
        advisor.addAdvisee(student);
        assertEquals(advisor.searchByUserName("pmm"), advisor.getAdviseeList().get(0).viewProfile());
    }

    @Test
    void testSearchForStudentUNNotInList()
    {
        advisor.addAdvisee(student);
        assertNotEquals(advisor.searchByUserName("kmm"), advisor.getAdviseeList().get(0).viewProfile());
    }

}
