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
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class DataWriterTest {
    
    private UserList userList = UserList.getInstance();
	
	@BeforeEach //start with empty lists
	public void setup() {
		UserList.getInstance().getUsers().clear(); //clears the user list
        MajorList.getInstance().getMajors().clear(); //clears the major list
        CourseList.getInstance().getCourses().clear(); //clears the courses list
		DataWriter.parseUserList(); 
        DataWriter.writeUsers();
        DataWriter.writeCourses();
        DataWriter.writeMajors();
        DataWriter.writeFaculty();
        DataWriter.writeAdvisors();
        DataWriter.writeStudents();
        DataWriter.writeAllID();
	}


    @Test
    void testWritingZeroUsers()
    {
        ArrayList<User> users = UserList.getInstance().getUsers();
        assertEquals(0, users.size());
    }

    @Test
	void testWritingOneUser() {
		userList.addUser(new Student("kcm", "password"));
		DataWriter.writeUsers();
        ArrayList<User> users = UserList.getInstance().getUsers();
		assertEquals("kcm", users.get(0).getUsername());
	}

    @Test
	void testWritingThreeUsers() {
		userList.addUser(new Student("kcm", "password" ));
		userList.addUser(new Faculty("pmm", "password"));
		userList.addUser(new Advisor("efg", "password"));
        ArrayList<User> users = UserList.getInstance().getUsers();
		assertEquals("pmm", users.get(2).getUsername());
	}
	
	@Test
	void testWritingEmptyUser() {
		userList.addUser(new Student("", ""));
		DataWriter.writeUsers();
        ArrayList<User> users = UserList.getInstance().getUsers();
		assertEquals("", users.get(0).getUsername());
	}
	
	@Test
	void testWritingNullUser() {
		userList.addUser(new Student(null, ""));
		DataWriter.writeUsers();
        ArrayList<User> users = UserList.getInstance().getUsers();
		assertEquals(null, users.get(0).getUsername());
	}


}
