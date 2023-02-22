// practise --> find maximum value of k sized array for every element of array

package Queue;

import java.util.*;

public class Max_in_k_size_sbarray {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        MaxInSubarray(arr, 3);
        mis(arr, arr.length, 3);
    }

    // brute force
    public static void MaxInSubarray(int arr[], int k) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < arr.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < k + i; j++) {
                max = Math.max(max, arr[j]);

            }
            q.add(max);
        }

        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }

    // second way - O(n) and psace - O(k)
    // for better understanding do the dry run
    public static void mis(int arr[], int n, int k) {
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < k; i++) { // for fisrt subarray
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()])
                q.remove();

            q.addLast(i);
        }

        for (int i = k; i < n; i++) { // from second array 

            System.out.print(arr[q.peek()] + " ");

            while (!q.isEmpty() && q.peek() <= i - k) // we need only k element in subarray so, remove bakina
                q.removeFirst();

            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()])
                q.removeLast();

            q.addLast(i);
        }
        System.out.println(arr[q.peek()] + " ");
    }
}
