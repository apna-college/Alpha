/*
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1

Constraints:
    1 <= nums.length <= 5000
    -104 <= nums[i] <= 104
    All values of nums are unique.
    nums is an ascending array that is possibly rotated.
    -104 <= target <= 104
 */

public class Array06_SearchRotatedSortedArray {
            /*---- iterative method ----*/
    public static int searchTarget(int arr[], int target){

        int startIndex = 0;
        int endIndex = arr.length-1;

        while(startIndex <= endIndex){  //when startIndex is greater than endIndex our loop will stop running
                //step 1 -> find out mid 
            int midIndex = startIndex+(endIndex - startIndex)/2;
                //step 2 -> when target at midIndex
            if(arr[midIndex] == target){
                return midIndex;
            }
                //step 3
                    //Case 1 -> mid lies on Line1
            if(arr[startIndex] <= arr[midIndex]){
                     //when target lies left side of Line1  
                if(arr[startIndex] <= target && target <= arr[midIndex]){
                    endIndex  = midIndex-1;
                }
                     //when target lies right side of Line1(that's mean half of Line1 and whole Line2)
                else{
                    startIndex = midIndex+1;
                }
            }
                    //case 2 -> mid lies on Line2
            else{
                    //when target lies right side of Line2
                if(arr[midIndex] <= target && target <= arr[endIndex]){
                    startIndex = midIndex+1;
                }
                    //when target lies left side of Line2(that's mean half of Line2 and whoLe Line1)
                else{
                    endIndex = midIndex+1;
                }
            }
        }
        
        return -1;  //when target is not there in array
    }
                    /*---- ----*/

            /*---- recursive method ----*/
    public static int searchTarget(int arr[], int target, int startIndex, int endIndex){    //TC -> O(log n)
            //base case
        if(startIndex > endIndex){
            return -1;  //when target is not there in array
        }
            //step 1 -> find out mid 
        int midIndex = startIndex+(endIndex-startIndex)/2;
            //step 2 -> when target at midIndex
        if(arr[midIndex] == target){
            return midIndex;  
        }
            //step 3
                //Case 1 -> mid lies on Line1
        if(arr[startIndex] <= arr[midIndex]){
                //when target lies left side of Line1
            if(arr[startIndex] <= target && target <= arr[midIndex]){
                return searchTarget(arr, target, startIndex, midIndex-1);
            }
                //when target lies right side of Line1(that's mean half of Line1 and whole Line2)
            else{
                return searchTarget(arr, target, midIndex+1, endIndex);
            }
        }
                //case 2 -> mid lies on Line2
        else{
                //when target lies right side of Line2
            if(arr[midIndex] <= target && target <= arr[endIndex]){
                return searchTarget(arr, target, midIndex + 1, endIndex);
            }
                //when target lies left side of Line2(that's mean half of Line2 and whoLe Line1)
            else{
                return searchTarget(arr, target, startIndex, midIndex);
            }
        }
    }
                /*---- ----*/

    public static void main(String args[]) {
        int nums[] = {4,5,6,7,0,1,2};
        int result = searchTarget(nums, 6);
        if(result == -1){
            System.out.println("Your targe is not in the array");
        }
        else{
            System.out.println("target found at index "+result);
        }
    }
}
