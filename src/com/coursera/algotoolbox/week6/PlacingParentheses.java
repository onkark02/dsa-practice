package com.coursera.algotoolbox.week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlacingParentheses {
    private static long[][] maxValues;
    private static long[][] minValues;

    private static long getMaximValue(String exp) {
      //write your code here
        List<Long> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        //Populate nums and ops arrays from input string
        int i=0;
        while(i<exp.length()){
            char c = exp.charAt(i);
            if(c >= '0' && c <= '9'){
               long val = 0;
               while(i < exp.length() && exp.charAt(i) >= '0' && exp.charAt(i) <= '9'){
                   val = val*10 + (exp.charAt(i)-'0');
                   i++;
               }
               nums.add(val);
            }else{
                ops.add(c);
                i++;
            }
        }

        //initialize maxValues and minValues
        maxValues = new long[nums.size()][nums.size()];
        minValues = new long[nums.size()][nums.size()];
        for(int j=0;j<nums.size();j++){
            maxValues[j][j] = nums.get(j);
            minValues[j][j] = nums.get(j);
        }

        for(int j=1; j<nums.size(); j++){
            int range = nums.size()-j;
            for(int k=0; k<range; k++){
                populateMinAndMaxValues(k,k+j,ops);
            }
        }

        return maxValues[0][nums.size()-1];
    }

    private static void populateMinAndMaxValues(int i, int j, List<Character> ops){
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for(int k=i; k<j; k++){
            long a = eval(maxValues[i][k],maxValues[k+1][j],ops.get(k));
            long b = eval(maxValues[i][k],minValues[k+1][j],ops.get(k));
            long c = eval(minValues[i][k],maxValues[k+1][j],ops.get(k));
            long d = eval(minValues[i][k],minValues[k+1][j],ops.get(k));
            min = getMin(min,a,b,c,d);
            max = getMax(max,a,b,c,d);
        }
        minValues[i][j] = min;
        maxValues[i][j] = max;
    }

    private static long getMin(long... values){
        long min = Long.MAX_VALUE;
        for(long val:values){
            if(min > val)
                min = val;
        }
        return min;
    }

    private static long getMax(long... values){
        long max = Long.MIN_VALUE;
        for(long val:values){
            if(max < val)
                max = val;
        }
        return max;
    }
    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

