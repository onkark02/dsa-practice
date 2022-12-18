package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestStringWithSwaps {
    public static void main(String[] args) {
        SmallestStringWithSwaps solution = new SmallestStringWithSwaps();
        String str = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0,3));
        pairs.add(Arrays.asList(1,2));
        pairs.add(Arrays.asList(0,2));
        String result = solution.smallestStringWithSwaps(str,pairs);
        System.out.println(result);
    }

    //Brute force solution
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        boolean isSwapped = false;
        char[] str = s.toCharArray();

        do{
            isSwapped = false;
            for(List<Integer> pair : pairs){
                char ch1 = str[pair.get(0)];
                char ch2 = str[pair.get(1)];

                if(ch1 > ch2){
                    str[pair.get(1)] = ch1;
                    str[pair.get(0)] = ch2;
                    isSwapped = true;
                }
            }
        }while(isSwapped);

        return new String(str);
    }
}
