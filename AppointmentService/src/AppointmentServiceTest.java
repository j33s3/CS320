/**
 * Project: ContactService
 * Author: Jesse Peterson
 * School: SNHU
 */

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Date;

public class AppointmentServiceTest {

    //creates a date value in the past to be used for all tests.
    Calendar cal = new Calendar.Builder().setDate(2023, 12, 31).build();
    Date date = cal.getTime();

    /**
     * Tests that we are able ot add appointments to the list
     * Checks that the ID numbers are different
     */
    @Test
    public void addAppointmentWithUniqueID() {
        AppointmentService service = AppointmentService.getService();

        //Create and adds two new appointments
        service.addAppointment("Half-Life 1 is great", date);
        service.addAppointment("Half-Life 2 is great", date);
        
        //Verifies that the IDs are unique and then ensures the proper appointment is assigned
        assertEquals("1", service.getAppointmentAtIndex(0).getAppointmentId());
        assertEquals("Half-Life 1 is great", service.getAppointment("1").getDescription());

        assertEquals("2", service.getAppointmentAtIndex(1).getAppointmentId());
        assertEquals("Half-Life 2 is great", service.getAppointment("2").getDescription());


    }

    /**
     * Tests that we are able to delete Appointments based on their Id
     */
    @Test
    public void deleteAppointmentFromID() {
        AppointmentService service = AppointmentService.getService();

        //Verifies that data stayed from previous test
        assertEquals("1", service.getAppointmentAtIndex(0).getAppointmentId());
        //Delete appointment
        service.deleteAppointment("1");
           
        //After deletion second element bumps into index 0
        assertEquals("2", service.getAppointmentAtIndex(0).getAppointmentId());
        //Delete and make sure list is empty
        service.deleteAppointment("2");
        assertEquals(0, service.getAppointmentLength());
    }


    /**
     * Tests for duplicate appointment Ids
     */
    @Test
    public void addTaskDuplicateTask() {
        AppointmentService service = AppointmentService.getService();
        Appointment app1 = new Appointment("10", "Appointment", date);
        Appointment app2 = new Appointment("10", "Appointment", date);


        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(app1);
            service.addAppointment(app2);
        });

        Assertions.assertEquals(thrown.getMessage(), "Appointment ID is duplicate");
    }

}
