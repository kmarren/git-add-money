package src;

import java.util.UUID;

/**
 * Class used to set up appointments.
 * 
 * @author Ben Thompson
 */
public class Appointment {
    private UUID advisorID;
    private String time;
    private String location;


    /**
     * Constructs an appointment object with the following attributes.
     * 
     * @param advisorID     The advisor's ID.
     * @param time          The time of the appointment.
     * @param location      The location of the appointment.
     */
    public Appointment(UUID advisorID, String time, String location) {
        this.advisorID = advisorID;
        this.time = time;
        this.location = location;
    }

    // Getters and setters

    /**
     * Gets the ID of the advisor.
     * 
     * @return The advisor's ID.
     */
    public UUID getAdvisorID() {
        return advisorID;
    }

    /**
     * Sets the ID of the advisor.
     * 
     * @param id The ID
     */
    public void setAdvisorId(UUID id) {
        this.advisorID = id;
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
}
