package practice.leetcode;

import java.util.Arrays;

public class KMPRepeat {
    public static void main(String[] args) {
        KMPRepeat solution = new KMPRepeat();
        System.out.println(solution.substringSearch("The producer runs steps continuously in a while loop. This loop breaks when runFlag is false.","loop"));
    }

    public int substringSearch(String text, String pattern){
        int[] lps = lps(pattern);
        int i=0, j=0;

        while(i < text.length() && j<pattern.length()){
                if(text.charAt(i) == pattern.charAt(j)){
                    i++;
                    j++;
                }else if(j>0){
                    j = lps[j-1]+1;
                }else{
                    i++;
                }
        }
        return j==pattern.length() ? i - pattern.length(): -1;
    }

    /*
    abcacd

    *  a b c a b c a b
    * -1-1-1 0 1 2 0 1
    * */
    private int[] lps(String pattern) {
        int[] lps = new int[pattern.length()];
        Arrays.fill(lps,-1);
        int i=1, j=0;
        while (i < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[i++] = j++;
            }else if(j>0){
                j = lps[j-1] + 1;
            }else{
                i++;
            }
        }
        return lps;
    }
}
