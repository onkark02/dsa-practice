package com.coursera.algo1.week1.assignment;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private int openSiteCount;
    final private int gridLength, gridSize;
    final private WeightedQuickUnionUF uf;

    // Create n*n grid of sites, initialise each grid to 0 (closed), initialize a UF dataType with n*n+2 sites, from 0 to n*n+1
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Provided input should be non-zero integer");
        }
        grid = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; i < n; i++)
                grid[i][j] = false;   // 0 denotes closed & 1 as open
        openSiteCount = 0;
        gridLength = n;
        gridSize = n * n;
        uf = new WeightedQuickUnionUF(n * n + 2);
        for (int i = 1; i <= n; i++) {
            uf.union(0, getUFNumber(1, i));
            //uf.union(gridSize + 1, getUFNumber(n, i));
        }
    }

    public void open(int row, int col) {
        validateInput(row, col);
        if (!isOpen(row, col)) {
            grid[row - 1][col - 1] = true;
            openSiteCount++;
            connectAdjacentSites(row, col);
            if(row==gridLength){
                uf.union(gridSize + 1, getUFNumber(row, col));
            }
        }

    }

    private void connectAdjacentSites(int row, int col) {
        if (isValidSite(row, col - 1) && isOpen(row, col - 1) && !uf.connected(getUFNumber(row, col), getUFNumber(row, col - 1))) {
            uf.union(getUFNumber(row, col), getUFNumber(row, col - 1));
        }
        if (isValidSite(row, col + 1) && isOpen(row, col + 1) && !uf.connected(getUFNumber(row, col), getUFNumber(row, col + 1))) {
            uf.union(getUFNumber(row, col), getUFNumber(row, col + 1));
        }
        if (isValidSite(row - 1, col) && isOpen(row - 1, col) && !uf.connected(getUFNumber(row, col), getUFNumber(row - 1, col))) {
            uf.union(getUFNumber(row, col), getUFNumber(row - 1, col));
        }
        if (isValidSite(row + 1, col) && isOpen(row + 1, col) && !uf.connected(getUFNumber(row, col), getUFNumber(row + 1, col))) {
            uf.union(getUFNumber(row, col), getUFNumber(row + 1, col));
        }
    }

    private int getUFNumber(int row, int col) {
        return (row - 1) * gridLength + col; // Not using col-1 as to compensate with upper virtual site with 0 position
    }

    public boolean isOpen(int row, int col) {
        validateInput(row, col);
        return grid[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        return (isOpen(row, col) && uf.connected(0,getUFNumber(row, col)));
    }

    public int numberOfOpenSites() {
        return this.openSiteCount;
    }

    private void validateInput(int row, int col) {
        if (row < 1 || col < 1 || row > gridLength || col > gridLength) {
            throw new IllegalArgumentException("Please provide input within range");
        }
    }

    private boolean isValidSite(int row, int col) {
        if (row < 1 || col < 1 || row > gridLength || col > gridLength) {
            return false;
        }
        return true;
    }

    public boolean percolates() {
       /* for(int i=gridLength; i>0;i--){
            if(isFull(gridLength,i)){
                return true;
            }
        }
        return false;*/
        return uf.connected(0, gridSize + 1);
    }

    public static void main(String[] args) {
       /* Percolation percolation = new Percolation(3);
        System.out.println(percolation.isFull(1,1));
        percolation.open(1, 1);
        percolation.open(3, 2);
        percolation.open(2, 2);
        System.out.println(percolation.numberOfOpenSites());
        System.out.println(percolation.percolates());
        percolation.open(2, 1);
        System.out.println(percolation.numberOfOpenSites());
        System.out.println(percolation.percolates());*/
    }
}
