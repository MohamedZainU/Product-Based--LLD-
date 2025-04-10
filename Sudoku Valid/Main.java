/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/


// we only pass one value in all row col box 
// in isRow isCol isBox methods carefully see how the steps inside loop
//int num = grid[row][i];
            // if(num!=0){
            //     if(seen[num-1]){
            //         return false;
            //     }
            //     seen[num-1] = true;
            // }

public class Main
{
    
    public static boolean isValidSudoku(int[][] board){
        for(int i=0;i<9;i++){
            if(!isValidRow(board,i) || !isValidCol(board,i) || !isValidBox(board,i)){
                return false;
            }
        }
        return true;
    }
    
    
    public static boolean isValidRow(int[][] board,int row){
        boolean seen[] = new boolean[9];
        for(int col=0;col<9;col++){
            int num = board[row][col];
            if(num!=0){
                if(seen[num-1]){
                    return false;
                }
                seen[num-1] = true;
            }
        }
        return true;
    }
    
    public static boolean isValidCol(int[][] board,int col){
        boolean seen[] = new boolean[9];
        for(int row=0;row<9;row++){
            int num = board[row][col];
            if(num!=0){
                if(seen[num-1]){
                    return false;
                }
                seen[num-1] = true;
            }
        }
        return true;
    }
    
    
    public static boolean isValidBox(int[][] board,int box){
        boolean seen[] = new boolean[9];
        int rowBox = (box/3)*3;
        int colBox = (box%3)*3;
        
        
        for(int i=rowBox;i<rowBox+3;i++){
            for(int j=colBox;j<colBox+3;j++){
                int num = board[i][j];
                if(num!=0){
                    if(seen[num-1]){
                        return false;
                    }
                    seen[num-1] = true;
                }
            }
        }
        return true;
    }
    
	public static void main(String[] args) {
		int[][] puzzle = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (isValidSudoku(puzzle)) {
            System.out.println("Valid Sudoku!");
        } else {
            System.out.println("Invalid Sudoku!");
        }
	}
}
