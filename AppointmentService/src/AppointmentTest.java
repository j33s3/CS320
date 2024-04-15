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

public class AppointmentTest {

    //Creates new date in the past for all tests
    Calendar past = new Calendar.Builder().setDate(2023, 12, 31).build();
    Date pastDate = past.getTime();

    /**
     * returns a string of characters for specified length
     * @param c, Character
     * @param occur, Occurances
     * @return, Complete string
     */
    private String nCharString(char c, int occur) {
        String str = "";

        for(int i = 0; i < occur; i++) {
            str += c;
        }

        return str;
    }


    /////////////////////////////
    //Test Proper Functionality//
    /////////////////////////////

    /**
     * Tests each id length 0-10
     */
    @Test
    public void idNumberInRange() {

        //for length 0-10
        for(int i = 0; i <= 10; i++) {
            //create an Id of length i and attempt to make an appointment object
            String ID = nCharString('1', i);
            Appointment appointment = new Appointment(ID, "What is your favorite color?", pastDate);
        
            assertEquals(ID, appointment.getAppointmentId());
        }

    }

    /**
     * Tests each Description length 0-50
     */
    @Test
    public void descriptionInRange() {
        //For length 0-50
        for(int i = 0; i <= 50; i++) {
            //Create desc of lenght i and attempt to make an appointment object
            String desc = nCharString('1', i);
            Appointment appointment = new Appointment("1", desc, pastDate);

            assertEquals(desc, appointment.getDescription());
        }

    }

    /**
     * Tests date in range
     * pastDate = (2023, 12, 31)
     */
    @Test
    public void dateInRange() {
        //attempt to create an appointment object with valid date
        Appointment appointment = new Appointment("1", "What is your favorite color?", pastDate);
        assertEquals(pastDate, appointment.getAppointmentDate());

    }


    /////////////////////////////////////
    //Test setting fields out-of-bounds//
    /////////////////////////////////////

    /**
     * Checks for Exception when id is out of bounds
     */
    @Test
    public void idOutOfBoundsException() {

        //check for exception when id out of bounds
        IllegalArgumentException thrown  = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("01234567890", "Half-Life 2 for the win", pastDate);
        });

        //Check for proper exception
        Assertions.assertEquals("Appointment ID is invalid", thrown.getMessage());

    }

    /**
     * Checks for exception when description out of bounds
     */
    @Test
    public void descOutOfBoundsException() {
        //Check for exception when description is out of bounds
        IllegalArgumentException thrown  = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", "012345678901234567890123456789012345678901234567890", pastDate);
        });

        //Check for proper exception
        Assertions.assertEquals("Description is invalid", thrown.getMessage());

    }

    /**
     * Checks for exception when date is in the future
     */
    @Test
    public void dateOutOfBounds() {
        //new date in the future (2070, 01, 01)
        Calendar future = new Calendar.Builder().setDate(2070, 1, 1).build();
        Date futureDate = future.getTime();

        //check for exception when date is in the future
        IllegalArgumentException thrown  = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("", "Half-Life 2 for the win", futureDate);
        });
        
        //Check for proper exception
        Assertions.assertEquals("Appointment date is invalid", thrown.getMessage());

    }

    ///////////////////////////////
    //Test setting fields to null//
    ///////////////////////////////

    /**
     * Checks for exception when id is null
     */
    @Test
    public void idNullThenExeption() {
        
        //Checks for exception when id is null
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, "Half-Life 2 for the win", pastDate);
        });

        //Check for proper exception
        Assertions.assertEquals("Appointment ID is invalid", thrown.getMessage());

    }

    /**
     * Checks for exception when description is null
     */
    @Test
    public void descNullThenException() {

        //checks for exception when description is null
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", null, pastDate);
        });

        //Check for proper exception
        Assertions.assertEquals("Description is invalid", thrown.getMessage());

    }

    /**
     * Checks for exception when date is null
     */
    @Test
    public void dateNullThenException() {

        //checks for exception when date is null
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", "Half-Life 2 for the win", null);
        });

        //Check for proper exception
        Assertions.assertEquals("Appointment date is invalid", thrown.getMessage());

    }
}
