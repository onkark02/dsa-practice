package com.coursera.algo1.week1;

public class WeightedQuickUnionUF {
    private int[] id, size;

    public WeightedQuickUnionUF(int n){
        id = new int[n];
        for(int i=0; i<n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public boolean isConnected(int p, int q){
        return getRoot(p)==getRoot(q);
    }

    public void union(int p, int q){
        int pRoot=getRoot(p);
        int qRoot=getRoot(q);
        if(size[pRoot] > size[qRoot]){
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }else {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
    }

    private int getRoot(int i){
        while(i==id[i])
            i=id[i];
        return i;
    }
}
