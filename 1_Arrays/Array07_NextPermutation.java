/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].

The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

    For example, the next permutation of arr = [1,2,3] is [1,3,2].
    Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
    While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.

Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:
Input: nums = [1,1,5]
Output: [1,5,1]

 

Constraints:
    1 <= nums.length <= 100
    0 <= nums[i] <= 100

 */

public class Array07_NextPermutation {

    public static void nextPermutation (int[] arr) {    //TC -> O(n)
        int sizeOfArray = arr.length-1;
        int pivotPoint = 0;
            //find out pivot point
        for(int i = sizeOfArray-1; i >= 0; i--) {
            if(arr[i] < arr[i+1]) {
                pivotPoint = i;
                break;
            }
        }

        if( pivotPoint == 0) {  //when we don't find out any pivot point in array.....that's mean array is in descending order --> reverse whole array
            reverseArray(arr, 0, sizeOfArray);
        } else {    //when we find out our pivot point --> find out right most successor of pivot in suffix
            int successor = 0;
            for(int i = sizeOfArray; i > pivotPoint; i--) {
                if(arr[i] > arr[pivotPoint]) {
                    successor = i;
                    break;
                }
            }

                //swap -> pivotPoint and successor
            int temp = arr[pivotPoint];
            arr[pivotPoint] = arr[successor];
            arr[successor] = temp;

                //reverse in range of successor+1 to arr.length-1
            reverseArray(arr, pivotPoint+1, sizeOfArray);
        }

    }

        //reverse in range
    public static void reverseArray(int[] arr, int startIndex, int endIndex) {
        while(startIndex < endIndex) {  
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;

            startIndex++;
            endIndex--;
        }
    }

            //print the array
    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n--------------------------");
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {3,2,1};
        int[] arr3 = {1,1,5};
        int[] arr4 = {2,4,1,7,5,0};
        int[] arr5 = {1,2,3,6,5,4};

        System.out.print("Next permutation -> ");
        nextPermutation(arr5);
        printArray(arr5);

    }
}
