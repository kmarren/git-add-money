package src;
import java.util.Scanner;

public class ScenarioUI {

    private static Application application = Application.getInstance();
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) 
    {
        application.loadAll();
        application.printGreeting();
        loginOrSignUp(keyboard.nextLine());
        application.createSpecificTypes();
        printOptions();
        int choice = keyboard.nextInt();
        application.executeStudentChoice(choice);
    }

    public static void loginOrSignUp(String input)
    {
        if (input.equalsIgnoreCase("login"))
        {
            login();
        }
        else if (input.equalsIgnoreCase("sign up"))
        {
            signUp();
        }
        else
        {
            System.out.println("Invalid input. Please Try Again.");
        } 
    }

    public static void login()
    {
        boolean login = false;
        while(!login)
        {
            System.out.println("Username:");
            String username = keyboard.nextLine();
            System.out.println("Password:");
            String password = keyboard.nextLine();
            application.login(username, password);
            if(application.canLogin(username, password))
            {
                login = true;
            }
            else
            {
                continue;
            }
        }
       
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