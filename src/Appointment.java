package src;

import java.util.UUID;

/**
 * Class used to set up appointments.
 * 
 * @author Ben Thompson
 */
public class Appointment {
    private UUID appointmentID;
    private Student student;
    private String time;
    private String location;

    public Appointment() {
        this.appointmentID = UUID.randomUUID();
    }

    /**
     * Constructs an appointment object with the following attributes.
     * 
     * @param student  the student appointment
     * @param time     The time of the appointment.
     * @param location The location of the appointment.
     */
    public Appointment(Student student, String time, String location) {
        this();
        this.student = student;
        this.time = time;
        this.location = location;
    }

    /**
     * Constructs an appointment object with the following attributes.
     * 
     * @param student  the student appointment
     * @param time     The time of the appointment.
     * @param location The location of the appointment.
     */
    public Appointment(Student student, String time, String location, UUID id) {
        this.student = student;
        this.time = time;
        this.location = location;
        this.appointmentID = id;
    }

    // Getters and setters

    public UUID getAppointmentID() {
        return this.appointmentID;
    }

    public void setAppointmentID(UUID id) {
        this.appointmentID = id;
    }

    /**
     * Gets the ID of the advisor.
     * 
     * @return The advisor's ID.
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets the ID of the advisor.
     * 
     * @param id The ID
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Get's the time that the appointment is taking place.
     * 
     * @return The time.
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time of the appointment.
     * 
     * @param time The time of the appointment.
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Gets the locaiton of the appointment.
     * 
     * @return The location of the appointment.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the appointment.
     * 
     * @param location The location of the appointment.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    public String toString() {
        return this.location;
    }
}
