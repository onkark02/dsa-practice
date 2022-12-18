package practice.leetcode;

import java.util.Arrays;

public class SudokuChecker {

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        SudokuChecker sc = new SudokuChecker();
        System.out.println(sc.isValidSudoku(board));
    }
    public boolean isValidSudoku(char[][] board) {
        boolean[] digits = new boolean[board.length+1];
        //Check all rows
        for(int i=0; i < board.length; i++){
            resetArray(digits);
            for(int j=0; j <board.length; j++){
                int value = getInt(board[i][j]);
                if(value == -1)
                    continue;
                if(digits[value])
                    return false;
                else
                    digits[value] = true;
            }

        }

        //Check all columns
        for(int i=0; i < board.length; i++){
            resetArray(digits);
            for(int j=0; j <board.length; j++){
                int value = getInt(board[j][i]);
                if(value == -1)
                    continue;
                if(digits[value])
                    return false;
                else
                    digits[value] = true;
            }

        }

        //Check all 3 by 3 blocks
        for(int blockRow=0; blockRow<3; blockRow++){
            for(int blockCol=0; blockCol<3; blockCol++){
                resetArray(digits);
                for(int i=3*blockRow; i<3*(blockRow+1); i++){
                    for(int j=3*blockCol; j<3*(blockCol+1); j++){
                        int value = getInt(board[j][i]);
                        if(value == -1)
                            continue;
                        if(digits[value])
                            return false;
                        else
                            digits[value] = true;
                    }
                }

            }
        }
        return true;
    }

    private void resetArray(boolean[] arr){
        Arrays.fill(arr, false);
    }
    private int getInt(char c){

        if(c == '.'){
            return -1;
        }else{
            return c - 48;
        }

    }
}
