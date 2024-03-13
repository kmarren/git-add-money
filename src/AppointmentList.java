package src;

import java.util.ArrayList;
import java.util.UUID;

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

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public Appointment getAppointment(UUID uuid) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentID().equals(uuid)) {
                return appointment;
            }
        }
        return null;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
}

