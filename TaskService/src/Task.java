/**
 * Project: ContactService
 * Author: Jesse Peterson
 * School: SNHU
 */

          /* REQUIRMENTS */
///////////////////////////////////////
//1.Task ID that is unique and cannot// 
//  be longer than 10 characters and //
//  cannot be null or updatable.     //
///////////////////////////////////////
//2. Name that cannot exceed 20      //
//   characters and cannot be null   //
///////////////////////////////////////
//3. Description cannot exceed 50    //
//   characters and cannot be null   //
///////////////////////////////////////


public class Task {
    //Class fields
    private final String taskID;
    private String name;
    private String description;

    /**
     * Constructor for Task object
     * @param tID, Task ID
     * @param name, Task Name 
     * @param desc, Task Description
     */
    public Task(String tID, String name, String desc) {

        //Checks the validity of each argument
        if(tID == null || tID.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID");
        }

        if(name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }

        if(desc == null || desc.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        //assigns each of the fields
        taskID = tID;
        this.name = name;
        description = desc;
    }

    /**
     * Returns the task ID
     * @return
     */
    public String getTaskID() {
        return taskID;
    }

    /**
     * Returns the task name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the task description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Updates the task description
     * @param desc
     */
    public void setDescription(String desc) {
        //checks the validity of the argument
        if(desc == null || desc.length() > 50){
            throw new IllegalArgumentException("Description is invalid");
        }
        
        //Updates the description field
        description = desc;
    }

    /**
     * Updates the task name
     * @param name
     */
    public void setName(String name) {
        //checks the validity of the argument
        if(name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name is invalid");
        }

        //Updates the name field
        this.name = name;
    }
}