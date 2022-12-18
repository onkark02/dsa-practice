package com.coursera.algo1.week4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Board {

    private final int[][] board;
    private final int dimension;
    private final int hammingDistance, manhattanDistance;
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles){
        if(tiles.length <2 || tiles.length > 128){
            throw new IllegalArgumentException();
        }
        if(tiles.length != tiles[0].length){
            throw new IllegalArgumentException();
        }
        board = new int[tiles.length][tiles[0].length];
        dimension = board.length;
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                board[i][j]=tiles[i][j];

        //Calculate and save distances to instance var
        hammingDistance = calculateHammingDistance();
        manhattanDistance = calculateManhattanDistance();
    }

    // string representation of this board
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(dimension +System.lineSeparator());
        for(int i = 0; i< dimension; i++) {
            for (int j = 0; j < dimension; j++)
                output.append(" " + board[i][j]);
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

   // board dimension n
    public int dimension(){
        return dimension;
    }

    private int calculateHammingDistance(){
        int hammingDistance = 0;
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                if (board[i][j] != getGoalNumber(i, j))
                    hammingDistance++;
        if(board[dimension -1][dimension -1] != 0)
            hammingDistance--;
        return hammingDistance;
    }
        // number of tiles out of place
        public int hamming() {
            return this.hammingDistance;
        }

        private int calculateManhattanDistance(){
            int manhattanDistance = 0;
            for (int i = 0; i < dimension; i++)
                for (int j = 0; j < dimension; j++)
                    manhattanDistance += getManhattanDistance(i,j);
            return manhattanDistance;
        }
            // sum of Manhattan distances between tiles and goal
            public int manhattan(){
                return this.manhattanDistance;
            }

    // is this board the goal board?
    public boolean isGoal() {
        for (int i = 0; i< dimension; i++)
            for (int j = 0; j< dimension; j++) {
                if(board[i][j] != getGoalNumber(i,j))
                    return false;
            }
        return true;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (!(y instanceof Board))
            return false;
        Board that = (Board) y;
        if (this.dimension == that.dimension) {
            for (int i = 0; i < dimension; i++)
                for (int j = 0; j < dimension; j++)
                    if (this.board[i][j] != that.board[i][j])
                        return false;
        }else{
            return false;
        }
        return true;
    }

    private int getGoalNumber(int i, int j){
        if(i== j && i == dimension -1)
            return 0;
        return i* dimension + j +1;
    }

    private int getManhattanDistance(int i, int j){
        if(board[i][j]==0)
            return 0;

        int val = board[i][j] - 1;
        int x = val/ dimension;
        int y = val% dimension;

        return Math.abs(i - x) + Math.abs(j-y);
    }

    // all neighboring boards
    public Iterable<Board> neighbors(){
        return new BoardIterable();
    }
    private class BoardIterable implements Iterable<Board>{

        @Override
        public Iterator<Board> iterator() {
            return new BoardItertor();
        }

        private class BoardItertor implements Iterator<Board> {
            int blankX, blankY;
//            MinPQ<Integer> iterationsPQ;
            List<Integer> iterationsList;
            BoardItertor(){
                for (int i = 0; i < dimension; i++)
                    for (int j = 0; j < dimension; j++)
                        if(board[i][j] == 0){
                            blankX=i;
                            blankY=j;
                        }

//                iterationsPQ = new MinPQ<>();
                iterationsList=new ArrayList<>();
                for (int i=1; i<=4; i++) {
                    if(isValid(i)){
//                        iterationsPQ.insert(i);
                        iterationsList.add(i);
                    }
                }
            }
            @Override
            public boolean hasNext() {
                return !iterationsList.isEmpty();
            }

            @Override
            public Board next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                int[][] iteratorArray=new int[dimension][dimension];
                for (int i = 0; i < dimension; i++)
                    for (int j = 0; j < dimension; j++){
                        iteratorArray[i][j]=board[i][j];
                    }
                int tileX=blankX, tileY=blankY;
//                int move = iterationsPQ.delMin();
                int move = iterationsList.remove(0);
                switch (move){
                    case 4:
                        tileX = blankX-1;
                        break;
                    case 3:
                        tileY = blankY + 1;
                        break;
                    case 2:
                        tileX = blankX +1;
                        break;
                    case 1:
                        tileY = blankY -1;
                        break;
                }
                int temp = iteratorArray[blankX][blankY] ;
                iteratorArray[blankX][blankY] = iteratorArray[tileX][tileY];
                iteratorArray[tileX][tileY] = temp;

                return new Board(iteratorArray);
            }
            public void remove() {
                throw new UnsupportedOperationException("Remove operation not allowed");
            }

            private boolean isValid(int i){
                switch(i){
                    case 4:
                        return blankX > 0;
                    case 3:
                        return blankY < dimension -1;
                    case 2:
                        return blankX < dimension -1;
                    case 1:
                        return blankY >0;
                }
                return false;
            }
        }
    }
    // a board that is obtained by exchanging any pair of tiles
