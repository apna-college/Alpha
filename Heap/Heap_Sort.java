package Heaps;

public class Heap_Sort {
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,3};
        heap_sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void heap_sort(int arr[]) { // O(n*logn)
        // step 1 - create max heap

        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) { // n * logn
            heapify(arr, i, n);   // logn
        }

        // step 2 - 
        for (int i = n-1; i >= 0; i--) {  // n * logn
            // swap - last and first
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp ;

            heapify(arr, 0, i);  // --- logn
        }
    }

    public static void heapify(int arr[], int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i+2;
        int maxIdx = i;

        if (left < n && arr[maxIdx] < arr[left])
            maxIdx = left;

        if (right < n && arr[maxIdx] < arr[right])
            maxIdx = right;

        if(maxIdx != i){
            // swap
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp ;

            heapify(arr, maxIdx, n);
        }
    }
}
