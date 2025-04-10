/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
    
    static Scanner sc = new Scanner(System.in);
    
    static ArrayList<Post> postDetails = new ArrayList<>();
    
    
    public static void viewAll(){
        int id = 1;
        for(Post p:postDetails){
            System.out.println((id++)+". "+p.postHead);
        }
        int choiceOfPost = sc.nextInt();
        Post p1 = postDetails.get(choiceOfPost-1);
        System.out.println(p1.postContent);
        
        if(p1.comment.isEmpty()){
            System.out.println("No Comments !");
        }else{
            for(String s:p1.comment){
                System.out.println(s);
            }
        }
        
        
        System.out.println("Add Comment");
        String commentOnPost = sc.next();
        p1.comment.add(commentOnPost);
    }
    
    public static void create(){
        System.out.println("Enter Post Heading");
        String postHead = sc.next();
        System.out.println("Enter Post Content");
        String postContent = sc.next();
        Post post = new Post(postHead,postContent);
        postDetails.add(post);
    }
    
    
    
	public static void main(String[] args) {
		boolean isTrue = true;
		while(isTrue){
		    System.out.println("1-> Create");
		    System.out.println("2-> View");
		    System.out.println("3-> View All");
		    int choiceOf = sc.nextInt();
		    if(choiceOf==1){
		        create();
		    }else if(choiceOf==2){
		        continue;
		    }else if(choiceOf==3){
		        viewAll();
		    }else{
		        isTrue = false;
		    }
		}
	}
}
