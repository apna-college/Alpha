import java.util.ArrayList;

public class MaxHeap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        //Insert In Heap
        public void add(int data){
            // add at last idx
            arr.add(data);
            
            int x = arr.size()-1; // x is child index
            int par = (x-1)/2;  // parent index
            
            while (arr.get(x) > arr.get(par)) { //O(logn)
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }
        
        public int peek(){
            return arr.get(0);
        }

        // heapify to fix heap after element deletion
        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int maxIdx = i;
            
            if(left < arr.size() && arr.get(maxIdx) < arr.get(left)){
                maxIdx = left;
            }
            if(right < arr.size() && arr.get(maxIdx) < arr.get(right)){
                maxIdx = right;
            }
            if(maxIdx != i){
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(maxIdx));
                arr.set(maxIdx, temp);

                heapify(maxIdx);
            }
        }
        //Delete in Heap
        /* 1) 1st & last node swap
         * 2) remove last idx (arr.remove (arr.size()-1))
         * 3) fix my Heap --> heapify()
         */
        public int remove(){
            int data = arr.get(0);

            //step 1 - swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step 2 - delete last
            arr.remove(arr.size()-1);

            //step 3 - heapify
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }
        // // To print our heap
        // public void print(){
        //     while(!arr.isEmpty()){
        //         System.out.println(arr.get(0)/* Or use --> peek()*/);
        //         arr.remove(0);
        //     }
        // }
        // Get Min in Heap
        
    }
    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(5);
        pq.add(3);
        pq.add(7);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
