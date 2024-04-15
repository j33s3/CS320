/**
 * Project: ContactService
 * Author: Jesse Peterson
 * School: SNHU
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;


         /* Requirments */
//////////////////////////////////////
//1. Add appointments with unique ID//
//////////////////////////////////////
//2. delete appointments base on ID //
//////////////////////////////////////

public class AppointmentService {

    /**
     * Stores appointment data as arrayList
     */
    private static List<Appointment> appointments = new ArrayList<Appointment>();

    /**
     * Creates the only instance of the AppointmentService class
     */
    private static AppointmentService service = new AppointmentService();

    /**
     * Tracks the id number based on additions to list
     */
    private static int nextId = 1;

    /**
     * private, empty constructor to prevent additionl instances
     */
    private AppointmentService() {

    }

    /**
     * Returns the only instance of the class
     * @return, AppointmentService
     */
    public static AppointmentService getService() {
        return service;
    }

    /**
     * Creates and adds the appointment to the list
     * @param desc, Appointment description
     * @param date, Appointment Dat
     * @return, Created appointment
     */
    public Appointment addAppointment(String desc, Date date) {
        Appointment appointment;

        //try to create new appointment object
        try {
            appointment = new Appointment(String.valueOf(getAppointmentId()), desc, date);

            if(getAppointment(String.valueOf(appointment.getAppointmentId())) != null) {
                throw new IllegalArgumentException("Appointment ID is duplicate");
            }
        }
        //catch exception if data was invalid
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }

        //add appointment object to list and return the value
        appointments.add(appointment);
        return appointment;
    }

    public Appointment addAppointment(Appointment appointment) throws IllegalArgumentException {
        

            if(getAppointment(String.valueOf(appointment.getAppointmentId())) != null) {
                throw new IllegalArgumentException("Appointment ID is duplicate");
            }
        
            appointments.add(appointment);
            return appointment;
    }

    /**
     * Deletes the appointment with the desgnated AppointmentID
     * @param appId, Appointment ID
     */
    public void deleteAppointment(String appId) {
        Iterator<Appointment> iterator = appointments.iterator();

        //while their are items left in the list
        while(iterator.hasNext()) {
            Appointment appointment = iterator.next();

            //if the appointment id matches the argument, remove it.
            if(appointment.getAppointmentId().equals(appId)) {
                iterator.remove();
                return;
            }
        }

    }

    /**
     * retrieves appointment based on Id number
     * @param appId, Appointment Id
     * @return
     */
    public Appointment getAppointment(String appId) {
        Iterator<Appointment> iterator = appointments.iterator();

        //While their are more items in the list
        while(iterator.hasNext()) {
            Appointment appointment = iterator.next();

            //If appointment Id matches argument then return appointment
            if(appointment.getAppointmentId().equals(appId)) {
                return appointment;
            }
        }
        //If not found then return null;
        return null;
    }

    /**
     * Retrieves the appointment at a specific index
     * @param index
     * @return, Appointment
     */
    public Appointment getAppointmentAtIndex(int index) {
        return appointments.get(index);
    }

    /**
     * Returns the next appointment ID and increments it
     * @return, int 
     */
    private int getAppointmentId() {
        return nextId++;
    }

    public int getAppointmentLength() {
        return appointments.size();
    }


}