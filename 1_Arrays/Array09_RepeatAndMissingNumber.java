import java.util.Arrays;

/*
Given an unsorted array of size n. Array elements are in the range of 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in the array. Find these two numbers.

Examples: 

    Input: arr[] = {3, 1, 3}
    Output: Missing = 2, Repeating = 3
    Explanation: In the array, 2 is missing and 3 occurs twice 

    Input: arr[] = {4, 3, 6, 2, 1, 1}
    Output: Missing = 5, Repeating = 1

 */

public class Array09_RepeatAndMissingNumber {

    /*---- Approach 1 -> TC -> O(n) | SC -> O(n) ----*/
    public static void repeatingAndMissingNumber1(int[] arr) {
        int n = arr.length; //size of array
        int[] temp  = new int[n];

        for(int i = 0; i < n; i++) {
            temp[arr[i]-1]++;   //for every value in array increase by 1 in (array[i]-1) location of temp array
        }

        for(int i = 0; i < n; i++) {
            if(temp[i] > 1) {   //if any value is greater than 1...that's mean duplicate value is index+1
                System.out.println("Repeating Number >> " + (i+1));
            }
            if( temp[i] < 1) {  //if any value is less than 1 or 0......that's mean index+1 is missing value
                System.out.println("Missing number >> "+ (i+1));
            }
        }
    }
                        /*---- ----*/

    /*---- Approach 2 -> TC -> O(n*log(n)) | SC -> O(1) ----*/
    public static void repeatingAndMissingNumber2(int[] arr) {
        Arrays.sort(arr);   //java in-build array...... TC -> O(n*log(n))

        int n = arr.length; //Size of array
        for(int i = 0; i < n-1; i++) {
            if(arr[i] == arr[i+1]) {    //if current element and it's next element is equal..... that's mean ith element is repeating
                System.out.println("Repeating Number >> "+arr[i]);
            }
        }

        int temp = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] - temp > 1) { //if current element - temp(previous element) is greater than 1..... that's mean there is a gap(means a missing element)
                System.out.println("Missing Number >> "+(temp+1));
            }
            temp = arr[i];
        }
    }
                        /*---- ----*/

    

    public static void main(String[] args) {
        int[] arr1 = {3,1,3};
        int[] arr2 = {4,3,6,2,1,1};
        int[] arr3 = {7,3,4,5,5,6,2};

        repeatingAndMissingNumber1(arr2);
        System.out.println("--------------------------");
        repeatingAndMissingNumber2(arr2);
    }
}
