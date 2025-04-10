import java.util.*;
public class Post{
    String postHead;
    String postContent;
    List<String> comment;
    
    public Post(String postHead,String postContent){
        this.postHead = postHead;
        this.postContent = postContent;
        this.comment = new ArrayList<>();
    }
}