package com.coursera.algotoolbox.week5;

import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here
    int[][] distances = new int[1+s.length()][1+t.length()];
    //Set first column of matrix
    for(int i=0;i<distances.length; i++){
      distances[i][0] = i;
    }
    //Set first row of matrix
    for(int i=0; i<distances[0].length;i++){
      distances[0][i] = i;
    }

    //Start filling matrix row by row (can be done column wise as well)
    for(int i=1; i<distances.length;i++){
      for(int j=1;j<distances[i].length;j++){
        boolean isMatch = s.charAt(i-1) == t.charAt(j-1);
        int minDistance = Math.min(distances[i][j-1]+1,distances[i-1][j]+1);
        int diagonalDistance = isMatch ? distances[i-1][j-1]:distances[i-1][j-1]+1;
        distances[i][j] = Math.min(minDistance,diagonalDistance);
      }
    }

    return distances[s.length()][t.length()];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
