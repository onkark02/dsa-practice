package practice.leetcode;

//https://leetcode.com/problems/longest-repeating-character-replacement/

public class LongetRepeatingCharacterSubString {
    public static void main(String[] args) {
        LongetRepeatingCharacterSubString solution = new LongetRepeatingCharacterSubString();
        System.out.println(solution.characterReplacement("ABBB",1));
    }
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int i=0, startIndex=0;
        int replacements = k;
        char startingChar = s.charAt(0);

        while(true){
            while(i < s.length() && startingChar == s.charAt(i))
                i++;
            if(i == s.length())
                break;
            if(replacements > 0){
                replacements--;
                i++;
            }else{
                int length = i - startIndex;
                if(length > maxLength)
                    maxLength = length;
                while(startIndex < s.length() && startingChar == s.charAt(startIndex))
                    startIndex++;
                startingChar = s.charAt(startIndex);
                startIndex = startIndex - k;
                if(startIndex< 0)
                    startIndex = 0;
                i = startIndex;
                replacements = k;
            }
        }
        int length = s.length() - startIndex;
        if(length > maxLength)
            maxLength = length;

        return maxLength;
    }
}
