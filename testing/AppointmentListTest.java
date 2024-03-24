package testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.Appointment;
import src.AppointmentList;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

public class AppointmentListTest {
    private AppointmentList appointmentList;
    private Appointment appointment1;

    @Before
    public void setUp() {
        appointmentList = AppointmentList.getInstance();
        appointment1 = appointmentList.getAppointment(UUID.fromString("76a89137-3754-418f-9638-3735b8601310"));
        // appointment1.setAppointmentID(UUID.fromString("76a89137-3754-418f-9638-3735b8601310"));
    }

    @After
    public void tearDown() {
        appointmentList.clear();
    }

    @Test
    public void testGetInstance() {
        AppointmentList newInstance = AppointmentList.getInstance();
        assertSame(appointmentList, newInstance);
    }

    @Test
    public void testGetAppointments() {
        ArrayList<Appointment> appointments = appointmentList.getAppointments();
        assertFalse(appointments.isEmpty());
    }

    @Test
    public void testGetAppointmentByUUID() {
        assertNotNull(appointmentList.getAppointment(appointment1.getAppointmentID()));
    }

    @Test
    public void testGetAppointmentByUUIDWithNonExistingUUID() {
        assertNull(appointmentList.getAppointment(UUID.randomUUID()));
    }

    @Test
    public void testGetAppointmentByUUIDWithNullUUID() {
        assertNull(appointmentList.getAppointment(null));
    }

    @Test
    public void testAddAppointment() {
        int sizeBefore = appointmentList.getAppointments().size();
        Appointment newAppointment = new Appointment();
        appointmentList.addAppointment(newAppointment);
        int sizeAfter = appointmentList.getAppointments().size();
        assertEquals(sizeBefore + 1, sizeAfter);
        assertTrue(appointmentList.getAppointments().contains(newAppointment));
    }

    @Test
    public void testRemoveAppointment() {
        int sizeBefore = appointmentList.getAppointments().size();
        appointmentList.removeAppointment(appointment1.getAppointmentID());
        int sizeAfter = appointmentList.getAppointments().size();
        assertEquals(sizeBefore - 1, sizeAfter);
        assertNull(appointmentList.getAppointment(appointment1.getAppointmentID()));
    }

    @Test
    public void testRemoveNonExistingAppointment() {
        int sizeBefore = appointmentList.getAppointments().size();
        appointmentList.removeAppointment(UUID.randomUUID());
        int sizeAfter = appointmentList.getAppointments().size();
        assertEquals(sizeBefore, sizeAfter);
    }

    @Test
    public void testClear() {
        appointmentList.clear();
        assertTrue(appointmentList.getAppointments().isEmpty());
    }

    @Test
    public void testAddMultipleAppointments() {
        int sizeBefore = appointmentList.getAppointments().size();
        Appointment newAppointment1 = new Appointment();
        Appointment newAppointment2 = new Appointment();
        appointmentList.addAppointment(newAppointment1);
        appointmentList.addAppointment(newAppointment2);
        int sizeAfter = appointmentList.getAppointments().size();
        assertEquals(sizeBefore + 2, sizeAfter);
        assertTrue(appointmentList.getAppointments().contains(newAppointment1));
        assertTrue(appointmentList.getAppointments().contains(newAppointment2));
    }

    @Test
    public void testRemoveAllAppointments() {
        appointmentList.clear();
        assertTrue(appointmentList.getAppointments().isEmpty());
    }

    @Test
    public void testGetNonExistingAppointment() {
        Appointment appointment = appointmentList.getAppointment(UUID.randomUUID());
        assertNull(appointment);
    }

    @Test
    public void testAddNullAppointment() {
        int sizeBefore = appointmentList.getAppointments().size();
        appointmentList.addAppointment(null);
        int sizeAfter = appointmentList.getAppointments().size();
        assertEquals(sizeBefore, sizeAfter);
    }

}
