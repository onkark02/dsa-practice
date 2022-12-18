package com.coursera.algo2.week1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private final Bag<Integer>[] adj;
    private int E;
    public Graph(int V){
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V= V;
        this.E=0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }
    public Graph(In in){
        if(in == null)
            throw new IllegalArgumentException("argument is null");
        try{
            this.V = in.readInt();
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<>();
            }
            this.E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");

            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                addEdge(v,w);
            }
        }catch (NoSuchElementException e){
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);

        }
    }
    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public int E(){
        return E;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    /**
     * Unit tests the {@code Graph} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);
    }
}
