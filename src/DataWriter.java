package src;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataWriter extends DataConstants 
{

    private static ArrayList<User> students = new ArrayList<User>();
    private static ArrayList<User> faculty = new ArrayList<User>();;
    private static ArrayList<User> advisors = new ArrayList<User>();;
   
    
    private static ArrayList<Course> courses = new ArrayList<Course>();
    
    private ArrayList<Major> majors = new ArrayList<Major>();


    public static void parseUserList()
    {
        for(int i=0; i< UserList.getInstance().getUsers().size(); i++)
        {
            if (UserList.getInstance().getUsers().get(i).getType() == 3)
            {
                faculty.add(UserList.getInstance().getUsers().get(i));
            }
            else if (UserList.getInstance().getUsers().get(i).getType() == 2)
            {
                advisors.add(UserList.getInstance().getUsers().get(i));
            }
            else
            {
                students.add(UserList.getInstance().getUsers().get(i));
            }
        }
    }






    public static void writeCourses()
    {

    }

    public static void writeMajors()
    {

    }
}
