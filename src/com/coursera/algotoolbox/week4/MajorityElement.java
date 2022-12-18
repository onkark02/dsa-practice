package com.coursera.algotoolbox.week4;

import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
/*        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }*/
        //write your code here

        if(left==right){
            return a[left];
        }
        int half = (right-left + 1)/2;
        int mid = left + (right-left)/2;
        int maj1 = getMajorityElement(a,left,mid);
        int maj2 = getMajorityElement(a,mid+1,right);
        for(int maj1Count=0, maj2Count=0, i=left; i<=right;i++){
            if(a[i]==maj1){
                if(++maj1Count > half)
                    return maj1;
            }else if(a[i]==maj2){
                if(++maj2Count > half)
                    return maj2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length-1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

