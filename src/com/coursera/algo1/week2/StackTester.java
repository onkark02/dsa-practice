package com.coursera.algo1.week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackTester {
    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s == "-"){
                StdOut.print(stack.pop());
            }else{
                stack.push(s);
            }
        }
    }
}
