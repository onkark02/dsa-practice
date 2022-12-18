package com.coursera.algo2.week2;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }
    private void assignJobs() {
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        PriorityQueue<TaskExecutioner> scheduler = new PriorityQueue<>(new Comparator<TaskExecutioner>() {
            @Override
            public int compare(TaskExecutioner o1, TaskExecutioner o2) {
                if(o1.endTime == o2.endTime){
                    return Integer.compare(o1.workerId,o2.workerId);
                }
                return Long.compare(o1.endTime,o2.endTime);
            }
        });
        //Initialize priority queue with all thread and with end time as 0
        for(int i=0; i<numWorkers; i++){
            scheduler.add(new TaskExecutioner(i,0));
        }

        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            TaskExecutioner nextFreeExecutioner = scheduler.poll();
            assignedWorker[i] = nextFreeExecutioner.workerId;
            startTime[i] = nextFreeExecutioner.endTime;
            nextFreeExecutioner.endTime += duration;
            scheduler.add(nextFreeExecutioner);
        }
    }

    private void assignJobsNaive() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        long[] nextFreeTime = new long[numWorkers];
        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            int bestWorker = 0;
            for (int j = 0; j < numWorkers; ++j) {
                if (nextFreeTime[j] < nextFreeTime[bestWorker])
                    bestWorker = j;
            }
            assignedWorker[i] = bestWorker;
            startTime[i] = nextFreeTime[bestWorker];
            nextFreeTime[bestWorker] += duration;
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    private class TaskExecutioner {
        int workerId;
        long endTime;
        public TaskExecutioner(int workerId, long endTime){
            this.workerId = workerId;
            this.endTime = endTime;
        }
    }
    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
