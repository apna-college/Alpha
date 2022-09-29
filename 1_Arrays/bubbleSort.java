import java.util.*;
public class bubbleSort {

    public static void bubble_sort(int arr[], int n){
        for(int turn = 0; turn < n-1; turn++){
            for(int j = 0; j < n-turn-1; j++){
                if(arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void bubble_sort_optimized(int arr[], int n){
        for(int turn = 0; turn < n-1; turn++){
            int swaps = 0;
            for(int j = 0; j < n-turn-1; j++){
                if(arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps++;
                }
            }
            if(swaps == 0){
                break;
            } // this will break the loop if remaining array or full array is already sorted and will not run test cases for each iteraltion and each element.
        }
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        bubble_sort_optimized(arr, n);

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
