/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
 
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 
Constraints:
    3 <= nums.length <= 3000
    -105 <= nums[i] <= 105
 */


import java.util.ArrayList;
import java.util.Arrays;
public class Array29_3Sum {

    public static void _3Sum(int[] arr) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> num = new ArrayList<>();
        int n = arr.length;

        Arrays.sort(arr);   //sorting the array

        for(int i = 0; i < n-1; i++) {
            int start = i+1, end = n-1;
            
            while(start < end) {
                int sum = arr[i]+arr[start]+arr[end];

                if(sum == 0) {
                    num.add(0, arr[i]);
                    num.add(1, arr[start]);
                    num.add(2, arr[end]);
                    start++;
                    end--;
                } else if(sum > 0) {
                    end--;
                } else {
                    start++;
                }

                list.add(num);
            }
        }

        System.out.println(list);

    }

    public static void main(String[] args) {
        int[] arr1 = {-1,0,1,2,-1,-4};  //[-4,-1,-1,0,1,2]
        int[] arr2 = {0,1,1};
        int[] arr3 = {0,0,0};
        int[] arr = {};

        _3Sum(arr1);

    }
}
