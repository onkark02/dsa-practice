package practice.leetcode;

public class DetectCapital {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("leetcode"));
    }
    public static boolean detectCapitalUse(String word) {
        int noOfUpperCaps=0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) < 97){
                // Upper case char
                noOfUpperCaps++;
            }
        }
        return noOfUpperCaps == word.length() || noOfUpperCaps == 0 || (noOfUpperCaps == 1 && word.charAt(0) < 97);
    }
}
