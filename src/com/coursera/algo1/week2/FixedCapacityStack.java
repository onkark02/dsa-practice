package com.coursera.algo1.week2;

public class FixedCapacityStack {
private int[] stackArray;
private int top;
public FixedCapacityStack(int n){
    stackArray=new int[n];
    top=0;
}
public boolean isEmpty(){
    return top==0;
}
public void push(int n){
    if(!isFull())
    stackArray[top++]=n;
    else
        throw new RuntimeException("Array is full");
}
private boolean isFull(){
    return top == stackArray.length;
}
public int pop(){
    if(!isEmpty())
        return stackArray[--top];
    else
        throw new RuntimeException("Array is empty");
}

    public static void main(String[] args) {
        FixedCapacityStack stack = new FixedCapacityStack(5);
        System.out.println(stack.isEmpty());
        stack.push(5);
        stack.push(3);
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
    }
}
