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
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class DataWriterTest {
    
    private UserList userList = UserList.getInstance();
	private CourseList courseList = CourseList.getInstance();
	private MajorList majorList = MajorList.getInstance();
	
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

	void testWritingZeroCourses()
    {
        ArrayList<Course> courses = CourseList.getInstance().getCourses();
        assertEquals(0, courses.size());
        assertEquals(0, courses.size());
    }

    @Test
	void testWritingOneCourse() {
		courseList.addCourse(new Course(145, "CSCE145", "Algorithmic Design"));
		DataWriter.writeCourses();
        ArrayList<Course> courses = CourseList.getInstance().getCourses();
		assertEquals("CSCE145", courses.get(0).getCourseCode());
	}

    @Test
	void testWritingThreeCourses() {
		courseList.addCourse(new Course(145, "CSCE145", "Algorithmic Design"));
		courseList.addCourse(new Course(146, "CSCE146", "Algorithmic Design II"));
		courseList.addCourse(new Course(247, "CSCE247", "Software Engineering"));
		DataWriter.writeCourses();
		ArrayList<Course> courses = CourseList.getInstance().getCourses();
		assertEquals("CSCE247", courses.get(2).getCourseCode());
	}
	
	@Test
	void testWritingEmptyCourse() {
		courseList.addCourse(new Course(145, "", ""));
		DataWriter.writeCourses();
        ArrayList<Course> courses = CourseList.getInstance().getCourses();
		assertEquals("", courses.get(0).getCourseCode());
	}
	
	@Test
	void testWritingNullCourse() {
		courseList.addCourse(new Course(145, null, ""));
		DataWriter.writeCourses();
        ArrayList<Course> courses = CourseList.getInstance().getCourses();
		assertEquals(null, courses.get(0).getCourseCode());
	}

	void testWritingZeroMajor()
    {
        ArrayList<Major> majors = MajorList.getInstance().getMajors();
        assertEquals(0, majors.size());
    }

    @Test
	void testWritingOneMajor() {
		majorList.addMajor(new Major("Computer Science"));
		DataWriter.writeMajors();
        ArrayList<Major> majors = MajorList.getInstance().getMajors();
		assertEquals("Computer Science", majors.get(0).getTitle());
	}

    @Test
	void testWritingThreeMajor() {
		majorList.addMajor(new Major("Computer Science"));
		majorList.addMajor(new Major("Computer Engineering"));
		majorList.addMajor(new Major("Computer Information Systems"));
		DataWriter.writeMajors();
        ArrayList<Major> majors = MajorList.getInstance().getMajors();
		assertEquals("Computer Information Systems", majors.get(2).getTitle());
	}
	
	@Test
	void testWritingEmptyMajor() {
		majorList.addMajor(new Major(""));
		DataWriter.writeMajors();
        ArrayList<Major> majors = MajorList.getInstance().getMajors();
		assertEquals("", majors.get(0).getTitle());
	}
	
	@Test
	void testWritingNullMajor() {
		majorList.addMajor(new Major(null));
		DataWriter.writeMajors();
        ArrayList<Major> majors = MajorList.getInstance().getMajors();
		assertEquals(null, majors.get(0).getTitle());
	}



}
