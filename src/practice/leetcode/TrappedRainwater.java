package practice.leetcode;

public class TrappedRainwater {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }
    public static int trap(int[] height){
        int waterStored = 0;
        int left=0, right = height.length -1;
        while(left <= right){
            int minHeight = Math.min(height[left], height[right]);
            if(height[left] < height[right]){
                left++;

            }else {

            }
        }
        return waterStored;
    }
/*
    public static int trap(int[] height) {
        int waterStored = 0, left=0, right=1;

        while(left < height.length - 1){
            right = left +1;
            int maxRight=right;
            while(right < height.length && height[right] < height[left]){
                if(height[right] > height[maxRight])
                    maxRight = right;
                right++;
            }
            if(right == height.length){
                right = maxRight;
            }
            int minHeight = Math.min(height[left], height[right]);
            for(;++left < right;){
                waterStored += minHeight-height[left];
            }
            left = right;
        }
        return waterStored;
    }*/
}
