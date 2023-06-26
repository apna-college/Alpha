/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
 
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

 

Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.

 
Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */

import java.util.ArrayList;
import java.util.Arrays;
public class Array28_2Sum {

    public static void _2sum(int[] arr, int target) {   //TC->O(n)
        ArrayList<Integer> list =  new ArrayList<>();

        Arrays.sort(arr); //Sort the array

        int start = 0, end = arr.length-1; //two pointers

        while(start < end) {
            int sum = arr[start] + arr[end];
            if(sum == target) {
                list.add(arr[start]);
                list.add(arr[end]);

                System.out.println(list);
                return;
            } else if(sum > target) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) {
        int[] arr1 = {2,7,11,15,10,-1,-2,8,3};//(-2,-1,2,3,7,8,10,11,15)
        int target1 = 11;
        
        int[] arr2 = {3,2,4};
        int target2 = 6;

        int[] arr3 = {};

        _2sum(arr1, target1);
    }
}
