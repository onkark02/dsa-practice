package practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    static public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int length = 0;
        int startIndex = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch) && map.get(ch) >= startIndex){
                startIndex = map.get(ch) + 1;
                length = i - startIndex + 1;
            }else{
                length++;
                if(length > maxLength)
                    maxLength = length;
            }
            map.put(ch,i);
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        int currLength = 0;
        Set<Character> charSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(charSet.contains(ch)){

               sb = new StringBuilder( sb.substring(sb.indexOf(String.valueOf(ch))+1));
               sb.append(ch);
                charSet = new HashSet<>();
                for(int j=0; j<sb.length(); j++)
                    charSet.add(sb.charAt(j));
                currLength = sb.length();
            }else{
                charSet.add(ch);
                sb.append(ch);
                currLength++;
            }
            if(currLength > maxLength)
                maxLength = currLength;
        }
        return maxLength;
    }
}
