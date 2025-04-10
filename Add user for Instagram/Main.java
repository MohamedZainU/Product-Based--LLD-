/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String s;
	    StringBuilder res = new StringBuilder();
	    while(!(s = sc.next()).equals("stop")){
	        res.append(s);
	    }
	    
	    System.out.println(res.toString());
	}
}
