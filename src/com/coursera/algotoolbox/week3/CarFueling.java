package com.coursera.algotoolbox.week3;

import java.util.Arrays;
import java.util.Scanner;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        //Sort stops
        Arrays.sort(stops);

        int stopsTaken = 0;
        int lastRefill = 0;
        int i=0;

        while(i < stops.length && lastRefill + tank < dist){
            int refill = lastRefill;

            while(i < stops.length && lastRefill+tank >= stops[i]){
                refill = stops[i];
                i++;
            }

            if(refill == lastRefill){ //No stop reachable from lastRefill
                break;
            }else{
                lastRefill = refill;
                stopsTaken++;
            }
        }
        return (lastRefill + tank < dist) ? -1:stopsTaken;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
