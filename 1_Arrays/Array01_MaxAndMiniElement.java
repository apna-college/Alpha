/*
Q. Given an array of size N. The task is to find the maximum and the minimum element of the array using the minimum number of comparisons.

Examples:
    Input: arr[] = {3, 5, 4, 1, 9}
    Output: Minimum element is: 1
            Maximum element is: 9

    Input: arr[] = {22, 14, 8, 17, 35, 3}
    Output:  Minimum element is: 3
            Maximum element is: 35
*/

public class Array01_MaxAndMiniElement{

        //search for maximum element in array
    public static int maxElement(int arr[]){    //TC -> O(n)
        int max = Integer.MIN_VALUE; //take minimum value such as -infinity
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){   //compare
                max = arr[i];
            }
        }
        return max;
    }

        //search for minimum element in a array
    public static int minElement(int arr[]){    //TC -> O(n)
        int min = Integer.MAX_VALUE;    //take maximum value such as +infinity
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){   //compare
                min = arr[i];
            }
        }
        return min;
    }
    public static void main(String args[]){
        int arr1[] = {3, 5, 4, 1, 9};
        int arr2[] = {22, 14, 8, 17, 35, 5};
        int arr3[] = {1000, 11, 445, 1, 330, 3000};
        int arr[] = {1000, 11, 445, 1, 330, 3000, 3, 5, 4, 1, 9, 22, 14, 8, 17, 35, 5};
        System.out.println("Maximum element -> "+ maxElement(arr));
        System.out.println("Minimum element -> "+ minElement(arr));
    }
}