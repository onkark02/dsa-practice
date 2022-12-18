package practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        Map<Integer, Integer> map;
        String str;
        List<List<Integer>> result = combinationSum3.combinationSum3(3,7);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int requiredSize, int target, int digit){
        if(target==0 && list.size()==requiredSize){
            result.add(new ArrayList<>(list));
            return;
        }else if(target < 0 || list.size() >= requiredSize){
            return;
        }

        for(int i=digit; i<10; i++){
            list.add(i);
            backtrack(result, list, requiredSize, target-i, i+1);
            list.remove(list.size()-1);
        }
    }
}
