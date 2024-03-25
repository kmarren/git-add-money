package testing;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import src.Advisor;
import src.Appointment;
import src.Student;
import src.User;
import src.UserList;

import java.util.ArrayList;
import java.util.UUID;

public class AdvisorTest {

    private Advisor advisor;
    private Student student1;
    private Student student2;
    private Appointment appointment1;
    private Appointment appointment2;
    private UserList userList;

    @Before
    public void setUp() {
        userList = UserList.getInstance(); 

        advisor = new Advisor("username", "password");
        student1 = new Student("John", "Doe", "johndoe@example.com", "johndoe", "password123");
        student2 = new Student("Jane", "Doe", "janedoe@example.com", "janedoe", "password456");

        
        appointment1 = new Appointment(student1, "10:00 AM", "Room 101");
        appointment2 = new Appointment(student2, "11:00 AM", "Room 102");

        
        advisor.setAdviseeList(new ArrayList<>());
        advisor.addAdvisee(student1);
        advisor.addAdvisee(student2);

        advisor.setAppointments(new ArrayList<>());
        advisor.addAppointment(appointment1);
        advisor.addAppointment(appointment2);
        userList.addUser(student1);
        userList.addUser(student2);
        userList.addUser(advisor);
    }


    @Test
    public void testWriteStudentComment() {
        String comment = "Needs improvement in math";
        advisor.writeStudentComment(student1, comment);
        assertTrue(student1.getStudentComments().contains(comment));
    }

    @Test
    public void testViewAdvisees() {
        advisor.addAdvisee(student1);
        advisor.addAdvisee(student2);
        ArrayList<Student> advisees = advisor.getAdviseeList();
        assertTrue(advisees.contains(student1) && advisees.contains(student2));
    }

