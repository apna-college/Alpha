// find all element who ocuurs more than [n/3] times

package Hash;

import java.util.HashMap;
import java.util.Set;



public class Majority_element {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        int arr[] = {1,3,2,5,1,3,1,5,1};

        for(int i=0; i < arr.length ;i++){
            // if(hm.containsKey(arr[i]))
            // hm.put(arr[i], hm.get(arr[i])+1 ); // when key found then increase this integer value freq. in hashmap

            // else
            // hm.put(arr[i], 1);

            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1); 
        }

         // Set<Integer> keys = hm.keySet();

        // for each loop is used to when we have to trivarse on collection of object.
        for (Integer key : hm.keySet()) {
            if(hm.get(key) > arr.length/3){
                System.out.println(key);
            }
        }
    }
}
