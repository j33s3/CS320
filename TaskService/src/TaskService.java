/**
 * Project: ContactService
 * Author: Jesse Peterson
 * School: SNHU
 */

 import java.util.List;
 import java.util.ArrayList;
 import java.util.Iterator;

     /* REQUIRMENTS */
///////////////////////////
//1. must be able to add //
//   tasks with unique ID//
///////////////////////////
//2. Delete tasks based  //
//   on task ID          //
///////////////////////////
//3. update task Name and// 
//   Description based on// 
//   task ID             //
///////////////////////////

public class TaskService {

    //creates an instance of TaskService class
    private static TaskService instance = new TaskService();

    //Array list for storing task objects
    private static List<Task> tasks = new ArrayList<Task>();

    //Integer for holding next ID
    private static int nextTaskID = 1;

    /**
     * Private Constructor for preventing additionall instances
     */
    private TaskService() {

    }

    /**
     * Returns the one and only instance of TaskService
     * @return TaskService
     */
    public static TaskService getIntance() {
        return instance;
    }

    /**
     * Creates and add task to the array list
     * @param name, Task name
     * @param description, Task Description
     * @return Created task
     */
    public Task addTask(String name, String description) {
        //Attempts to create new task with new ID
            Task task;
        try{
            task = new Task(String.valueOf(getTaskID()), name, description);

            if(getTask(String.valueOf(task.getTaskID())) != null) {
                throw new IllegalArgumentException("Task ID is the same");
            }
        }
        //if containing improper arguments then catch exception
        catch(Exception IllegalArgumentException){
            System.out.println(IllegalArgumentException.getMessage());
            return null;
        }
        

        //add and return created task
        tasks.add(task);
        return task;
    }

    /**
     * Adds a task to the array list using task objects
     * @param task, task object
     * @return task, the task object added to the list
     */
    public Task addTask(Task task) {
            if(getTask(String.valueOf(task.getTaskID())) != null) {
                throw new IllegalArgumentException("Task ID is the same");
            }

        tasks.add(task);
        return task;
    }

    /**
     * deletes a task from the array list
     * @param taskID
     * @return Deleted Task
     */
    public Task deleteTask(String taskID) {
        Iterator<Task> iterator = tasks.iterator();

        //search the entire array list for a matching task
        while(iterator.hasNext()) {
            Task curTask = iterator.next();
            //if a match is found remove the task and return it
            if(curTask.getTaskID().equals(taskID)) {
                iterator.remove();
                return curTask;
            }
        }
        return null;
    }

    /**
     * Update task name based on specific task ID
     * @param taskID, task to look for
     * @param name, name to change to
     */
    public void updateTaskName(String taskID, String name) {
        //retrieve task
        Task task = getTask(taskID);

        //if the task doesn't exist
        if(task == null) {
            System.out.println("Task not found");
            return;
        }

        //try to change the name
        try{
            task.setName(name);
        }
        //if argument was invalid then catch the exception
        catch(Exception IllegalArgumentException) {
            System.out.println(IllegalArgumentException.getMessage());
        }
    }

    /**
     * Update task description based on specific task ID
     * @param taskID, task to look for
     * @param description, description to change to
     */
    public void updateTaskDescription(String taskID, String description) {
        //retrieve task
        Task task = getTask(taskID);

        //if the task does not exist
        if(task == null) {
            System.out.println("Task not found");
            return;
        }

        //try to change the description
        try{
            task.setDescription(description);
        }
        //if the argument was invalid catch the exception
        catch(Exception IllegalArgumentException) {
            System.out.println(IllegalArgumentException.getMessage());
        }
    }

    /**
     * Retrieve task from the list based on task ID
     * @param taskID, Task ID to look for
     * @return
     */
    public Task getTask(String taskID) {
        Iterator<Task> iterator = tasks.iterator();

        //While there are more tasks in array list
        while(iterator.hasNext()) {
            Task curTask = iterator.next();
            //if match was found return the task
            if(curTask.getTaskID().equals(taskID)) {
                return curTask;
            }
        }
        return null;
    } 

    /**
     * Retrieve task based on index in the array list
     * @param index
     * @return, task at index
     */
    public Task getTaskAtIndex(int index) {
        return tasks.get(index);
    }


    /**
     * retrieve and increment task ID
     * @return
     */
    private int getTaskID() {
        return nextTaskID++;
    }


}