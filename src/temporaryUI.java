package src;

public class temporaryUI 
{


    private static Application application;


    public static void main(String [] args)
    {
        application = Application.getInstance();
        System.out.println(application.login("alicejohnson456", "securepass456"));
    }
}
