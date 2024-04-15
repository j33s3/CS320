/**
 * Project: ContactService
 * Author: Jesse Peterson
 * School: SNHU
 */

import java.lang.IllegalArgumentException;

         /* Requirments */
////////////////////////////////////////
//1. Contact ID cannot be longer than // 
//   10 characters, Shall not be null //
//   and shall not be updated         //
////////////////////////////////////////
//2, firstName cannot be longer than  //
//   10 characters, shall not be null //
////////////////////////////////////////
//3. lastName cannot be longer than   //
//   10 characters, shall not be null //
////////////////////////////////////////
//4. phone must be exactly 10 digits  //
//   cannot be null                   //
////////////////////////////////////////
//5. address cannot exceed 30         //
//   characters and cannot be null    //
////////////////////////////////////////


public class Contact{

    private final String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String cID, String fName, String lName, String phn, String addr) {

        //check for proper formatting
        if(cID == null || cID.length() > 10) {
            throw new IllegalArgumentException("contact ID is invalid");
        }

        if(fName == null || fName.length() > 10) {
            throw new IllegalArgumentException("First name is invalid");
        }

        if(lName == null || lName.length() > 10) {
            throw new IllegalArgumentException("Last name is invalid");
        }

        if(phn == null || phn.length() != 10) {
            throw new IllegalArgumentException("Phone number is invalid");
        }

        if(addr == null || addr.length() > 30) {
            throw new IllegalArgumentException("Address is invalid");
        }

        //initializes class variables
        contactID = cID;
        firstName = fName;
        lastName = lName;
        phone = phn;
        address = addr;
    }


    /**
     * Getter for // Contact ID //
     */
    public String getContactID() {
        return contactID;
    }

    /**
     * Getter for // First Name //
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter for // Last Name //
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter for // Phone //
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Getter for // Address //
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter for // First Name //
     */
    public void setFirstName(String fName){

        //if the argument is null or too great in length, throw exception
        if(fName == null || fName.length() > 10) {
            throw new IllegalArgumentException("First name is invalid");
        }  

        //update firstName variable
        firstName = fName;
    }

    /**
     * Setter for // Last Name //
     */
    public void setLastName(String lName){

        //if the argument is null or too great in length, throw exception
        if(lName == null || lName.length() > 10) {
            throw new IllegalArgumentException("Last name is invalid");
        }

        //update lastName variable
        lastName = lName;
    }

    /**
     * Setter for // Phone //
     */
    public void setPhone(String phn){
        
        //if the argument is null or too great in length, throw exception
        if(phn == null || phn.length() != 10) {
            throw new IllegalArgumentException("Phone number is invalid");
        }

        //update phone number
        phone = phn;
    }

    /**
     * Setter for // address //
     */
    public void setAddress(String addr){

        //if the argument is null or too great in length, throw exception
        if(addr == null || addr.length() > 30) {
            throw new IllegalArgumentException("Address is invalid");
        }

        //update address
        address  = addr;
    }
}