/*    public Board twin(){
        int[][] tempArray = new int[dimension][dimension];
        int swapCandidate1=0, swapCandidate2=0;
        do {
            swapCandidate1 = StdRandom.uniform(0, dimension * dimension);
        }while (isTile(swapCandidate1));
        do{
            swapCandidate2 = StdRandom.uniform(0, dimension * dimension);
        }while (swapCandidate1 == swapCandidate2 || isTile(swapCandidate2));

        for (int i = 0; i< dimension; i++)
            for (int j = 0; j< dimension; j++)
                tempArray[i][j] = board[i][j];

         int temp = tempArray[swapCandidate1/ dimension][swapCandidate1 % dimension] ;
        tempArray[swapCandidate1/ dimension][swapCandidate1 % dimension] = tempArray[swapCandidate2/ dimension][swapCandidate2 % dimension];
        tempArray[swapCandidate2/ dimension][swapCandidate2 % dimension] = temp;

        return new Board(tempArray);
    }*/
// a board that is obtained by exchanging any pair of tiles
public Board twin(){
    int[][] tempArray = new int[dimension][dimension];
    int x1=-1,y1=-1,x2=-1,y2=-1;
    for (int i = 0; i< dimension; i++)
        for (int j = 0; j< dimension; j++) {
            tempArray[i][j] = board[i][j];
            if(tempArray[i][j] != 0){
                if(x1<0){
                    x1=i;
                    y1=j;
                }else{
                    if(x2<0){
                        x2=i;
                        y2=j;
                    }
                }
            }
        }

    int temp = tempArray[x1][y1] ;
    tempArray[x1][y1] = tempArray[x2][y2];
    tempArray[x2][y2] = temp;

    return new Board(tempArray);
}


    private boolean isTile(int n){
        return board[n/ dimension][n% dimension]==0;
    }
    // unit testing (not graded)

    public static void main(String[] args){
        int[][] array = new int[3][3];

        Board board = new Board(array);
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++)
                array[i][j] = i*array.length+j+1;
        array[array.length-1][array.length-1]=0;
        Board board1=new Board(array);
        System.out.println(board.equals(board1));
        System.out.println(board.isGoal());
        System.out.println(board1.isGoal());
        System.out.println(board.hamming());
        System.out.println(board1.hamming());
        System.out.println("____________Manhattan___________");
        System.out.println(board.manhattan());
        System.out.println(board1.manhattan());

        array = new int[][]{{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};

        Board board2 = new Board(array);
        System.out.println(board2.hamming());
        System.out.println(board2.manhattan());

        System.out.println("boards:-----------------");
        System.out.println(board2);
/*        System.out.println(board2.twin());
        System.out.println(board2.twin());*/
        for (Board neighbour:
             board2.neighbors()) {
            System.out.println(neighbour);
        }
    }
}
