package practice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] nums = {{'1','0','1','1','1'},{'1','0','1','0','1'},{'1','1','1','0','1'}};
        System.out.println(numIslands(nums));
    }

    public static int numIslands(char[][] grid) {
        Set<String> locations = new HashSet<>();
        int islandCount = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] != '1')
                    continue;
                String location = getLocation(i,j);
                if(!locations.contains(location)){
                    islandCount++;
                    locations.add(location);
                    addAdjacentLocations(i,j,locations,grid);
                }
            }
        }

        return islandCount;
    }

    private static void addAdjacentLocations(int row, int col, Set<String> locations, char[][] grid){
        if (row != grid.length - 1 && grid[row+1][col] == '1') {
            String location = getLocation(row+1,col);
            if(!locations.contains(location)){
                locations.add(location);
                addAdjacentLocations(row+1,col,locations,grid);
            }
        }
        if (col != grid[row].length - 1 && grid[row][col+1] == '1') {
            String location = getLocation(row,col+1);
            if(!locations.contains(location)){
                locations.add(location);
                addAdjacentLocations(row,col+1,locations,grid);
            }
        }
        if (row != 0 && grid[row-1][col] == '1') {
            String location = getLocation(row-1,col);
            if(!locations.contains(location)){
                locations.add(location);
                addAdjacentLocations(row-1,col,locations,grid);
            }
        }
        if (col != 0 && grid[row][col-1] == '1') {
            String location = getLocation(row,col-1);
            if(!locations.contains(location)){
                locations.add(location);
                addAdjacentLocations(row,col-1,locations,grid);
            }
        }
    }

    private static String getLocation(int i, int j){
        return Integer.toString(i).concat("-").concat(Integer.toString(j));
    }
}
