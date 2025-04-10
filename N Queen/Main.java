/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/


//we don't need 2 loops in solve method itself we take col in solve method we only loop for row and pass
//row col values in isSafe then in checking col>=grid.length in solve then in isSafe 0 to col one loop
//inside we will check grid[row][i]==1 and so on we check grid[][]==1 means false

public class Main
{
    public static boolean solve(int[][] grid,int col){
        int n = grid.length;
        if(col>=n){
            return true;
        }
        
        for(int row=0;row<n;row++){
            if(isSafe(grid,row,col)){
                grid[row][col] = 1;
                if(solve(grid,col+1)){
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }
    
    public static boolean isSafe(int[][] grid,int row,int col){
        int n = grid.length;
        for(int i=0;i<col;i++){
            if(grid[row][i]==1){
                return false;
            }
        }
        
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(grid[i][j]==1){
                return false;
            }
        }
        
        for(int i=row,j=col;i<n && j>=0;i++,j--){
            if(grid[i][j]==1){
                return false;
            }
        }
        return true;
    }
    
    
	public static void main(String[] args) {
	    int n = 4;
		int grid[][] = new int[n][n];
		solve(grid,0);
		
		for(int[] row:grid){
		    for(int cell:row){
		        System.out.print((cell==1) ? "Q " : ". ");
		    }
		    System.out.println();
		}
	}
}
