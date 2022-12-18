package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{1,3},{8,10},{3,7},{2,6}};
        mergeIntervals.merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
        public int[][] merge1(int[][] intervals) {
            if(intervals == null || intervals.length==0)
                return intervals;
            //Sort these intervals in non-descending order by their end time
            Arrays.sort(intervals, (a, b) -> a[1]-b[1]);

            List<int[]> resultList = new LinkedList<>();

            int[] intervalToAdd = new int[2];
            intervalToAdd[0] = intervals[0][0];
            intervalToAdd[1] = intervals[0][1];

            for(int i=1; i < intervals.length; i++){
                if(doIntervalsOverlap(intervalToAdd,intervals[i])){
                    intervalToAdd[0] = Math.min(intervalToAdd[0],intervals[i][0]);
                    intervalToAdd[1] = Math.max(intervalToAdd[1],intervals[i][1]);
                }else{
                    resultList.add(intervalToAdd);
                    intervalToAdd[0] = intervals[i][0];
                    intervalToAdd[1] = intervals[i][1];
                }
            }
            resultList.add(intervalToAdd);

            //Convert result from list to array
            int[][] result = new int[resultList.size()][2];
            for(int i=0; i<resultList.size(); i++)
                result[i] = resultList.get(i);
            return result;
        }

        private boolean doIntervalsOverlap(int[] i1, int[] i2){
            boolean result;
            if(i2[0] >= i1[0] && i2[0] <= i1[1])
                result = true;
            else if(i1[0] >= i2[0] && i1[0] <= i2[0])
                result = true;
            else
                result = false;
            return result;
        }
    }
