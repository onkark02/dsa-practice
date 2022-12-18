package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
    public static void main(String[] args) {
        Shift2DGrid solution = new Shift2DGrid();
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        List<List<Integer>> result = solution.shiftGrid(grid,1);
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        //Create empty result list of list
        List<List<Integer>> result = new ArrayList<>(rows);
        for(int i=0; i<rows; i++){
            result.add(i,new ArrayList<>(cols));
            for(int j=0; j<cols;j++){
                result.get(i).add(0);
            }
        }

        int gridSize = rows*cols;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int index = i*cols+j;
                int newIndex = (index+k)%gridSize;
                int newRow = newIndex/cols;
                int newCol = newIndex%cols;
                result.get(newRow).set(newCol,grid[i][j]);
            }
        }

        return result;
    }
}
