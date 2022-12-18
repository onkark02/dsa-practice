package com.coursera.algo1.week1;

public class SuccessorWithDeleteExample {
    private int[] succesor;
    private int[] predecessor;
    public SuccessorWithDeleteExample(int n){
        succesor = new int[n];
        predecessor = new int[n];
        for (int i = 0; i < n-1; i++) {
            succesor[i]=i+1;
        }
        succesor[n]=n-1;
    }
    public void remove(int n){

    }
    public int getSuccessor(int n){
        return 0;
    }

    public static void main(String[] args) {
        SuccessorWithDeleteExample successorWithDeleteExample = new SuccessorWithDeleteExample(5);
        successorWithDeleteExample.remove(3);
        successorWithDeleteExample.remove(2);
        System.out.println(successorWithDeleteExample.getSuccessor(1));
    }
}
