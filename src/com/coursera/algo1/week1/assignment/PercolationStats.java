package com.coursera.algo1.week1.assignment;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {

    final private double mean, stdDev, confidenceLo, confidenceHi, gridSize;
    private double[] results;
    final private int gridLength;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Please provide non-zero input parameters");
        }
        gridSize = n * n;
        gridLength = n;
        results = new double[trials];
        for (int i = 0; i < trials; i++) {
            results[i] = getResult(n);
        }
        mean = StdStats.mean(results);
        stdDev = StdStats.stddev(results);
        confidenceLo = mean - (1.96 * stdDev / Math.sqrt(trials));
        confidenceHi = mean + (1.96 * stdDev / Math.sqrt(trials));
        /*StdOut.println("mean = " + mean);
        StdOut.println("stddev = " + stdDev);
        StdOut.println("95% confidence interval = [" + confidenceLo + ", " + confidenceHi + "]");*/
    }

    private double getResult(int n) {
        Percolation percolation = new Percolation(n);
        int count = 0;
        int randomNumber, row, col;
        while (!percolation.percolates()) {
            randomNumber = StdRandom.uniform(0, (int) gridSize);
            row = (randomNumber / gridLength) + 1;
            col = (randomNumber % gridLength) + 1;
            if (!percolation.isOpen(row, col)) {
                percolation.open(row, col);
                count++;
            }
        }
        return count / gridSize;
    }

    // sample mean of percolation threshold
    public double mean() {
        return this.mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return this.stdDev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return this.confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return this.confidenceHi;
    }

    // test client (see below)
    public static void main(String[] args) {
        /* Stopwatch stopwatch = new Stopwatch();
        PercolationStats percolationStats = new PercolationStats(2000, 100);
        System.out.println("Time elapsed for weighted quick-union UF (n=200,trial=100): " + stopwatch.elapsedTime());*/
    }

    /* Time elapsed for quick-find UF (n=200,trial=100): 47.086
     * Time elapsed for quick-union UF (n=200,trial=100): 3.152
     * Time elapsed for weighted quick-union UF (n=200,trial=100): 0.363 */
}