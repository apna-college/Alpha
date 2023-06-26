/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:

    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

 */

public class Array12_ProductOfArrayExceptSelf {

    public static void product(int[] arr) {
        int n = arr.length; //size of array

        int[] prefix = new int[n];
        prefix[0] = 1;  //first element will be always 1
        for(int i = 1; i < n; i++) {    //loop starts from first
            prefix[i] = prefix[i-1]*arr[i-1];   //calculate prefix
        }

        int[] suffix = new int[n];
        suffix[n-1] = 1;    //last element will be always 1
        for(int i = n-2; i >= 0; i--) { //loop starts from last
            suffix[i] = suffix[i+1]*arr[i+1];   //calculate suffix
        }

        for(int i = 0; i < n; i++) {
            arr[i] = prefix[i]*suffix[i];   //calculating the product
        }

        System.out.print("Product of Array >> ");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.err.print(arr[i] +" ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {-1,1,0,-3,3};

        product(arr1);
    }
}
