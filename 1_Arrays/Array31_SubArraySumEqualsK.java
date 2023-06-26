/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.
 
Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
 
Constraints:
    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107
 */

public class Array31_SubArraySumEqualsK {

    public static int subArrayNumber(int[] arr, int k) { //TC -> O(n^2) || O(1)
        int count = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == k) count++;
            int j = i+1;
            int sum = arr[i];
            while(i < j) {
                sum += arr[j];
                if(sum == k) count++;
                j--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,1};
        int[] arr2 = {1,2,3};

        System.out.println(subArrayNumber(arr1, 1));
    }
}