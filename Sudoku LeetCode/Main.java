/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

//remember the box loop i marked see and in found method atlast return null

import java.util.*;

public class Main
{
    
    
    public static boolean solve(int[][] grid){
        int findEmpty[] = found(grid);
        
        if(findEmpty==null){
            return true;
        }
        
        int row = findEmpty[0];
        int col = findEmpty[1];
        
        for(int num=1;num<=9;num++){
            if(isSafe(grid,row,col,num)){
                grid[row][col] = num;
                
                if(solve(grid)){
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }
    
    
    public static boolean isSafe(int[][] grid,int row,int col,int num){
        for(int i=0;i<9;i++){
            if(grid[i][col]==num || grid[row][i]==num){
                return false;
            }
        }
        
        int rowNew = row - row%3; //
        int colNew = col - col%3; //
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){ //
                if(grid[rowNew+i][colNew+j]==num){ //
                    return false;
                }
            }
        }
        return true;
    }
    
    
    public static int[] found(int[][] grid){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(grid[i][j]==0){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    
    public static void print(int[][] grid){
        for(int[] row:grid){
            for(int cell:row){
                System.out.print(cell+",");
            }
            System.out.println();
        }
    }
    
    
    
	public static void main(String[] args) {
		int grid[][] = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                         {5, 2, 0, 0, 0, 0, 0, 0, 0},
                         {0, 8, 7, 0, 0, 0, 0, 3, 1},
                         {0, 0, 3, 0, 1, 0, 0, 8, 0},
                         {9, 0, 0, 8, 6, 3, 0, 0, 5},
                         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
                         {1, 3, 0, 0, 0, 0, 2, 5, 0},
                         {0, 0, 0, 0, 0, 0, 0, 7, 4},
                         {0, 0, 5, 2, 0, 6, 3, 0, 0}};
                         
                         if(solve(grid)){
                             print(grid);
                         }else{
                             System.out.println("No Solution !");
                         }
	}
}
