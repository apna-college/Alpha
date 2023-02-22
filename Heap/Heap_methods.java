package Heaps;

import java.util.ArrayList;

public class Heap_methods {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        // insert
        public void add(int data){
            // add at last index
            arr.add(data);

            int x = arr.size() -1 ; // x is child index
            int par = (x-1)/2 ; // par index

            while (arr.get(x) < arr.get(par)) { // o(logn)
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp) ;

                // update 
                x = par ;
                par = (x-1)/2 ;
            }
        }
        
        // peek
        public int peek(){
            return arr.get(0);
        }


        // remove
        public int remove(){ // Time comp -> O(logn)
            int data = arr.get(0);

            // step 1 - swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp) ;

            // step 2 - remove last element
            arr.remove(arr.size()-1);

            // step 3 - for fix the heaps call heapify method
            Heapify(0);

            return data ;
        }
        public void Heapify(int i){ // Time complexity ->O(logn)
            int left = 2*i + 1 ;
            int right = 2*i + 2 ;
            int minIdx = i ; // assume that minIndex is current rather than left or right
 
            if(left < arr.size() && arr.get(left) < arr.get(minIdx)) // 1.condition is about leaf node
            minIdx = left ;

            if(right < arr.size() &&  arr.get(right) < arr.get(minIdx)) // 1.condition is about leaf node
            minIdx = right ;

            if(minIdx != i){ // if minIdx value changed then ...
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                Heapify(minIdx);
            }
        }

        // check that heap is empty or not
        public boolean isEmpty(){
            return arr.size() == 0 ;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(40);
        h.add(30);
        h.add(35);

        while (!h.isEmpty()) {
            System.out.println(h.peek()+" ");
            h.remove();
        }
    }
}
