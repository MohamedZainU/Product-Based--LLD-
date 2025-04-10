/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/


import java.util.*;
public class Main
{
    static Scanner sc = new Scanner(System.in);
    
    static ArrayList<Task> taskDetails = new ArrayList<>();
    
    static HashMap<String,User> map = new HashMap<>();
    
    
    public static void sort(User user) {
        List<Task> userTasks = user.taskList;
        userTasks.sort(Comparator.comparing(Task::getDate));
    }
    
    
    public static void viewTask(){
        System.out.println("Enter User Name");
        String nameTocheck = sc.next();
        User user = map.get(nameTocheck);
        sort(user);
        for(Task task:user.taskList){
            System.out.println("-----------------------");
            System.out.println("Title "+task.taskTitle);
            System.out.println("Description "+task.taskDesc);
            System.out.println("Date "+task.Date);
            System.out.println("Priority "+task.priority);
            System.out.println("-----------------------");
        }
    }
    
    
    public static void updateTask(){
        System.out.println("Enter Title of Task To Upadte");
        String taskToChange = sc.next();
        
        for(Task task:taskDetails){
            if(task.taskTitle.equals(taskToChange)){
                System.out.println("Enter New Title");
                String newTask = sc.next();
                System.out.println("Enter Description");
                String newDesc = sc.next();
                System.out.println("Enter Due Date");
                int dueDate = sc.nextInt();
                System.out.println("Enter Priority ");
                String priorityNew = sc.next();
                task.taskTitle = newTask;
                task.taskDesc = newDesc;
                task.Date = dueDate;
                task.priority = priorityNew;
            }
        }
    }
    
    
    public static void assignTask(){
        System.out.println("Enter User Name");
        String userName = sc.next();
        System.out.println("Enter the Task");
        String taskAssign = sc.next();
        User userCheck = map.get(userName);
        if(userCheck!=null){
            for(Task task:taskDetails){
            if(task.taskTitle.equals(taskAssign)){
                userCheck.taskList.add(task);
            }
        }
        }else{
        User user = new User(userName);
        for(Task task:taskDetails){
            if(task.taskTitle.equals(taskAssign)){
                user.taskList.add(task);
            }
        }
        map.put(userName,user);
        }
    }
    
    public static void createTask(){
        System.out.println("Enter Title for Task");
        String taskTitle = sc.next();
        System.out.println("Enter Task Description");
        String taskDesc = sc.next();
        System.out.println("Enter Due Date");
        int Date = sc.nextInt();
        System.out.println("Enter priority Status");
        String priority = sc.next();
        Task task = new Task(taskTitle,taskDesc,Date,priority);
        taskDetails.add(task);
    }
    
    
	public static void main(String[] args) {
		boolean isTrue = true;
		
		while(isTrue){
		    System.out.println("1-> Create Task");
		    System.out.println("2-> Assign Task");
		    System.out.println("3-> Update Task");
		    System.out.println("4-> View Task");
		    int choiceOf = sc.nextInt();
		    if(choiceOf==1){
		        createTask();
		    }else if(choiceOf==2){
		        assignTask();
		    }else if(choiceOf==3){
		        updateTask();
		    }else if(choiceOf==4){
		        viewTask();
		    }else{
		        isTrue = false;
		    }
		}
	}
}
