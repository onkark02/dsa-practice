package practice.leetcode;

import java.util.Stack;

public class LargestAreaInHistogram {
    public static void main(String[] args) {
        LargestAreaInHistogram solution = new LargestAreaInHistogram();
        int[] arr = {2,1,5,6,2,3};
        System.out.println(solution.largestRectangleArea(arr));
    }
    public int largestRectangleArea(int[] heights) {
        int[] leftBound = new int[heights.length];
        int[] rightBound = new int[heights.length];

        Stack<Integer> stack = new Stack<>();

        for(int i=heights.length-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            if(stack.isEmpty()){
                rightBound[i] = heights.length;
            }else{
                rightBound[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            if(stack.isEmpty()){
                leftBound[i] = -1;
            }else{
                leftBound[i] = stack.peek();
            }
            stack.push(i);
        }

        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            int area = heights[i] * (rightBound[i]-leftBound[i]-1);
            if(area > maxArea)
                maxArea = area;
        }

        return maxArea;
    }
}
