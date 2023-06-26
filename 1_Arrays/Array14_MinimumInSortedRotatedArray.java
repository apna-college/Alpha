/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Example 2:
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

Example 3:
Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 

Constraints:
    n == nums.length
    1 <= n <= 5000
    -5000 <= nums[i] <= 5000
    All the integers of nums are unique.
    nums is sorted and rotated between 1 and n times.
 */

public class Array14_MinimumInSortedRotatedArray {

    public static int minimum (int[] arr) {
        if(arr[0] < arr[arr.length-1]) {    //when array is only sorted not rotated
            return arr[0];
        } else {    //when array is sorted and rotated
            int startIndex = 0, endIndex = arr.length-1;
            while(startIndex < endIndex) {
                int midIndex = startIndex+(endIndex-startIndex)/2;  //calculating midIndex

                if(arr[midIndex] < arr[endIndex]) { //minimum value lies on left side of midIndex
                    endIndex = midIndex;    //re-assigned endIndex
                } else {    //minimum value lies on the right side of midIndex
                    startIndex = midIndex+1;    //re-assigned startIndex
                }
            }
            return arr[startIndex];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {3,4,5,1,2};
        int[] arr2 = {4,5,6,7,0,1,2};
        int[] arr3 = {11,13,15,17};
        int[] arr4 = {5,1,2,3,4};
        int[] arr5 = {2,4,5,6,7,0};

        System.out.println(minimum(arr3));

    }
}
