package com.coursera.algo2.week1;

import com.coursera.algo1.week2.Stack;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    public DepthFirstPaths(Graph G, int s){
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G,s);
    }
    private void dfs(Graph G, int v){
        marked[v] = true;
        for (int w: G.adj(v)) {
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(G,w);
            }
        }
    }

    public boolean isConnected(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!marked[v]) return null;
        Stack<Integer> path = new Stack<>();
        for(int x=v; v!=s;x=edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        DepthFirstPaths paths = new DepthFirstPaths(G,0);

        System.out.println(paths.isConnected(3));
        paths.pathTo(3).forEach(v -> System.out.print(v+" ->"));
    }
}
