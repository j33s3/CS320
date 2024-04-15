
/**
 * Project: ContactService
 * Author: Jesse Peterson
 * School: SNHU
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ContactService{

    /**
     * Array list holding list of contacts
     */
    private static List<Contact> contacts = new ArrayList<Contact>();

    /**
     * Holds the next number for contact ID
     */
    private static int nextContactID = 1;

    /**
     * A singleton implementation for Contact Service
     */
    private static ContactService instance = new ContactService();

    /**
     * Empy Contact ServiceConstructor
     * Set to private so that new instances cannot be created
     */
    private ContactService(){

    }

    /**
     * Returns the one and only instance of ContactService
     */
    public static ContactService getContactService() {
        return instance;
    }

    /**
     * creates a contact and adds it into the array list
     * @param firstName
     * @param lastName
     * @param Phone
     * @param address
     * 
     * @return Contact, in the even the user would like to review Contact object
     */
    public Contact addContact(String firstName, String lastName, String phone, String address) {
        //create new contact with new contact id
        Contact contact = new Contact(String.valueOf(getContactId()), firstName, lastName, phone, address);

        //add the contact to list and return it
        contacts.add(contact);
        return contact;
    } 

    /**
     * Deletes contact from the array list
     * @param cId, CourseId to search for
     */
    public void deleteContact(String cID) {
        //create new iterator
        Iterator<Contact> iterator = contacts.iterator();

        //iterate throught the array list courses
        while(iterator.hasNext()) {
            Contact contact = iterator.next();

            //if the contact matches the argument then remove
            if(contact.getContactID().equals(cID)) {
                iterator.remove();
            }
        }
    }

    /**
     * Changed the first name for the contact
     * @param firstName
     * @param cID, contact ID
     */
    public void updateFirstName(String firstName, String cID) {
        //retrieves the contact
        Contact contact = getContact(cID);

        //if the contact exists
        if(contact != null) {
            //update the first name
            contact.setFirstName(firstName);
        }
        else {
            System.out.println("Contact not found.");
        } 
    }
    
    /**
     * Changes the last name for the client
     * @param lastName
     * @param cID, Contact ID
     */
    public void updateLastName(String lastName , String cID) {
        //retrive the contact
        Contact contact = getContact(cID);

        //if the contact does not exist
        if(contact != null) {
            //update the last name
            contact.setLastName(lastName);
        }
        else {
            System.out.println("Contact not found.");
        } 
    }

    /**
     * changes the phone number for the contact
     * @param phone
     * @param cID, Contact ID
     */
    public void updatePhone(String phone, String cID) {
        //retrive the contact
        Contact contact = getContact(cID);

        //if the contact does not exist
        if(contact != null) {
            //update the phone number
            contact.setPhone(phone);
        }
        else {
            System.out.println("Contact not found.");
        } 
    }

    /**
     * Changes the address for the contact
     * @param address
     * @param cID, Contact ID
     */
    public void updateAddress(String address, String cID) {
        //retrieve the contact
        Contact contact = getContact(cID);

        //if the contact does not exist
        if(contact != null) {
            //update the affress
            contact.setAddress(address);
        }
        else {
            System.out.println("Contact not found.");
        } 
    }

    /**
     * 
     * @param cID, Contact ID
     * @return
     */
    public Contact getContact(String cID) {
        //create new iterator
        Iterator<Contact> iterator = contacts.iterator();

        //while there are more items in the arrayList
        while(iterator.hasNext()) {
            Contact contact = iterator.next();

            //if the contact has the same id then return course
            if(contact.getContactID().equals(cID)) {
                return contact;
            }
        }

        return null;
    }

    /**
     * Returns the contact at index location
     * @param index
     * @return
     */
    public Contact getContactAtIndex(int index) {
        Contact contact = contacts.get(index);
        return contact;
    }


    /**
     * Retrieves the next Contact ID and increments the value
     * @return int, a contactID
     */
    public int getContactId() {
        //return next id and then increment
        return nextContactID++;
    }
}