package com.coursera.graphs.week1;

import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
    private static boolean[] visited;
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here
        //initialize visited array
        visited = new boolean[adj.length];
        explore(adj, x,y);
        return visited[y] ? 1:0;
    }

    private static void explore(ArrayList<Integer>[] adj, int x, int y){
        visited[x] = true;
        //Added for quickly returning in case of y already visited
        if(visited[y])
            return;
        for(int neighbour: adj[x]){
            if(!visited[neighbour]){
                explore(adj,neighbour,y);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

