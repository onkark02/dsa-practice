package com.coursera.algo1.week1;

public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int n){
        id = new int[n];
        for(int i=0; i<n; i++)
            id[i]=i;
    }

    public boolean isConnected(int p, int q){
        return getRoot(p)==getRoot(q);
    }

    public void union(int p, int q){
        int pRoot=getRoot(p);
        int qRoot=getRoot(q);
        id[pRoot]=qRoot;
    }

    private int getRoot(int i){
        while(i==id[i])
            i=id[i];
        return i;
    }
}
