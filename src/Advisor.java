package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * class representing an advisor, extends the User class
 * 
 * @author Ben Thompson
 */
public class Advisor extends User {
    private String office;
    private String officeHours;
    private String phoneNumber;
    private ArrayList<Student> adviseeList;
    private String schoolOfFocus;
    private String searchField;
    // Appointment will cause errors for now until appointment class completed
    protected ArrayList<Appointment> appointments;

    /**
     * Constructs an advisor object with the following attributes.
     * 
     * @param office        The location of the advisor's office
     * @param officeHours   The office hours of the advisor.
     * @param phoneNumber   The advisor's phone number.
     * @param adviseeList   A list of all the students the advisor
     *                      has to advise.
     * @param schoolOfFocus The school the advisor focuses on.
     * @param appointments  A list of all the appointments the advisor
     *                      has available.
     * @param firstName     The first name of the advisor.
     * @param lastName      The last name of the advisor.
     * @param email         The email address of the advisor.
     * @param username      The username of the advisor.
     * @param password      The password of the advisor.
     */
    public Advisor(String office, String officeHours,
            String phoneNumber, ArrayList<Student> adviseeList, String schoolOfFocus,
            ArrayList<Appointment> appointments, String firstName, String lastName,
            String email, String username, String password) {
        super(firstName, lastName, email, username, password, 2);
        this.office = office;
        this.officeHours = officeHours;
        this.phoneNumber = phoneNumber;
        this.adviseeList = adviseeList;
        this.schoolOfFocus = schoolOfFocus;
        this.appointments = appointments;
    }

    /**
     * Constructs a new faculty with a username and password
     * 
     * @param username the facultys username
     * @param password the facultys password
     */
    public Advisor(String username, String password) {
        super(username, password, 2);
    }
    // Getters and Setters

    /**
     * Gets the location of where the advisor's office is located.
     * 
     * @return The location of the office.
     */
    public String getOffice() {
        return office;
    }

    /**
     * Sets the location of the advisor's office.
     * 
     * @param office The location of the office.
     */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
     * Gets the advisor's office hours.
     * 
     * @return The office hours of the advisor.
     */
    public String getOfficeHours() {
        return officeHours;
    }

    /**
     * Sets the advisor's office hours.
     * 
     * @param officeHours The office hours for the advisor.
     */
    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    /**
     * Gets the advisor's phone number.
     * 
     * @return The advisor's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the advisor's phone number.
     * 
     * @param phoneNumber The advisor's phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets a list of all the advisees.
     * 
     * @return The list of all the advisees.
     */
    public ArrayList<Student> getAdviseeList() {
        return adviseeList;
    }

    /**
     * Sets the students into a list of advisees.
     * 
     * @param adviseeList A list of all the students being advised.
     */
    public void setAdviseeList(ArrayList<Student> adviseeList) {
        this.adviseeList = adviseeList;
    }

    /**
     * Gets the school of focus for the advisor.
     * 
     * @return The advisor's school of focus.
     */
    public String getSchoolOfFocus() {
        return schoolOfFocus;
    }

    /**
     * Sets the advisor's school of focus.
     * 
     * @param schoolOfFocus The advisor's school of focus.
     */
    public void setSchoolOfFocus(String schoolOfFocus) {
        this.schoolOfFocus = schoolOfFocus;
    }

    /**
     * Gets a list of all the appointments with the advisor that
     * are available.
     * 
     * @return The available appointments.
     */
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Sets the list of appointments that the advisor has available.
     * 
     * @param appointments The available appointments.
     */
    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    // Methods

    /**
     * Allows the advisor to write a comment on the profile of a student
     * they are advising.
     * 
     * @param student The student that they are currently viewing/advising.
     * @return A string of the comment being written on the student's profile.
     */
    public String writeStudentComment() {
        return null;
    }

    /**
     * Lets the advisor view a list of the students they will advise.
     * 
     * @param avisees The list of the advisees.
     */
    public void viewAdvisees(ArrayList<Student> advisees) {

    }

    /**
     * Allows the advisor to view a specific student's profile.
     * 
     * @param student The student being viewed.
     * @return A string of the student's profile.
     */
    public String viewStudentProfile(Student student) {
        return null;
    }

    /**
     * Allows the advisor to view all the appointments they have.
     * 
     * @param appointments A list of all their current appointments.
     * @return The current list of appointments.
     */
    public ArrayList<Appointment> viewAppointments(ArrayList<Appointment> appointments) {
        return appointments;
    }

    /**
     * Adds a student to the list of advisees.
     * 
     * @param advisees The list of advisees.
     */
    public void addAdvisee(Student advisees) {

    }

    /**
     * Allows the advisor to add an appointment to their current list of
     * appointments
     * 
     * @param appointments The advisor's current list of appointments.
     */
    public void addAppointment(Appointment appointments) {

    }

    /**
     * Allows a search for a student by their name
     * 
     * @param searchFeild name that is being searched
     * @return Student with matching name
     */
    public ArrayList<Student> searchByName(String searchFeild) {
        ArrayList<Student> results = new ArrayList<>();
        for (Student student : adviseeList) {
            if (student.getFirstName().equalsIgnoreCase(searchField)) {
                results.add(student);
            }
        }
        return results;
    }

    /**
     * Allows a seach for a student by their ID
     * 
     * @param searchFeild ID that is being searched
     * @return Student with matching ID
     */
    public ArrayList<Student> searchByID(String searchFeild) {
        ArrayList<Student> results = new ArrayList<>();
        for (Student student : adviseeList) {
            if (student.getUserID().equals(searchField)) {
                results.add(student);
            }
        }
        return results;
    }

    /**
     * Allows a search for a student by their username
     * 
     * @param searchFeild username that is being searched
     * @return Student with matching username
     */
    public ArrayList<Student> searchByUserName(String searchFeild) {
        ArrayList<Student> results = new ArrayList<>();
        for (Student student : adviseeList) {
            if (student.getUsername().equalsIgnoreCase(searchField)) {
                results.add(student);
            }
        }
        return results;
    }
    }
    