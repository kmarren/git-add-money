package src;
import java.util.Scanner;

public class ScenarioUI {

    private static Application application = Application.getInstance();
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) 
    {
        application.loadAll();
        application.printGreeting();
        loginOrSignUp();
        application.createSpecificTypes();
        printOptions();
        int choice = keyboard.nextInt();
        if(application.getUserType() == 1)
            application.executeStudentChoice(choice);
        else if (application.getUserType() == 2)
            application.executeAdvisorChoice(choice);
        else
           // application.executeFacultyChoice();
           System.out.println(" ");
    }

    public static void loginOrSignUp()
    {
        boolean choice = false;
        while(!choice)
        {
            System.out.println("Login or Sign Up?");
            String input = keyboard.nextLine();
            if(application.canLoginOrSignUp(input))
            {
                if(input.equalsIgnoreCase("login"))
                    login();
                if(input.equalsIgnoreCase("sign up"))
                    signUp();
                choice = true;
            }
            else
            {
                System.out.println("Please Try Again");
                continue;
            }
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