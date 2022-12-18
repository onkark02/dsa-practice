package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,3,3,4,1,2,6,4};
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] result = topKFrequentElements.topKFrequent(arr,3);
        Arrays.stream(result).forEach(System.out::println);
    }

    public int[] topKFrequent(int[] nums, int k){
        //Build frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int num: nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }

        int[] valArray = new int[frequencyMap.size()];
        int[] freqArray = new int[frequencyMap.size()];

        return new int[0];
    }

    public int[] topKFrequent2(int[] nums, int k){
        //Build frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int num: nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }

        Queue<Integer> heap = new PriorityQueue<>((n1,n2) -> frequencyMap.get(n1) - frequencyMap.get(n2) );

        for(int num: frequencyMap.keySet()){
            heap.add(num);
            if(heap.size() > k)
                heap.poll();
        }
        int[] result = new int[k];
        for(int i=k-1; i>=0; i--)
            result[i] = heap.poll();
        return result;
    }

    public int[] topKFrequent1(int[] nums, int k){
//Build frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int num: nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }

//Build bucket array
        List<Integer>[] bucket = new List[nums.length+1];

        for(int val:frequencyMap.keySet()){
            if(bucket[frequencyMap.get(val)] == null)
                bucket[frequencyMap.get(val)] = new ArrayList<>();
            bucket[frequencyMap.get(val)].add(val);
        }

//Build result array
        int[] result = new int[k];

        for(int i=nums.length,resultIndex=0; i>=0; i--){
            if(bucket[i] == null)
                continue;
            for(int j=0; j<bucket[i].size()&&resultIndex<k;j++){
                result[resultIndex++] = bucket[i].get(j);
            }
        }

        return result;
    }
}
