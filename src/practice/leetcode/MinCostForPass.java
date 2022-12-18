package practice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MinCostForPass {
    public static void main(String[] args) {
        MinCostForPass minCostForPass = new MinCostForPass();
        int[] arr = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2,7,15};
        System.out.println(minCostForPass.mincostTickets(arr,costs));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] passDays = {1,7,30};

        int[] minCosts = new int[days[days.length-1]+1];
        Set<Integer> set = new HashSet<>();
        for(int day:days)
            set.add(day);

        for(int i=1; i<minCosts.length; i++){
            if(set.contains(i)){
                for(int j=0; j<3; j++){
                    int index = i > passDays[j] ? i-passDays[j] : 0;
                    int cost = minCosts[index] + costs[j];
                    if(minCosts[i]==0)
                        minCosts[i] = cost;
                    else
                        minCosts[i] = Math.min(minCosts[i],cost);
                }
            }else{
                minCosts[i] = minCosts[i-1];
            }
        }

        return minCosts[minCosts.length-1];
    }
}
