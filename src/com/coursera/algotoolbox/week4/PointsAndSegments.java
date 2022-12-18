package com.coursera.algotoolbox.week4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        Point[] coordinates = new Point[2*starts.length + points.length];
        int j=0;
        for(int i=0; i<starts.length; i++){
            coordinates[j++] = new Point(starts[i],0,i);
            coordinates[j++] = new Point(ends[i],2,i);
        }
        for(int i=0; i<points.length; i++){
            coordinates[j++] = new Point(points[i],1,i);
        }
        Arrays.sort(coordinates);
        int openSegments=0;
        for(int i=0; i<coordinates.length; i++){
            if(coordinates[i].type == 0){
                openSegments++;
            }else if(coordinates[i].type == 2){
                openSegments--;
            }else{
                cnt[coordinates[i].index] = openSegments;
            }
        }
        return cnt;
    }


    static class Point implements Comparable{
        int coordinate;
        /*
        Value of type
        0 -> start point
        1 -> search point
        2 -> end point
        */
        int type;
        int index;

        public Point(int coordinate, int type, int index){
            this.coordinate = coordinate;
            this.type = type;
            this.index = index;
        }


        @Override
        public int compareTo(Object o) {
            Point other = (Point) o;
            if(this.coordinate == other.coordinate){
                return this.type - other.type;
            }else{
                return this.coordinate - other.coordinate;
            }

        }
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        mainCode();
//        stressTest(10000);
    }

    private static void mainCode(){
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
/*        int[] cnt = naiveCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }*/

        int[] cnt1 = fastCountSegments(starts,ends,points);
//        System.out.println("Faster");
        for (int x : cnt1) {
            System.out.print(x + " ");
        }
    }

    private static void stressTest(int n){
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[n];
        int count=0;
        while(true){
            System.out.println("Round: "+count++);
            for(int i=0; i<n; i++){
                ends[i] = new Random().nextInt(2*n)+1;
                starts[i] = new Random().nextInt(ends[i]);
                points[i] = new Random().nextInt(3*n);
            }
            int[] cnt = naiveCountSegments(starts,ends,points);
            int[] cnt1 = fastCountSegments(starts,ends,points);
            for(int i=0; i<n; i++){
                if(cnt[i] != cnt1[i]){
                    System.out.println("Starts: ");
                    for (int x : starts) {
                        System.out.print(x + " ");
                    }
                    System.out.println("Ends: ");
                    for (int x : ends) {
                        System.out.print(x + " ");
                    }
                    System.out.println("Points: ");
                    for (int x : points) {
                        System.out.print(x + " ");
                    }
                    System.out.println("Naive: ");
                    for (int x : cnt) {
                        System.out.print(x + " ");
                    }
                    System.out.println("Faster: ");
                    for (int x : cnt1) {
                        System.out.print(x + " ");
                    }
                    return;
                }
            }
        }
    }
}

