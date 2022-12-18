package com.coursera.algotoolbox.ds.week3;

import java.util.*;
import java.io.*;

public class common_substring {
    public class Answer {
        int i, j, len;
        Answer(int i, int j, int len) {
            this.i = i;
            this.j = j;
            this.len = len;
        }
    }

    public Answer solveNaive(String s, String t) {
        Answer ans = new Answer(0, 0, 0);
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < t.length(); j++)
                for (int len = 0; i + len <= s.length() && j + len <= t.length(); len++)
                    if (len > ans.len && s.substring(i, i + len).equals(t.substring(j, j + len)))
                        ans = new Answer(i, j, len);
        return ans;
    }
    private final int m1 = 1000000007;
    private final int m2 = 1000000009;
    private final long x = 31;
    public Answer solve(String s, String t) {
        Answer ans = new Answer(0, 0, 0);
        int[] sHash1 = new int[s.length()+1];
        int[] sHash2 = new int[s.length()+1];
        int[] tHash1 = new int[t.length()+1];
        int[] tHash2 = new int[t.length()+1];
        populateHashArray(s, sHash1, sHash2);
        populateHashArray(t,tHash1,tHash2);
        int lenMax = Math.min(s.length(),t.length());
        int lenMin=0;
        while(lenMin <= lenMax){
            int midLen = lenMin + (lenMax-lenMin)/2;
            boolean isCommonSubstringPresent = isCommonSubstringPresent(midLen, sHash1, sHash2, tHash1,tHash2, ans);
            if(isCommonSubstringPresent){
                lenMin = midLen+1;
            }else{
                lenMax = midLen-1;
            }
        }
        return ans;
    }

    private boolean isCommonSubstringPresent(int len, int[] sHash1, int[] sHash2, int[] tHash1, int[] tHash2, Answer ans) {
        long multiplier1 = power(x,len,m1);
        long multiplier2 = power(x,len,m2);
        Map<Integer,Integer> sMap1 = new HashMap<>();
        Map<Integer,Integer> sMap2 = new HashMap<>();

        for(int i=0; i+len<sHash1.length; i++){
            sMap1.put((int) (sHash1[i+len] - sHash1[i]*multiplier1%m1 + m1) % m1,i);
            sMap2.put((int) (sHash2[i+len] - sHash2[i]*multiplier2%m2 + m2) % m2,i);
        }

        for(int i=0; i+len < tHash1.length; i++){
            int tSubstringHash1 = (int) (tHash1[i+len] - tHash1[i]*multiplier1%m1 + m1) % m1;
            if(sMap1.containsKey(tSubstringHash1)){
                int tSubstring2 = (int) (tHash2[i+len] - tHash2[i]*multiplier2%m2 + m2) % m2;
                if(sMap2.containsKey(tSubstring2) && Objects.equals(sMap1.get(tSubstringHash1), sMap2.get(tSubstring2))){ //Indicates a match
                    ans.i = sMap1.get(tSubstringHash1);
                    ans.j = i;
                    ans.len = len;
                    return true;
                }
            }
        }
        return false;
    }


    private void populateHashArray(String str, int[] h1, int[] h2){
        for(int i=1; i<h1.length; i++){
            int s = str.charAt(i-1);
            long sum = h1[i-1]*x + s;
            h1[i] = (int) (sum % m1);
            sum = h2[i-1]*x + s;
            h2[i] = (int) (sum % m2);
        }
    }

    private long power(long val, int y, int p)
    {
        long res = 1; // Initialize result
        if(p==0)
            return res;
        val = val % p; // Update x if it is more than or
        // equal to p

        if (val == 0)
            return 0; // In case x is divisible by p;

        while (y > 0)
        {

            // If y is odd, multiply x with result
            if ((y & 1) != 0)
                res = (res * val) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            val = (val * val) % p;
        }
        return res;
    }

    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        in.lines().forEach(line -> {
            StringTokenizer tok = new StringTokenizer(line);
            String s = tok.nextToken();
            String t = tok.nextToken();
            Answer ans = solve(s, t);
            out.format("%d %d %d\n", ans.i, ans.j, ans.len);
        });
        out.close();
    }

    static public void main(String[] args) {
        new common_substring().run();
    }
}
