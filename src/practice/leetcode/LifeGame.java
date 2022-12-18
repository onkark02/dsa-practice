package practice.leetcode;

import java.util.Stack;

class LifeGame {
    public static void main(String[] args) {
        LifeGame lifeGame = new LifeGame();
        int[][] board = {{1,0,0,0,0,1},{0,0,0,1,1,0},{1,0,1,0,1,0},{1,0,0,0,1,0},{1,1,1,1,0,1},{0,1,1,0,1,0},{1,0,1,0,1,1},{1,0,0,1,1,1},{1,1,0,0,0,0}};
        lifeGame.gameOfLife(board);
        System.out.println("");
    }
    public void gameOfLife(int[][] board) {
        /*  Populate given array where
            board[i][j] = count of neighbours (- if board[i][j] was 0, + otherwise)
        */
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                int count = getNeighbourCount(board,i,j);
                if(board[i][j]==0){
                    board[i][j] -= count;
                }else if(count!=0){
                    board[i][j] = count;
                }
            }
        }

         for(int i=0; i<board.length; i++){
             for(int j=0; j<board[i].length; j++){
                 if(board[i][j]==2 || board[i][j]==3 || board[i][j]==-3)
                     board[i][j] = 1;
                 else
                     board[i][j] = 0;
             }
         }
    }

    private int getNeighbourCount(int[][] board, int i, int j){
        int count = 0;
        if(i>0){
            if(j>0 && board[i-1][j-1]>0)
                count++;
            if(board[i-1][j]>0)
                count++;
            if(j<board[i].length-1 && board[i-1][j+1]>0)
                count++;
        }
        if(i<board.length-1){
            if(j>0 && board[i+1][j-1]>0)
                count++;
            if(board[i+1][j]>0)
                count++;
            if(j<board[i].length-1 && board[i+1][j+1]>0)
                count++;
        }
        if(j>0 && board[i][j-1]>0)
            count++;
        if(j<board[i].length-1 && board[i][j+1]>0)
            count++;
        return count;
    }
}