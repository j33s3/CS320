import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Project: ContactService
 * Author: Jesse Peterson
 * School: SNHU
 */

public class ContactServiceTest {

    /**
     * Newly added contacts should have a unique id
     */
    @Test
    public void differentContactId() {
        //Retrieve instance of contactService
        ContactService service = ContactService.getContactService();

        //Add 2 contacts to contact service
        service.addContact("Gordon", "Freeman", "0123456789", "Black Mesa Laboratories");
        service.addContact("Alex", "Freeman", "0123456789", "NA");
        //test that the contacts are different
        assertEquals("1", service.getContactAtIndex(0).getContactID());
        assertEquals("2", service.getContactAtIndex(1).getContactID());
    }

    /**
     * Tests should be removes based on their ContactID
     */
    @Test
    public void removalOfContact() {
        //Retrieve instance of contactService
        ContactService service = ContactService.getContactService();

        //Add 2 contacts to contact service
        service.addContact("Gordon", "Freeman", "0123456789", "Black Mesa Laboratories");
        service.addContact("Alex", "Vance", "0123456789", "NA");
        
        //call delete contact and ensure deletion
        service.deleteContact("2");
        assertEquals(null, service.getContact("2"));

        service.deleteContact("1");
        assertEquals(null, service.getContact("1"));
    }


    /////////////////////
    //Attribute Updates//
    /////////////////////

    @Test
    public void updateFirstName(){
        //Retrieve instance of contactService
        ContactService service = ContactService.getContactService();

        //Add 2 contacts to contact service
        service.addContact("Gordon", "Freeman", "0123456789", "Black Mesa Laboratories");
        service.addContact("Alex", "Vance", "0123456789", "NA");

        //update first name and ensure updates
        service.updateFirstName("Eli", service.getContactAtIndex(0).getContactID());
        assertEquals("Eli", service.getContactAtIndex(0).getFirstName());

        service.updateFirstName("Barney", service.getContactAtIndex(1).getContactID());
        assertEquals("Barney", service.getContactAtIndex(1).getFirstName());
    }

    @Test
    public void updateLastName(){
        //Retrieve instance of contactService
        ContactService service = ContactService.getContactService();

        //Add 2 contacts to contact service
        service.addContact("Gordon", "Freeman", "0123456789", "Black Mesa Laboratories");
        service.addContact("Alex", "Vance", "0123456789", "NA");

        //update last name and ensure update
        service.updateLastName("Vance","1");
        assertEquals("Vance", service.getContactAtIndex(0).getLastName());

        service.updateLastName("Calhoun", "2");
        assertEquals("Calhoun", service.getContactAtIndex(1).getLastName());
    }

    @Test
    public void updatePhone(){
        //Retrieve instance of contactService
        ContactService service = ContactService.getContactService();

        //Add 2 contacts to contact service
        service.addContact("Gordon", "Freeman", "0123456789", "Black Mesa Laboratories");
        service.addContact("Alex", "Vance", "0123456789", "NA");

        //updates phone number and ensure update
        service.updatePhone("1111111111","1");
        assertEquals("1111111111", service.getContactAtIndex(0).getPhone());

        service.updatePhone("2222222222", "2");
        assertEquals("2222222222", service.getContactAtIndex(1).getPhone());
    }

    @Test
    public void updateAddress(){
        //Retrieve instance of contactService
        ContactService service = ContactService.getContactService();

        //Add 2 contacts to contact service
        service.addContact("Gordon", "Freeman", "0123456789", "Black Mesa Laboratories");
        service.addContact("Alex", "Vance", "0123456789", "NA");

        //Updates address and ensures update
        service.updateAddress("Wherever he chooses",service.getContactAtIndex(0).getContactID());
        assertEquals("Wherever he chooses", service.getContactAtIndex(0).getAddress());

        service.updateAddress("Black Mesa Laboratories",service.getContactAtIndex(1).getContactID());
        assertEquals("Black Mesa Laboratories", service.getContactAtIndex(1).getAddress());
    }
}