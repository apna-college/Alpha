/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

Constraints:
1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Array33_4Sum {

    public static void _4Sum(int[] arr, int target) {
        List<List<Integer>> output = new ArrayList<>();
        int n = arr.length; //size of array

        Arrays.sort(arr);   //sort the array

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int start = j+1, end = n-1;

                while(start < end) {
                    int sum = arr[i]+arr[j]+arr[start]+arr[end];

                    if(sum == target) {
                        output.add(Arrays.asList(arr[i],arr[j],arr[start],arr[end]));
                        start++;
                        end--;

                        while(start < end && arr[start] == arr[start+1]) start++;
                        while(start < end && arr[end] == arr[end-1]) end--;
                    } else if(sum > target) {
                        end--;
                    } else {
                        start++;
                    }

                }
                while(j+1 < n && arr[j] == arr[j+1]) j++;
            }
            while(i+1 < n && arr[i] == arr[i+1]) i++;
        }

        System.out.println(output);
    }

    public static void main(String[] args) {
        int[]arr1 = {1,0,-1,0,-2,2};
        int target1 = 0;
        
        int[] arr2 = {2,2,2,2,2};
        int target2 = 8;

        _4Sum(arr1, target1);
    }
}
