package practice.leetcode;


public class GameOfLife {

    public static void main(String[] args) {
        GameOfLife solution = new GameOfLife();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        solution.gameOfLife(board);
    }

    /*
    Represent changed state of a cell by a different value intermediately
    eg. Let 2 represent 0 -> 1 change & 3 represent 1 -> 0
    Iterate over grid and update with intermediate values accordingly
    Iterate again and convert intermediate values to final values i.e. 2 -> 1 & 3 -> 0
    */
    private static final int DEAD = 0;
    private static final int LIVE = 1;
    private static final int DEAD_TO_LIVE = 2;
    private static final int LIVE_TO_DEAD = 3;
    private static final int[] steps = {-1,0,1};

    public void gameOfLife(int[][] board) {
        //Convert cells to intermediate states where applicable
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j] = getIntermediateState(board, i,j);
            }
        }

        //Convert intermediate cell states to final state
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j] = getNextState(board, i,j);
            }
        }
    }

    private int getIntermediateState(int[][] grid, int row, int col){
        int liveNeighbourCount=0;
        for(int i=0; i<3; i++){
            int nRow = row + steps[i];
            if(nRow < 0 || nRow == grid.length)
                continue;
            for(int j=0; j<3; j++){
                int nCol = col + steps[j];
                if((nCol < 0 || nCol == grid[nRow].length) || (nRow==row && nCol == col))
                    continue;
                if(grid[nRow][nCol] == LIVE || grid[nRow][nCol]== LIVE_TO_DEAD)
                    liveNeighbourCount++;
            }
        }
        int intermediateState = grid[row][col];
        if(grid[row][col] == LIVE){
            if(liveNeighbourCount < 2 || liveNeighbourCount > 3)
                intermediateState = LIVE_TO_DEAD;
        }else{
            if(liveNeighbourCount == 3)
                intermediateState = DEAD_TO_LIVE;
        }
        return intermediateState;
    }

    private int getNextState(int[][] grid, int row, int col){
        int nextState = grid[row][col];
        if(DEAD_TO_LIVE == grid[row][col]){
            nextState = LIVE;
        }else if(LIVE_TO_DEAD == grid[row][col]){
            nextState = DEAD;
        }
        return nextState;
    }
}