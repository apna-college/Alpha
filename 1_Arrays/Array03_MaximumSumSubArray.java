/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23. 

Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */

public class Array03_MaximumSumSubArray {

        /*---- kadaen's method ----*/
    public static int maxSumOfSubArray(int arr[]){
            //step 1 -> initialize values
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE; //it refers to -infinity

            //step 2 -> run a loop and do work
        for(int i = 0; i < arr.length; i++){
            currSum += arr[i];//sum 
            if(currSum <= 0){   //if current sum less then 0, then reassigned the value 0 to current sum
                currSum = 0;
            }
            if(maxSum < currSum){   //compare current sum and maximum sum
                maxSum = currSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int nums1[] = {-2,1,-3,4,-1,2,1,-5,4};
        int nums2[] = {1};
        int nums3[] = {5,4,-1,7,8};
        System.out.println("Maximum sum SubArray -> "+maxSumOfSubArray(nums3));
    }
}
