/*
Find if there is a pair with a given sum in the rotated sorted Array.
Given an array arr[] of distinct elements size N that is sorted and then around an unknown point, the task is to check if the array has a pair with a given sum X.

Examples : 

    Input: arr[] = {11, 15, 6, 8, 9, 10}, X = 16
    Output: true
    Explanation: There is a pair (6, 10) with sum 16

    Input: arr[] = {11, 15, 26, 38, 9, 10}, X = 35
    Output: true
    Explanation: There is a pair (26, 9) with sum 35

    Input: arr[] = {11, 15, 26, 38, 9, 10}, X = 45
    Output: false
    Explanation: There is no pair with sum 45.

 */

public class Array16_GivenSumPair {

    public static boolean isSumPair(int[] arr, int X) { //TC -> O(n) || SC -> O(1)
        int n = arr.length; //size of array
        int p = 0, pNext = 0; 
            //run a loop to find out pivot point
        for(int i = 0; i < n-1; i++) {
            if(arr[i] > arr[i+1]) {
                p = i;
                pNext = i+1;
                break;
            }
        }

            //now find out the ans
        while(p != pNext) {
            int sum = arr[p] + arr[pNext];

            if(sum > X) {
                p = (n+p-1) % n;    //change the pivot point
            } else if(sum < X) {
                pNext = (pNext+1) % n;  //change pivotNext point
            } else {
                return true;    //when sum and X are equal
            }
        }

        return false;   //when all pairs dose not equal to X
    }
    public static void main(String[] args) {
        int[] arr1 = {11, 15, 6, 8, 9, 10};
        int x1 = 16;

        int[] arr2 = {11, 15, 26, 38, 9, 10};
        int x2 = 35;

        int[] arr3 = {11, 15, 26, 38, 9, 10};
        int x3 = 45;

        System.out.println(isSumPair(arr1, x1));

    }
}
