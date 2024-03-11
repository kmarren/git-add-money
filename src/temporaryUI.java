package src;

public class temporaryUI {

    private static Application application;

    public static void main(String[] args) {
        application = Application.getInstance();
        System.out.println(application.login("alicejohnson456", "securepass456"));
        application.signUp("timmyballer", "swagwrod", 1);
        application.signUp("johndoe", "password123", 2);
        System.out.println(application.login("timmyballer", "swagwrod"));
        System.out.println(application.login("johndoe", "balsdj"));
        System.out.println(application.getCourseList().toString());
        DataWriter.saveUsers();
    }
}
