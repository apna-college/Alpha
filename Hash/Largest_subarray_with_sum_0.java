package Hash;

import java.util.HashMap;

/**
 * Largest_subarray_with_sum_0
 */
public class Largest_subarray_with_sum_0 {
    public static void main(String[] args) {
        int arr[] ={15,2,-2,-8,1,7};

        System.out.println("Largest subarray as sum 0 is -> "+lar_sum_0(arr));
    }

    public static int lar_sum_0(int arr[]){ // O(n)
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0 ; // for comparing sum  // that which point sum is remaining stable as our first index
        int maxLen = 0 ; // tracking our sum length as sum 0

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(hm.containsKey(sum)){
                maxLen = Math.max(maxLen , i-hm.get(sum));
            }
            else{
            hm.put(sum, i);
            }
        }

        return maxLen;
    }
}