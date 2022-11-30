import java.util.HashSet;

public class CountDistinctElements {
    /*
     * Input : arr[] = {10, 20, 20, 10, 30, 10}
     * Output : 3
     * Explanation: There are three distinct elements 10, 20, and 30.
     * 
     * Input : arr[] = {10, 20, 20, 10, 20}
     * Output : 2
     * 
     */
    public static void main(String[] args) {
        int num[] = {4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
        System.out.println(set.size());
    }
}
