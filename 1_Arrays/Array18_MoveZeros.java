/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]

Constraints:

    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1

 */

public class Array18_MoveZeros {

    public static void moveZero(int[] arr) {    //TC -> O(n) | SC ->O(1)
        int zero = 0, i = 0;    //tow pointers

        while(i < arr.length) {
            if(arr[zero] == 0 && arr[i] != 0) {     //if we found zero and non zero value swap them......
                    //swap
                arr[zero++] = arr[i];
                arr[i] = 0;
            } else if(arr[zero] != 0) { //if current element is not zero....move to the next
                zero++;
            }
            i++;
        }

        printArray(arr);    //print the array
    }

    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {0,1,0,3,12};
        int[] arr2 = {0};
        int[] arr3 = {0,0,0,1,4,5,0,0,0};
        int[] arr4 = {0,1,0,2,0,3,0,4,0,5,0,6,0,7,0,8,0,9,0,0};

        moveZero(arr4);
    }
}
