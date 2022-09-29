import java.util.*;

public class binarySearchRotatedArray {
    public static int findMin(int arr[], int n){
        int left = 0, right = n-1, mid = (left+right)/2;
        while(left <= right){
            mid = (left+right)/2;
            if(arr[mid-1] >= arr[mid]){
                return mid;
            }
            else if(arr[mid] >= arr[left] && arr[mid] > arr[right]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return mid;
    }

    public static int binarySearch(int arr[], int n, int key){
        int min = findMin(arr, n);
        int left = 0, right = n-1;

        if(arr[min] <= key && key <= arr[n-1]){ 
            left = min;
        } 
        
        else{ 
            right = min;
        } 

        while(left <= right){
            int mid = (left + right)/2; 
            if(arr[mid] ==   key){ 
                return mid; 
            } 
            else if(arr[mid] > key){ 
                right = mid-1; 
            } 
            else{ 
                left = mid+1; 
            } 
        }
        return -1;
    }
    
    public static void main(String[] args){
        // input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter key: ");
        int key = sc.nextInt();

        int ans = binarySearch(arr, n, key);
        System.out.println(ans);

        sc.close();
    }
}
