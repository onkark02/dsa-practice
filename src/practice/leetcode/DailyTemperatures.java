package practice.leetcode;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] nums = {73,74,75,71,69,72,76,73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] result = dailyTemperatures.dailyTemperatures(nums);
        System.out.println("----------");
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i=temperatures.length-1; i>=0; i--){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    result[i] = stack.peek() - i;
                    stack.push(i);
                }
            }
        }
        return result;
    }
}
