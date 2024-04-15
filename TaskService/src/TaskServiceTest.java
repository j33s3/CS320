import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runners.MethodSorters;

/**
 * Project: ContactService
 * Author: Jesse Peterson
 * School: SNHU
 */

@FixMethodOrder(MethodSorters.JVM)
 public class TaskServiceTest {
    
    /**
     * Tests adding a task with a unique ID
     */
    @Test
    public void addTaskWithUniqueID() {
        TaskService service = TaskService.getIntance();

        //Adds task to the arrayList
        service.addTask("Find G-Man", "Locate the G-Man for Questioning");
        service.addTask("Free Eli", "Free Eli Vance from combine posession");

        //ensures the taskIDs are different
        assertEquals("1", service.getTaskAtIndex(0).getTaskID());
        assertEquals("Find G-Man", service.getTask("1").getName());

        assertEquals("2", service.getTaskAtIndex(1).getTaskID());
        assertEquals("Free Eli", service.getTask("2").getName());

    }

    /**
     * Tests updating the task name based on ID
     */
    @Test
    public void updateNameFromID() {
        TaskService service = TaskService.getIntance();

        //Changes the task name for task with ID of 1
        service.updateTaskName("1", "Free Vortigaunt");
        assertEquals("Free Vortigaunt", service.getTaskAtIndex(0).getName());

        //Changed the task name for task with ID of 2
        service.updateTaskName("2", "Escape \"Jeff\"");
        assertEquals("Escape \"Jeff\"", service.getTaskAtIndex(1).getName());
    }

    /**
     * Tests updating the task description based on ID
     */
    @Test
    public void updateDescriptionFromID() {
        TaskService service = TaskService.getIntance();

        //updates the description for task with ID of 5
        service.updateTaskDescription("1", "Free the Vortigaunt at the Northern Star");
        assertEquals("Free the Vortigaunt at the Northern Star", service.getTaskAtIndex(0).getDescription());

        //updates the description for task with ID of 6
        service.updateTaskDescription("2", "Escape the blind zombie \"Jeff\"");
        assertEquals("Escape the blind zombie \"Jeff\"", service.getTaskAtIndex(1).getDescription());
    }

    /**
     * Tests deleting a task based on ID
     */
    @Test
    public void deleteTaskUsingID() {
        TaskService service = TaskService.getIntance();

        //Deletes task with an ID of 2
        service.deleteTask("2");
        assertEquals(null, service.getTask("2"));

        //Deletes task with an ID of 1
        service.deleteTask("1");
        assertEquals(null, service.getTask("1"));
    }

    /**
     * If Task IDs have the same ID then throw exception
     */
    @Test
    public void tasksWithSameID() {
        TaskService service = TaskService.getIntance();

        Task task1 = new Task("10", "Eli Vance", "Free Eli Vance from combine posession");
        Task task2 = new Task("10", "Eli Vance", "Free Eli Vance from Combine Posession");

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task1);
            service.addTask(task2);
        });

        Assertions.assertEquals(thrown.getMessage(), "Task ID is the same");

    }
 }