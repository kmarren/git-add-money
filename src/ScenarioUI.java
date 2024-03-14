package src;
import java.util.Scanner;

public class ScenarioUI {

    private static Application application;
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) 
    {
        application = Application.getInstance();
        application.loadAll();
        System.out.println("Welcome to DegreeCraft");
        System.out.println("Login or sign up?");
        if(keyboard.nextLine().equalsIgnoreCase("login"))
        {
            login();
        }
        else
        {
            signUp();
        }
    }

    public static void login()
    {
        System.out.println("Welcome back! Username:");
        String username = keyboard.nextLine();
        System.out.println("Password:");
        String password = keyboard.nextLine();

        if(application.login(username, password))
        {
            System.out.println("Accepted");
        }
        else
        {
            System.out.println("Rejected");
        }
    }

    public static void signUp()
    {
        int type = 0;
        System.out.println("Are you a Student, Faculty, or Advisor?"); 
        if(keyboard.nextLine().equalsIgnoreCase("student"))
        {
            type = 1;
        }
        else if(keyboard.nextLine().equalsIgnoreCase("advisor"))
        {
            type = 2;
        }
        else if(keyboard.nextLine().equalsIgnoreCase("faculty"))
        {
            type = 3;
        }
        System.out.println("Username:");
        String username = keyboard.nextLine();
        System.out.println("Password:");
        String password = keyboard.nextLine();
        application.signUp(username, password, type);
    }
}