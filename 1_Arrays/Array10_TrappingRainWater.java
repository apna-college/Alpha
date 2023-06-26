/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

 */

public class Array10_TrappingRainWater {

    public static int totalWater(int[] height) {
        int n = height.length;

            //calculate left max boundary
        int[] leftMaxBoundary = new int[n];
        leftMaxBoundary[0] = height[0]; //always first bar height is leftMaxBoundary for first bar
        for(int i = 1; i < n; i++) { //store from left side
            leftMaxBoundary[i] = Math.max(height[i], leftMaxBoundary[i-1]);
        }
        
            //calculate right max boundary
        int[] rightMaxBoundary = new int[n];
        rightMaxBoundary[n-1] = height[n-1]; //always last bar height is rightMaxBoundary for last bar
        for(int i = n-2; i >= 0; i--) { //stores from right side
            rightMaxBoundary[i] = Math.max(height[i], rightMaxBoundary[i+1]); 
        }

            //calculate total trapped water
        int totalTrappedWater = 0;
        for(int i = 0; i < n; i++) {
                //water level = min(left side max height, right side max height)
            int waterLV= Math.min(leftMaxBoundary[i], rightMaxBoundary[i]); //calculate the water level on a bar
                //trapped water on a bar = water level - height
            totalTrappedWater += (waterLV-height[i]);   //to calculate area of water on a bar -> no need to multiple by 1....cause it gives same ans)
        }

        return totalTrappedWater;
    }

    public static void main(String[] args) {
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1}; 
        int[] height2 = {4,2,0,3,2,5}; 
        int[] height3 = {4,2,0,6,3,2,5}; 

        System.out.println("Total Trapped Water >> "+totalWater(height2));
    }
}
