/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
	public static void main(String[] args) {
		String s = "12345";
		int n = (int) s.length()/2;
		int lsum=0,rsum=0;
		
		for(int i=0;i<n;i++){
		    lsum+= (int) s.charAt(i);
		}
		
		if(s.length()%2!=0){
		
		for(int i=n+1;i<s.length();i++){
		    rsum+= (int) s.charAt(i);
		}
		
		}else{
		    for(int i=n;i<s.length();i++){
		    rsum += (int) s.charAt(i);
		    }
		}
		
		if(lsum==rsum){
		    System.out.println("True");
		}else{
		    System.out.println("False");
		}
	}
}
