package src;

import java.util.ArrayList;

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
        application.loadAll();
        ArrayList<User> users = application.getUserList();
        for(User user : users) {
            if(user instanceof Advisor) {
                if(((Advisor) user).getAdviseeList() != null) {
                    System.out.println("ADVISEE LIST: " + ((Advisor) user).getAdviseeList().toString());
                }
            } else if (user instanceof Student) {
                if(((Student) user).getMajor() != null) {
                    System.out.println("MAJOR: " + ((Student) user).getMajor().toString());
                    System.out.println("MAJORID: " + ((Student) user).getMajor().getMajorID());
                }
            }
        }
        ArrayList<Major> mjrs = application.getMajors();
        for(Major major : mjrs) {
            System.out.println("ENROLLED COURSES: " + major.getEnrolledCourses().toString());
            System.out.println("REQUIRED COURSES: " + major.getRequiredCourses().toString());
            System.out.println("COMPLETED COURSES: " + major.getCompletedCourses().toString());
        } 

        DataWriter.parseUserList();
        DataWriter.writeUsers();
        DataWriter.writeCourses();
        DataWriter.writeMajors();
        DataWriter.writeFaculty();
        DataWriter.writeAdvisors();
        DataWriter.writeStudents();
        DataWriter.writeAllID();
    }
}
