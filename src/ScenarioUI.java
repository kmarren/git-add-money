package src;
import java.util.Scanner;

public class ScenarioUI {

    private static Application application;
    private static Scanner keyboard = new Scanner(System.in);
   //private static boolean loggedIn = true;
    public static void main(String[] args) 
    {
        application = Application.getInstance();
        application.loadAll();
        application.printGreeting();
        if (application.loginOrSignUp(keyboard.nextLine()) == 1)
            login();
        else
        {
            signUp();
        }
        printOptions();
        application.createSpecificTypes();
        System.out.println(application.listCompletedCourses());
    }

    public static void login()
    {
        System.out.println("Welcome back! Username:");
        String username = keyboard.nextLine();
        System.out.println("Password:");
        String password = keyboard.nextLine();
        application.login(username, password);
    }

    public static void signUp()
    {
        System.out.println("Are you a Student, Faculty, or Advisor?"); 
        String accountType = keyboard.nextLine();
        System.out.println("Username:");
        String username = keyboard.nextLine();
        System.out.println("Password:");
        String password = keyboard.nextLine();
        application.signUp(username, password, accountType);
    }

    public static void printOptions()
    {
        if (application.getUserType() == 1)
        {
            application.showStudentMenu();
        }
        else if (application.getUserType() == 2)
        {
            application.showAdvisorMenu();
        }
        else 
        {
            application.showFacultyMenu();
        }
    }
    
}