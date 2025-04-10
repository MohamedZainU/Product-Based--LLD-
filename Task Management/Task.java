import java.util.*;
public class Task{
    String taskTitle;
    String taskDesc;
    int Date;
    String priority;
    
    public Task(String taskTitle,String taskDesc,int Date,String priority){
        this.taskTitle = taskTitle;
        this.taskDesc = taskDesc;
        this.Date = Date;
        this.priority = priority;
    }
    
    public int getDate(){
        return Date;
    }
}