    @Test
    public void testViewStudentProfile() {
        String profile = advisor.viewStudentProfile(student1);
        assertTrue(profile.contains(student1.getFirstName()) && profile.contains(student1.getLastName()));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetOfficeWithNull() {
        advisor.setOffice(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetOfficeHoursWithInvalidFormat() {
        advisor.setOfficeHours("invalidHours");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPhoneNumberWithInvalidNumber() {
        advisor.setPhoneNumber("803123455");
    }

    @Test
    public void testSetSchoolOfFocusWithEmptyString() {
        advisor.setSchoolOfFocus("");
        assertEquals("", advisor.getSchoolOfFocus());
    }

    @Test
    public void testSetAdviseeListWithNull() {
        advisor.setAdviseeList(null);
        assertNull(advisor.getAdviseeList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullAdvisee() {
        advisor.addAdvisee(null);
    }

    @Test
    public void testSetAppointmentsWithNull() {
        advisor.setAppointments(null);
        assertNull(advisor.getAppointments());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullAppointment() {
        advisor.addAppointment(null);
    }

    @Test
    public void testAddAdvisee() {
        advisor.addAdvisee(student1);
        assertTrue(advisor.getAdviseeList().contains(student1));
    }

    @Test
    public void testAddAppointment() {
        advisor.addAppointment(appointment1);
        assertTrue(advisor.getAppointments().contains(appointment1));
    }

    @Test
    public void testViewAppointments() {
        advisor.addAppointment(appointment1);
        advisor.addAppointment(appointment2);
        ArrayList<Appointment> appointments = advisor.getAppointments();
        assertTrue(appointments.contains(appointment1) && appointments.contains(appointment2));
    }

    @Test
    public void testSearchByID() {
        String id = student1.getUserID().toString();
        ArrayList<Student> foundStudents = advisor.searchByID(id);
        assertNotNull(foundStudents);
        assertTrue(foundStudents.contains(student1));
    }

    @Test
    public void testSearchByName() {
        String name = student1.getFirstName();
        ArrayList<Student> foundStudents = advisor.searchByName(name);
        assertNotNull(foundStudents);
        assertTrue(foundStudents.contains);
    }

    @Test
    public void testSearchByUserName() {
        String username = student2.getUsername();
        User foundUser = advisor.searchByUserName(username);
        assertNotNull(foundUser);
        assertEquals(foundUser.getUsername(), student2.getUsername());
    }
    @Test
    public void testSetAndGetOffice() {
        String office = "Room 101";
        advisor.setOffice(office);
        assertEquals(office, advisor.getOffice());
    }

    @Test
    public void testSetAndGetOfficeHours() {
        String officeHours = "9 AM to 5 PM";
        advisor.setOfficeHours(officeHours);
        assertEquals(officeHours, advisor.getOfficeHours());
    }

    @Test
    public void testSetAndGetPhoneNumber() {
        String phoneNumber = "123-456-7890";
        advisor.setPhoneNumber(phoneNumber);
        assertEquals(phoneNumber, advisor.getPhoneNumber());
    }

    @Test
    public void testSetAndGetSchoolOfFocus() {
        String schoolOfFocus = "Engineering";
        advisor.setSchoolOfFocus(schoolOfFocus);
        assertEquals(schoolOfFocus, advisor.getSchoolOfFocus());
    }

    @Test
    public void testAdviseeList() {
        ArrayList<Student> advisees = new ArrayList<>();
        Student student1 = new Student("John", "Doe", "john@example.com", "john", "pass");
        Student student2 = new Student("Jane", "Doe", "jane@example.com", "jane", "pass");
        advisees.add(student1);
        advisees.add(student2);

        advisor.setAdviseeList(advisees);
        assertEquals(advisees, advisor.getAdviseeList());
        assertTrue(advisor.getAdviseeList().contains(student1));
        assertTrue(advisor.getAdviseeList().contains(student2));
    }

    @Test
    public void testAppointments() {
        ArrayList<Appointment> appointments = new ArrayList<>();
        Appointment appointment1 = new Appointment();
        Appointment appointment2 = new Appointment();
        appointments.add(appointment1);
        appointments.add(appointment2);

        advisor.setAppointments(appointments);
        assertEquals(appointments, advisor.getAppointments());
        assertTrue(advisor.getAppointments().contains(appointment1));
        assertTrue(advisor.getAppointments().contains(appointment2));
    }

    // Testing setting office with invalid input
    @Test(expected = IllegalArgumentException.class)
    public void testSetOfficeWithEmptyString() {
        advisor.setOffice("");
    }

    // Testing setting office hours with invalid input
    @Test(expected = IllegalArgumentException.class)
    public void testSetOfficeHoursWithEmptyString() {
        advisor.setOfficeHours("");
    }

    // Testing setting phone number with invalid formats
    @Test(expected = IllegalArgumentException.class)
    public void testSetPhoneNumberWithEmptyString() {
        advisor.setPhoneNumber("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPhoneNumberWithLetters() {
        advisor.setPhoneNumber("abc-def-ghij");
    }

    // Testing setting school of focus with invalid input
    @Test(expected = IllegalArgumentException.class)
    public void testSetSchoolOfFocusWithNull() {
        advisor.setSchoolOfFocus(null);
    }

    // Testing for invalid search criteria
    @Test(expected = IllegalArgumentException.class)
    public void testSearchByNameWithNull() {
        advisor.searchByName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchByNameWithEmptyString() {
        advisor.searchByName("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchByIDWithNull() {
        advisor.searchByID(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchByIDWithEmptyString() {
        advisor.searchByID("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchByUserNameWithNull() {
        advisor.searchByUserName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchByUserNameWithEmptyString() {
        advisor.searchByUserName("");
    }

    // Assuming Advisor class has a method to add comments to a student
    @Test(expected = IllegalArgumentException.class)
    public void testAddCommentToStudentWithEmptyComment() {
        Student student = new Student("Jane", "Doe", "jane@example.com", "janedoe", "pass");
        advisor.writeStudentComment(student, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCommentToStudentWithNullComment() {
        Student student = new Student("Jane", "Doe", "jane@example.com", "janedoe", "pass");
        advisor.writeStudentComment(student, null);
    }

}



