// connect ropes with minimum cost
// note -> we have to conncet all ropes using only two ropes

package Heaps;

import java.util.PriorityQueue;

public class Connect_Ropes {
    public static void main(String[] args) {
        int arr[]={2,3,3,4,6};
        System.out.println(min_cost(arr));
    }

    public static int min_cost(int arr[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int cost = 0 ;
        while (pq.size() > 1 ) {
            int min1 = pq.remove();
            int min2 = pq.remove();

            cost += min1 + min2;

            pq.add(min1+min2); // add current cost in priority quue
        }
        return cost ;
    }
}
