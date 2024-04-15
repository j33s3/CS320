/**
 * Project: ContactService
 * Author: Jesse Peterson
 * School: SNHU
 */

 import java.util.Date;

      /* Requirments */
///////////////////////////////
//1. Appointment ID cannot be//
//   null and cannot exceed  //
//   10 characters.          //
///////////////////////////////
//2. Date cannot be null and //
//    cannnot be in the past //
///////////////////////////////
//3. Description cannot be   //
//   null and cannot exceed  //
//   50 characters.          //
///////////////////////////////


public class Appointment {

    //Object Fields
    private final String appointmentId;
    private String description;
    private Date appointmentDate;

    /**
     * Base constructor for the object
     * Validates each of the arguments then initializes them
     * @param appID, Appointment ID
     * @param desc, Appointment Description
     * @param date, Appointment Date
     */
    public Appointment(String appID, String desc, Date date) {
        
        //verify each args match requirments
        if(appID == null || appID.length() > 10) {
            throw new IllegalArgumentException("Appointment ID is invalid");
        }
        if(desc == null || desc.length() > 50) {
            throw new IllegalArgumentException("Description is invalid");
        }
        if(date == null || new Date().before(date)) {
            throw new IllegalArgumentException("Appointment date is invalid");
        }

        //initialize fields
        appointmentId = appID;
        description = desc;
        appointmentDate = date;
    }

    /**
     * returns the AppointmentId
     * @return
     */
    public String getAppointmentId() {
        return appointmentId;
    }

    /**
     * Returns the appointmentDescription
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * returns the appointmentDate
     * @return
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }
    
    /**
     * sets the appointmentDescription
     * @param desc
     */
    public void setDescription(String desc) {
        //verify argument follows requirments
        if(desc == null || desc.length() > 50) {
            throw new IllegalArgumentException("Description is invalid");
        }

        //Sets field
        description = desc;
    }

    /**
     * sets the appointmentDate
     * @param date
     */
    public void setAppointmentDate(Date date) {
        //verify argument follows requirments
        if(date == null || date.before(new Date())) {
            throw new IllegalArgumentException("Date is invalid");
        }

        //Sets field
        appointmentDate = date;
    }



}
