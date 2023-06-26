/*
Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 */

public class Array13_MaximumProductSubArray {

    public static void maximumProduct(int[] arr) {
        int max = arr[0], min = arr[0], ans = arr[0];

        for(int i = 1; i < arr.length; i++) {
            int temp = max; //store current max value for further calculation

            max = Math.max(arr[i], Math.max(max * arr[i], min * arr[i]));
            min = Math.min(arr[i], Math.min(min * arr[i], temp * arr[i]));

            if(max > ans) {
                ans = max;
            }
        }

        System.out.println("Maximum Product SubArray >> "+ans);
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,-2,4};
        int[] arr2 = {2,-5,-2,-4,3};
        int[] arr3 = {0,2};
        int[] arr4 = {-2,0,-1};

        maximumProduct(arr2);
    }
}