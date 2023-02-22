// practise --> connect n ropes with minimum cost

package Queue;
import java.util.*;

// new concept priority queue

public class N_ropes_with_minimumCost {
    public static void main(String[] args) {
        int arr []= {4,3,2,6};
        System.out.println(mc(arr,4));
    }

    public static int mc(int arr[],int n){
        PriorityQueue<Integer> pq  = new PriorityQueue<Integer>();

        for(int i=0; i < n ; i++){
            pq.add(arr[i]);
        }
    
        int result = 0 ;
        while (pq.size() > 1) {
            int first = pq.poll() ;
            int second = pq.poll() ;

            result += first + second;
            pq.add(first + second);
        }
        return result;
    } 
}
