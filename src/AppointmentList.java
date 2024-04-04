package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author: Jacob Robertson
 */
public class AppointmentList {
    private static AppointmentList instance;
    private ArrayList<Appointment> appointments;

    private AppointmentList() {
        appointments = new ArrayList<>();
        ArrayList<Appointment> appts = DataLoader.loadAppointments();
        appointments.addAll(appts);
    }

    public static AppointmentList getInstance() {
        if (instance == null) {
            instance = new AppointmentList();
        }
        return instance;
    }

    // adds an appointment to the list
    public void addAppointment(Appointment appointment) {
        if (appointment != null && appointment instanceof Appointment) {
            appointments.add(appointment);
        }
    }

    // removes an appointment by its uuid object
    public void removeAppointment(UUID uuid) {
        if (uuid != null && uuid instanceof UUID) {
            for (Appointment appointment : appointments) {
                if (appointment.getAppointmentID().equals(uuid)) {
                    appointments.remove(appointment);
                }
            }
        }
    }

    // removes an appointment by its string uuid
    public void removeAppointment(String uuid) {
        if (uuid != null) {
            for (Appointment appointment : appointments) {
                if (appointment.getAppointmentID().equals(UUID.fromString(uuid))) {
                    appointments.remove(appointment);
                }
            }
        }
    }

    // gets an appointment by its uuid object
    public Appointment getAppointment(UUID uuid) {
        if (uuid != null && uuid instanceof UUID) {
            for (Appointment appointment : appointments) {
                if (appointment.getAppointmentID().equals(uuid)) {
                    return appointment;
                }
            }
        }
        return null;
    }

    // gets an appointment by its string uuid
    public Appointment getAppointment(String uuid) {
        if (uuid != null) {
            for (Appointment appointment : appointments) {
                if (appointment.getAppointmentID().equals(UUID.fromString(uuid))) {
                    return appointment;
                }
            }
        }
        return null;
    }

    // returns the arraylist of appointments
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    // final touches for the appointmentlist
    public void loadAll() {
        DataLoader.finishAppointments(appointments);
    }

    // clears the list
    public void clear() {
        appointments.clear();
    }
}
