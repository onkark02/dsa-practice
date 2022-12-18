package com.coursera.algo1.week2;

public class ArrayStack {
    private int[] arrayStack;
    private int top;

    public ArrayStack(){
        arrayStack = new int[1];
        top=0;
    }
    public boolean isEmpty(){
        return top==0;
    }
    public int pop(){
        if(top > 0 && top == arrayStack.length/4){
            resize(arrayStack.length/2);
        }
        return arrayStack[--top];
    }
    public void push(int n){
        if(top==arrayStack.length){
            resize(2*arrayStack.length);
        }
        arrayStack[top++]=n;
    }
    public void resize(int n){
        int[] temp = new int[n];
        for (int i = 0; i < top; i++) {
            temp[i] = arrayStack[i];
        }
        arrayStack = temp;
    }
    public int getSize(){
        return arrayStack.length;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        System.out.println(stack.isEmpty());
        System.out.println("Size: " + stack.getSize());
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(8);
        stack.push(8);
        System.out.println("Size: " + stack.getSize());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println("Size: " + stack.getSize());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println("Size: " + stack.getSize());
        System.out.println(stack.pop());
        System.out.println("Size: " + stack.getSize());
        System.out.println(stack.pop());
        System.out.println("Size: " + stack.getSize());
        System.out.println(stack.pop());
        System.out.println("Size: " + stack.getSize());
    }
}
