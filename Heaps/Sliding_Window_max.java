package Heaps;

import java.util.PriorityQueue;

public class Sliding_Window_max {
    public static void main(String[] args) {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k= 3 ;

        int window[] = maxSlidingWindow(nums,k);

        for (int i = 0; i < window.length; i++) {
            System.out.print(window[i]+" ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) { // O(n*logk)
        int n = nums.length ;
        int window[] = new int[n-k+1];
        
        
        PriorityQueue<Pair> pq  = new PriorityQueue<>();
        for(int i=0; i<k ; i++){
            pq.add(new Pair(nums[i],i));
        }
        
        window[0] = pq.peek().val;
        
        for(int i = k ; i < n ; i++){
            while(pq.size() > 0 && pq.peek().index < i-k+1)
                pq.remove();
            
            pq.add(new Pair(nums[i],i));
            window[i-k+1] = pq.peek().val;
        }
        
        return window ;
    }
    
    static class Pair implements Comparable<Pair>{
        int val;
        int index ;
        
        public Pair(int val,int index){
            this.val = val ;
            this.index = index ;
        }
        
        public int compareTo(Pair p2){
            return p2.val - this.val ;
        }
    }
}
