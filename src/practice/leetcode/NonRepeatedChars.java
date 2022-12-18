package practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NonRepeatedChars {
    public static void main(String[] args) {
        String str = "xxikrwmjvsvckfrqxnibkcasompsuyuogauacjrr";
        NonRepeatedChars nonRepeatedChars = new NonRepeatedChars();
        System.out.println(nonRepeatedChars.solve(str));
    }


    public String solve(String A) {
        if (A == null || A.length() == 0) {
            return A;
        }
        int[] freqCount = new int[26];
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        queue.offer(A.charAt(0));
        result.append(A.charAt(0));
        freqCount[A.charAt(0) - 'a'] = 1;

        for (int i = 1; i < A.length(); i++) {
            char ch = A.charAt(i);
            freqCount[ch - 'a']++;
            if( freqCount[ch - 'a']==1){
                queue.offer(ch);
            }
            char non_repeated = '#';
            while (!queue.isEmpty()) {
                if (freqCount[queue.peek() - 'a'] == 1) {
                    non_repeated = queue.peek();
                    break;
                } else {
                    queue.poll();
                }
            }
            result.append(non_repeated);
    
        }
        return result.toString();
    }
}
