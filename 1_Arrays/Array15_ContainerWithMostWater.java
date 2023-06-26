/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1

 */

public class Array15_ContainerWithMostWater {

    public static int mostWater(int[] arr) {    //TC -> O(n)
        int leftPoint = 0, rightPoint = arr.length-1;   //two pointers
        int maxWater = Integer.MIN_VALUE; 

        while(leftPoint < rightPoint) {
            int height = Math.min(arr[leftPoint], arr[rightPoint]); //water can store in minimum height
            int width = rightPoint-leftPoint;   //calculate width
            int currentWater = height * width;  //calculate current water
            maxWater = Math.max(maxWater,currentWater);

                //changing pointers
            if(arr[leftPoint] < arr[rightPoint]) {
                leftPoint++;
            } else {
                rightPoint--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,8,6,2,5,4,8,3,7};

        System.out.println("Maximum water can store >> "+mostWater(arr1));
    }
}
