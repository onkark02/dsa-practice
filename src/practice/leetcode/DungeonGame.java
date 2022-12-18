package practice.leetcode;

//https://leetcode.com/problems/dungeon-game/
public class DungeonGame {
    public static void main(String[] args) {
        DungeonGame dungeonGame = new DungeonGame();
        int[][] dungeon = {{-1,-2,-3},{-2,3,1},{2,1,-5}};
        System.out.println(dungeonGame.calculateMinimumHP(dungeon));
    }

    int[][] minHP;
    public int calculateMinimumHP(int[][] dungeon) {
        minHP = new int[dungeon.length][dungeon[0].length];

        solve(dungeon,0,0);
        return minHP[0][0];
    }

    private int solve(int[][] dungeon, int row, int col){
        if(row == dungeon.length || col == dungeon[0].length)
            return Integer.MAX_VALUE;

        if(minHP[row][col] != 0)
            return minHP[row][col];

        int healthNeeded;

        if(row == dungeon.length-1 && col == dungeon[0].length-1){
            healthNeeded = Math.max(-dungeon[row][col],0)+1;
            minHP[row][col] = healthNeeded;
        }else{
            int healthNeededIfRight = solve(dungeon,row,col+1);
            int healthNeededIfDown = solve(dungeon,row+1,col);
            healthNeeded = Math.min(healthNeededIfRight,healthNeededIfDown) - dungeon[row][col];
            minHP[row][col] = Math.max(healthNeeded, 1);
        }
        return minHP[row][col];
    }


    private int globalMinHealth;
    public int calculateMinimumHP1(int[][] dungeon) {
        globalMinHealth = Integer.MIN_VALUE;
        dfs(dungeon,0,0,0,0);
        return globalMinHealth * -1 + 1;
    }

   /*
   Answer is correct, however hits TLE
   * */
    private void dfs(int[][] grid, int row, int col, int hp, int minHp){
        int blockHp = grid[row][col];
        hp += blockHp;

        if(minHp>hp)
            minHp = hp;

        //Check for last block
        if(row == grid.length-1 && col == grid[row].length-1){
            if(globalMinHealth < minHp)
                globalMinHealth = minHp;
            return;
        }

        if(row < grid.length-1)
            dfs(grid,row+1,col,hp,minHp);

        if(col < grid[row].length-1)
            dfs(grid,row,col+1,hp,minHp);
    }
}
