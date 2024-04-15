import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

import java.lang.IllegalArgumentException;

/**
 * Project: ContactService
 * Author: Jesse Peterson
 * School: SNHU
 */

public class ContactTest {

    /**
     * Create a string of chars of specified legnth
     * @param c, Character
     * @param occur, Occurance
     * @return
     */
    private String nCharString(char c, int occur) {
        String str = "";

        for(int i = 0; i < occur; i++) {
            str += c;
        }

        return str;
    }

    //////////////////////////////////
    //Tests for proper functionality//
    //////////////////////////////////

    /**
     * Tests contact ID in range 0-10
     */
    @Test
    public void contactIdInRange() {

        //For length 0-10
        for(int i = 0; i <= 10; i++) {
            //attempt to cerate contact with ID of size i
            String ID = nCharString('1', i);
            Contact contact = new Contact(ID, "Gordon", "Freeman", "0123456789", "Black Mesa Laboratories");

            assertEquals(ID, contact.getContactID());
        }

    }

    /**
     * Tests firstName in range 0-10
     */
    @Test
    public void firstNameInRange() {

        //attempt to cerate contact with firstName of size i
        for(int i = 0; i <= 10; i++) {
            String firstName = nCharString('1', i);
            Contact contact = new Contact("1", firstName, "Freeman", "0123456789", "Black Mesa Laboratories");
            assertEquals(firstName, contact.getFirstName());
        }

    }

    /**
     * Tests lastName in range 0-10
     */
    @Test
    public void lastNameInRange() {

        //attempt to cerate contact with lastName of size i
        for(int i = 0; i <= 10; i++) {
            String lastName = nCharString('1', i);
            Contact contact = new Contact("1", "Gordon", lastName, "0123456789", "Black Mesa Laboratories");
            assertEquals(lastName, contact.getLastName());
        }

    }

    /**
     * Tests phone number length 10
     */
    @Test
    public void phoneInRange() {

        //attempt to cerate contact with Phone number of size 10
        String number = "0123456789";
        Contact contact = new Contact("1", "Gordon", "Freeman", number, "Black Mesa Laboratories");
        assertEquals(number, contact.getPhone());

    }

    /**
     * Tests address in range 0-30
     */
    @Test
    public void addressInRange() {

        //attempt to cerate contact with address of size i
        for(int i = 0; i <= 30; i++) {
            String address = nCharString('1', i);
            Contact contact = new Contact("1", "Gordon", "Freeman", "0123456789", address);
            assertEquals(address, contact.getAddress());
        }

    }


    ////////////////////////////////
    //Tests setting fields to null//
    ////////////////////////////////

    @Test
    public void setFirstNameNullException() {
        //Retrieve instance of contactService
        Contact contact = new Contact("1", "1", "1", "8888888888", "1");

        //verifies that setting first name to null throws an exception
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });

        //verifies the proper exception was thrown
        Assertions.assertEquals("First name is invalid", thrown.getMessage());
    }

    @Test
    public void setLastNameNullException() {
        //Retrieve instance of contactService
        Contact contact = new Contact("1", "1", "1", "8888888888", "1");

        //verifies that setting first name to null throws an exception
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });

        //verifies the proper exception was thrown
        Assertions.assertEquals("Last name is invalid", thrown.getMessage());
    }

    @Test
    public void setPhoneNullException() {
        //Retrieve instance of contactService
        Contact contact = new Contact("1", "1", "1", "8888888888", "1");

        //verifies that setting first name to null throws an exception
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });

        //verifies the proper exception was thrown
        Assertions.assertEquals("Phone number is invalid", thrown.getMessage());
    }

    @Test
    public void setAddressNullException() {
        //Retrieve instance of contactService
        Contact contact = new Contact("1", "1", "1", "8888888888", "1");

        //verifies that setting first name to null throws an exception
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });

        //verifies the proper exception was thrown
        Assertions.assertEquals("Address is invalid", thrown.getMessage());
    }

    ///////////////////////////////////////
    //Changing variables to out of bounds//
    ///////////////////////////////////////

    @Test
    public void setFirstNameOutBounds() {
        //Retrieve instance of contactService
        Contact contact = new Contact("1", "1", "1", "8888888888", "1");

        //verifies that setting first name to null throws an exception
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("01234567890");
        });

        //verifies the proper exception was thrown
        Assertions.assertEquals("First name is invalid", thrown.getMessage());
    }

    @Test
    public void setLastNameOutBounds() {
        //Retrieve instance of contactService
        Contact contact = new Contact("1", "1", "1", "8888888888", "1");

        //verifies that setting first name to null throws an exception
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("01234567890");
        });

        //verifies the proper exception was thrown
        Assertions.assertEquals("Last name is invalid", thrown.getMessage());
    }

    @Test
    public void setPhoneLowerBound() {
        //Retrieve instance of contactService
        Contact contact = new Contact("1", "1", "1", "8888888888", "1");

        //verifies that setting first name to null throws an exception
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("01234567890");
        });

        //verifies the proper exception was thrown
        Assertions.assertEquals("Phone number is invalid", thrown.getMessage());
    }

    @Test
    public void setPhoneUpperBound() {
        //Retrieve instance of contactService
        Contact contact = new Contact("1", "1", "1", "8888888888", "1");

        //verifies that setting first name to null throws an exception
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("");
        });

        //verifies the proper exception was thrown
        Assertions.assertEquals("Phone number is invalid", thrown.getMessage());
    }

    @Test
    public void setAddressOutBounds() {
        //Retrieve instance of contactService
        Contact contact = new Contact("1", "1", "1", "8888888888", "1");

        //verifies that setting first name to null throws an exception
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("0123456789012345678901234567890");
        });

        //verifies the proper exception was thrown
        Assertions.assertEquals("Address is invalid", thrown.getMessage());
    }

}