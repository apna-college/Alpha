/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 
Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 
Constraints:
    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in non-decreasing order.
 
Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */


public class Array23_SquareOfSortedArray {
    public static void squareOfArray(int[] arr) {   //TC -> O(n) | SC -> O(n)
        int leftIndex = 0, rightIndex = arr.length-1;
        int[] newArr = new int[arr.length];
        for(int i = arr.length-1; i >= 0; i--) {
            if(Math.abs(arr[leftIndex]) >= Math.abs(arr[rightIndex])) {
                newArr[i] = arr[leftIndex]*arr[leftIndex];
                leftIndex++;
            } else {
                newArr[i] = arr[rightIndex]*arr[rightIndex];
                rightIndex--;
            }
        }

        printArray(newArr);
    }

    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {-4,-1,0,3,10};
        int[] arr2 = {-7,-3,2,3,11};
        int[] arr3 = {-10,-6,-4,-3,-2};
        
        squareOfArray(arr1);
    }
}
