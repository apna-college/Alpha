import java.util.TreeSet;

public class Tree_Set {
    /* Sorted in ascending order
     * Null values are not allowed (cause - TreeSet compares value to sort them,so it would be not 
     * possible to compare with null)
     * 
     * TreeSet Functions -- O(log n) cause - sorting
     * 
     * HashSet---------\
     *                Null key
     * LinkedHashSet---/
     * 
     */
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();
        ts.add("India");
        ts.add("China");
        ts.add("US");
        ts.add("Qatar");

        System.out.println(ts); // [China, India, Qatar, US] - alphabatical order
    }
}
