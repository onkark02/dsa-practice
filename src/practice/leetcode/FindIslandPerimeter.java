package practice.leetcode;

public class FindIslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        FindIslandPerimeter findIslandPerimeter = new FindIslandPerimeter();
        System.out.println(findIslandPerimeter.islandPerimeter(grid));
    }
    /*
    DFS Solution
    */
    public int islandPerimeter(int[][] grid) {

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    return dfs(grid, i, j);
                }
            }
        }
        return -1;
    }

    private int dfs(int[][] grid, int row, int col){

        int perimeter = getBlockPerimeter(grid,row,col);
        grid[row][col] = -1;
        if(row > 0 && grid[row-1][col] == 1)
            perimeter += dfs(grid, row-1,col);
        if(col > 0 && grid[row][col-1] == 1)
            perimeter += dfs(grid, row,col-1);
        if(row < grid.length-1 && grid[row+1][col] == 1)
            perimeter += dfs(grid, row+1,col);
        if(col < grid[row].length-1 && grid[row][col+1] == 1)
            perimeter += dfs(grid, row,col+1);

        return perimeter;
    }

    private int getBlockPerimeter(int[][] grid, int i, int j){
        int perimeter = 0;

        if(i<1 || grid[i-1][j] == 0)
            perimeter++;

        if(i>=grid.length-1 || grid[i+1][j] == 0)
            perimeter++;

        if(j<1 || grid[i][j-1] == 0)
            perimeter++;

        if(j>=grid[i].length-1 || grid[i][j+1] == 0)
            perimeter++;

        return perimeter;
    }
}