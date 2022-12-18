package practice.leetcode;

import java.util.*;

public class RandomizedSet {
    Map<Integer,Integer> valueToIndexMap;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        valueToIndexMap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(valueToIndexMap.containsKey(val)){
            return false;
        }else{
            valueToIndexMap.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if(valueToIndexMap.containsKey(val)){
            int index = valueToIndexMap.remove(val);
            list.remove(index);
            return true;
        }else{
            return false;
        }
    }

    public int getRandom() {
        if(list.isEmpty())
            return -1;
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        System.out.println(randomizedSet.getRandom());
    }
}



/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
