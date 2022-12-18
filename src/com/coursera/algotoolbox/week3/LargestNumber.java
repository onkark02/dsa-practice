package com.coursera.algotoolbox.week3;

import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        Arrays.sort(a, (s1, s2) -> compareString(s1, s2));
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    private static int compareString(String s1, String s2) {
        String s12 = s1+s2;
        String s21 = s2+s1;
        return s21.compareTo(s12);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

