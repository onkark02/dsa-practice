package practice.machinecoding.game;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int[][] board;
    private final int winningScore;

    public Board(int n){
        if(n < 2)
            throw new IllegalArgumentException("Please provide valid number");
        board = new int[n][n];
        winningScore = 256;
    }

    public void printBoard(){
        for(int row=0; row< board.length; row++){
            System.out.print("\n");
            for(int col=0; col<board.length; col++){
                System.out.print(board[row][col]!=0?board[row][col]:"-");
                System.out.print("\t");
            }
        }
    }

    public int getSize(){
        return board.length;
    }

    public int isGameOver(){
        //Check if game won
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board.length;j++){
                if(board[i][j] >= winningScore){
                    return 1;
                }
            }
        }

        //Check if game is lost
        for(int i=0; i<board.length-1; i++){
            for(int j=0; j<board.length-1;j++){
                //Checking if board can be reduced or not
                if(board[i][j] ==0 || board[i][j] == board[i+1][j] || board[i][j] == board[i][j+1])
                    return 0;
            }
        }

        //Game is lost
        return -1;
    }

    public int[][] getBoard(){
        return board;
    }

    public void addTile(){
        List<Integer> zeros = new ArrayList<>();
        //Add all zero fields
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board.length;j++){
                if(board[i][j] == 0){
                    zeros.add(i*board.length + j);
                }
            }
        }
        if(!zeros.isEmpty()){
            //Choose random number to fill
            int randomIndex = (int) (Math.random() * zeros.size());
            board[zeros.get(randomIndex)/board.length][zeros.get(randomIndex)%board.length] = 2;
        }

    }
}
