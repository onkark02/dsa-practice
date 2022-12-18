package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1,2},{3,4},{5,6}};
        spiralOrder(matrix).forEach(System.out::println);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length==0)
            return ans;
        int colStart = 0, rowStart = 0, colEnd = matrix[0].length -1 , rowEnd = matrix.length-1;
        while(colStart <= colEnd && rowStart <= rowEnd){
            //Traverse right
            for(int i=colStart;i<=colEnd;i++)
                ans.add(matrix[rowStart][i]);
            rowStart++;

            //Traverse down
            for(int i=rowStart;i<=rowEnd;i++)
                ans.add(matrix[i][colEnd]);
            colEnd--;

            //Traverse left
            for(int i=colEnd;i>=colStart;i--)
                ans.add(matrix[rowEnd][i]);
            rowEnd--;

            //Traverse up
            for(int i=rowEnd;i>=rowStart;i--)
                ans.add(matrix[i][colStart]);
            colStart++;
        }
        return ans;
    }
}
