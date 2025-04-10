import java.util.*;
public class User{
    String name;
    List<Task> taskList;
    
    public User(String name){
        this.name = name;
        this.taskList = new ArrayList<>();
    }
}