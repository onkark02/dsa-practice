package com.coursera.algotoolbox.week3;

import java.util.*;

public class CoveringSegments {

    private static List<Integer> optimalPoints(Segment[] segments) {
        //write your code here
/*        int[] points = new int[2 * segments.length];
        for (int i = 0; i < segments.length; i++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }
        return points;*/
        List<Integer> points = new ArrayList<>();
        Arrays.sort(segments, Comparator.comparingInt(o -> o.end));
        for(int i=0; i<segments.length; i++){
            if(segments[i].isCovered)
                continue;
            int endpoint = segments[i].end;
            segments[i].isCovered = true;
            points.add(endpoint);
            for(int j=i+1;j<segments.length;j++){
                if(!segments[j].isCovered && endpoint >= segments[j].start && endpoint <= segments[j].end){
                    segments[j].isCovered = true;
                }
            }
        }
        return points;
    }

    private static class Segment {
        int start, end;
        boolean isCovered;
        Segment(int start, int end) {
            this.start = start;
            this.end = end;
            this.isCovered = false;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
