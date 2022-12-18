package practice.leetcode;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> visited = new HashMap<>();

        for(String str: strs){
            char[] key = str.toCharArray();
            Arrays.sort(key);
            String keyStr = new String(key);
            List<String> list = visited.getOrDefault(keyStr, new ArrayList<>());
            list.add(str);

            visited.put(keyStr, list);
        }


        return new ArrayList<>(visited.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
         List<List<String>> ans = solution.groupAnagrams(strs);
        System.out.println(ans);
    }
}
