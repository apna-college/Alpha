/*
Q. Given an array (or string), the task is to reverse the array/string.
Examples : 
Input  : arr[] = {1, 2, 3}
Output : arr[] = {3, 2, 1}

Input :  arr[] = {4, 5, 1, 2}
Output : arr[] = {2, 1, 5, 4}
 */

public class Array02_ReverseArray {
        /*----Approach 1 --> Iterative way ----*/
    public static void reverseArray(int arr[]){ //TC -> O(n)
        int startIndex = 0; //always start from index 0
        int endIndex = arr.length-1;  //array have 0 to n-1 index & n is the size of array
        while(startIndex < endIndex){
                //swap
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;

                //change index
            startIndex++;
            endIndex--;
        }
        
    }
                    /*---- ----*/
        /*----Approach 2 --> recursive way ----*/
    public static void reverseArray(int arr[], int startIndex, int endIndex){   //TC -> O(n)
            //base case
        if(startIndex >= endIndex){
            return;
        }
            //swap
        int  temp = arr[startIndex];
        arr[startIndex] = arr[endIndex];
        arr[endIndex] = temp;

            //calling recursive function
        reverseArray(arr, startIndex+1, endIndex-1);
    }
                    /*---- ----*/
        //print array
    public static void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int arr1[] = {1, 2, 3} , arr2[] = {4, 5, 1, 2};
        int arr[] = {1, 2, 3, 4, 5, 1, 2};
        System.out.print("original Array -> ");
        printArray(arr2);

        reverseArray(arr2);
        // reverseArray(arr, 0, arr.length-1);

        System.out.print("new Array -> ");
        printArray(arr2);
    }
}
