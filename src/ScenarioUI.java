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
        System.out.println("Welcome back! Please enter your username.");
        String username = keyboard.nextLine();
        System.out.println("Please enter your password.");
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
        
    }
}