/**
 * Project: ContactService
 * Author: Jesse Peterson
 * School: SNHU
 */
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

import java.lang.IllegalArgumentException;

 public class TaskTest {

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

    //////////////////////////////
    //Tests Proper Functionality//
    //////////////////////////////

    /**
     * Tests taskId in range 0-10
     */
    @Test
    public void taskIdInRange() {

        //For legnth 0-10
        for(int i = 0; i <= 10; i++) {
            //Attempt to create task with object id at length i
            String ID = nCharString('1', i);
            Task task = new Task(ID, "Find Eli Vance", "Hi how are you?");
            assertEquals(ID, task.getTaskID());
        }

    }

    /**
     * Tests task name in range 0-20
     */
    @Test
    public void nameInRange() {

        //For length of 0-20
        for(int i = 0; i <= 20; i++) {
            //Attempt to create task object with name at length i
            String name = nCharString('1', i);
            Task task = new Task("1", name, "Hi how are you?");
            assertEquals(name, task.getName());
        }

    }

    /**
     * Tests description in range 0-50
     */
    @Test
    public void descriptionInRange() {

        //For length of 0-50
        for(int i = 0; i <= 50; i++) {
            //Attempt to create task object with description at length i
            String desc = nCharString('1', i);
            Task task = new Task("1", "Find Eli Vance", desc);
            assertEquals(desc, task.getDescription());

        }

    }


    ///////////////////////////////
    //Test setting fields to null//
    ///////////////////////////////
    
    /**
     * Checks for exception when Contact ID is null
     */
    @Test
    public void setContactIDNullException() {

        //attempts to create new task when id is null
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Find G-Man", "Locate the G-Man for questioning");
        });

        //checks proper exception was thrown
        assertEquals("Invalid task ID", thrown.getMessage());

    }

    /**
     * Checks for exception when name is null
     */
    @Test
    public void setNameNullException() {

        //attempts to create a task object when name is null
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", null, "Locate the G-Man for questioning");
        });

        //checks proper exception was thrown
        assertEquals("Invalid name", thrown.getMessage());

    }

    /**
     * Checks for exception when description is null
     */
    @Test
    public void setDescriptionNullException() {

        //Attempts to create a task object when description is null
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "Find G-Man", null);
        });

        //checks proper exception was thrown
        assertEquals("Invalid description", thrown.getMessage());
    }

    /////////////////////////////////////
    //Test setting fields out of bounds//
    /////////////////////////////////////


    /**
     * Checks for exception when id is out of bounds
     */
    @Test
    public void setTaskIdOutOfBounds() {

        //Attempts to create a task object when id is out of bounds
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("01234567890", "Find G-Man", ":Locate the G-Man for questioning");
        });

        //checks proper exception was thrown
        assertEquals("Invalid task ID", thrown.getMessage());

    }

    /**
     * Checks for exception when name is out of bounds
     */
    @Test
    public void setNameOutOfBounds() {

        //Attempts to create task object when name is out of bounds
        IllegalArgumentException thrown  = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "012345678901234567890", "Locate the G-Man for questioning");
        });

        //checks proper exception was thrown
        assertEquals("Invalid name", thrown.getMessage());

    }

    /**
     * Checks for exception when description is out of bounds
     */
    @Test
    public void setDescriptionOutOfBounds() {

        //Attempts to create task object when description is out of bounds
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "Find G-Man",
            "012345678901234567890123456789012345678901234567890");
        });

        //checks proper exception was thrown
        assertEquals("Invalid description", thrown.getMessage());

    }

 }