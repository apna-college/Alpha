/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 
Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 
Constraints:
    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109
 
Follow-up: Could you solve the problem in linear time and in O(1) space?
 */


import java.util.Arrays;
public class Array21_MajorityElement {

    public static int bruteForce(int[] arr) {   //TC -> O(n*log(n)) | SC -> O(1)
        Arrays.sort(arr);
        return arr[arr.length/2];
    }

    public static int majorityElement(int[] arr) { //TC -> O(n) | SC -> O(1)
        int candidate = 0, vote = 0;

        for(int a : arr) {
            if(vote == 0) {
                candidate = a;
            }

            if(candidate == a) {
                vote++;
            } else {
                vote--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,2,3};
        int[] arr2 = {1,2,1,2,2,1,2};
        int[] arr3 = {2,2,2,2,1,1,1};
        int[] arr4 = {1,1,1,2,2,2,2};
        int[] arr5 = {1,2,2,2,2,1,1};
        int[] arr6 = {2,2,1,1,1,2,2};

        System.out.println("Majority Element -> "+ majorityElement(arr4));
    }
}
