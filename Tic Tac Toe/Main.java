/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
    public static void printBoard(char board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
    }
    
    public static boolean haveWon(char board[][],char player){
        for(int row=0;row<board.length;row++){
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }
        }
        
        
        for(int col=0;col<board[0].length;col++){
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
                return true;
            }
        }
        
        
        if(board[0][0] == player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        
        if(board[0][2] == player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;
    }
    
	public static void main(String[] args) {
		char board[][] = new char[3][3];
		
		for(int i=0;i<board.length;i++){
		    for(int j=0;j<board[i].length;j++){
		        board[i][j] = ' ';
		    }
		}
		
		char player = 'X';
		
		Scanner sc = new Scanner(System.in);
		boolean isOver = false;
		
		while(!isOver){
		    printBoard(board);
		    System.out.println("Player "+player+" enter:");
		    int row = sc.nextInt();
		    int col = sc.nextInt();
		    if(board[row][col]==' '){
		        board[row][col] = player;
		        isOver = haveWon(board,player);
		        if(isOver){
		            System.out.println(player+" has won");
		        }else{
		            player = (player=='X') ? 'O' : 'X';
		        }
		    }else{
		        System.out.println("Invalid move");
		    }
		    
		}
		printBoard(board);
	}
}
