package practice.leetcode;

public class SpiralMatrix2 {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(7);
        System.out.println(matrix);
    }

    private static int[][] steps = {{0,1},{1,0},{0,-1},{-1,0}};

    public static int[][] generateMatrix(int n) {
        int size = n*n;
        int[][] matrix = new int[n][n];
        int x=0, y=-1, index=0;
        int val=1;

        while(val <= size){
            if(index==steps.length)
                index=0;

            while(isValid(x+steps[index][0], y+steps[index][1], n)){

                if(matrix[x+steps[index][0]][y+steps[index][1]] == 0){
                    x += steps[index][0];
                    y += steps[index][1];
                    matrix[x][y] = val++;
                }else{
                    break;
                }
            }
            index++;
        }

        return matrix;
    }

    private static boolean isValid(int row, int col, int n){
        if(row < 0 || col < 0 || row >= n || col >= n){
            return false;
        }else{
            return true;
        }
    }
}
