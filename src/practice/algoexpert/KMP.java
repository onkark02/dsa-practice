package practice.algoexpert;

import java.util.Arrays;

/*
* Famous algorithm to find a substring in other input string
* Naive implementation of string matching runs in O(n * m) where n & m are lengths of 2 strings
* KMP algo solves this problem with complexity O(n + m) which is huge improvement
*
* pattern - abca
* */
public class KMP {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.kmpSubstringSearch("abcabcabcdabc","abcabcd"));
    }

    public int kmpSubstringSearch(String text, String pattern){
        if(pattern.length() > text.length()){
            return -1;
        }
        int[] lps = lps(pattern);
        int i=0,j=0;
        while(j<pattern.length() && i <text.length()-pattern.length()+1){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else if(j > 0){
                j = lps[j-1] + 1;
            }else{
                i++;
                j=0;
            }
        }
        return pattern.length() == j ? (i-pattern.length()) : -1;
    }

    /*
    * i/p - a,d,f,a,d,a,d,f
    *      -1-1-1 0 1 0 1 2
    * */
    private int[] lps(String pattern){
        int[] lps = new int[pattern.length()];
        Arrays.fill(lps,-1);
        int i=1,j=0;
        while(i<pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[i] = j;
                i++;
                j++;
            }else if(j > 0){
                j = lps[j-1] +1;
            }else{
                i++;
                j=0;
            }
        }
        return lps;
    }
}
