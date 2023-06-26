/*
Given an array of N integers where each value represents the number of chocolates in a packet.Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that: 
    Each student gets one packet.
    The difference between the number of chocolates in the packet with maximum chocolates and the packet with minimum chocolates given to the students is minimum.

Examples:
    Input : arr[] = {7, 3, 2, 4, 9, 12, 56} , m = 3 
    Output: Minimum Difference is 2 
    Explanation:
    We have seven packets of chocolates and we need to pick three packets for 3 students 
    If we pick 2, 3 and 4, we get the minimum difference between maximum and minimum packet sizes.

    Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12} , m = 5 
    Output: Minimum Difference is 6 

    Input : arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50} , m = 7 
    Output: Minimum Difference is 10 
 */

import java.util.Arrays;
public class Array05_ChocolateDistributionProblem {

    public static int minDiff(int arr[], int m){    //TC -> O(n*log(n))
            //step 1 -> sort the array(we can use java in build sorting algo <<or>> we can make our own sorting algo)
        Arrays.sort(arr);   //java built in sort
        // bubbleSort(arr);    //we can also use .... user defined sorting instate of build in sort
            //step 2 -> initialize +infinity & run a loop
        int minDiff = Integer.MAX_VALUE;    //+infinity
        for(int i = 0; i < arr.length; i++){
                //step 3 -> difference between maximum and minimum
            int diff = arr[i+m-1]-arr[i];
                //step 4 -> compare
            if(minDiff > diff){
                minDiff = diff;
            }
                    //corner case -> this will stop the loop 
            if((i+m-1) >= arr.length-1){
                break;
            }
        }

        return minDiff;
    }
        /*---- Bubble Sort algo ----*/
    public static void bubbleSort(int arr[]){
        for(int i = 0; i < arr.length-1; i++){
            int track = 0;
            for(int j = 0; j < arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                        //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]  = temp;
                    track++;
                }
            }
            if(track == 0){
                break;
            }
        }
    }
                /*---- ----*/

    public static void main(String args[]){
        int arr1[] = {7, 3, 2, 4, 9, 12, 56};
        int arr2[] = {3, 4, 1, 9, 56, 7, 9, 12};
        int arr3[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int arr_worstCase[] = {32,24,15,46,52,57,5,39};
        
        System.out.println("Minimum difference -> "+minDiff(arr_worstCase, 2));
        
        
    }
}
