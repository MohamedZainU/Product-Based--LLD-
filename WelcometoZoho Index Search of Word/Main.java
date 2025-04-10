/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
    
    public static List<int[]> solve(char[][] grid,String word){
        List<int[]> out = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==word.charAt(0) && search(0,i,j,grid,word,out)){
                    return out;
                }
            }
        }
        return out;
    }
    
    public static boolean search(int index,int row,int col,char[][] grid,String word,List<int[]> out){
        if(index==word.length()){
            int start[] = {row-index,col}; //Rememeber you forgot to create start[] and end[] you instead added diectly 
            int end[] = {row-1,col};
            out.add(start);
            out.add(end);
            return true;
        }
        
        if(row<0 || row>=grid.length || col<0 || col>=grid[row].length || word.charAt(index)!=grid[row][col]){
            return false;
        }
        
        char store = grid[row][col];
        grid[row][col] = '#';
        
        boolean found = search(index+1,row+1,col,grid,word,out) ||
                        search(index+1,row-1,col,grid,word,out) ||
                        search(index+1,row,col+1,grid,word,out) ||
                        search(index+1,row,col-1,grid,word,out) ||
                        search(index+1,row+1,col+1,grid,word,out) ||
                        search(index+1,row+1,col-1,grid,word,out) ||
                        search(index+1,row-1,col-1,grid,word,out) ||
                        search(index+1,row-1,col+1,grid,word,out);
                        
        
        grid[row][col] = store;                
                        
        return found;                
    }
    
	public static void main(String[] args) {
		char[][] grid = {
            { 'W', 'E', 'L', 'C', 'O' },
            { 'M', 'E', 'T', 'O', 'Z' },
            { 'O', 'H', 'O', 'C', 'O' },
            { 'R', 'P', 'O', 'R', 'A' },
            { 'T', 'I', 'O', 'N', 'S' }
        };
        
        String word = "TO";
        
        List<int[]> res = solve(grid,word);
        
        System.out.println(Arrays.toString(res.get(0)));
        System.out.println(Arrays.toString(res.get(1)));
	}
}
