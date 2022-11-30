import java.util.HashSet;

public class Hash_Set{
    /* 1)no duplicates
     * 2)unordered
     * 3)Null is allowed
     * Set --> Collection of unque elements
     * 
     * HashSet<Integer> hs = new HashSet<>();
     * it's implementation is done by HashMap
     * 
     * HashSet Operations 
     * add(key) //O(1)
     * contains(Key) //O(1)
     * remove(key) //O(1)
     * it also has .clear() , .isEmpty() , .size() methods
     */
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(8);
        set.add(5);
        set.add(4);
        set.add(11);
        set.add(24);

        System.out.println(set);
        System.out.println("removing 1 from the set via set.remove(1)");set.remove(1);
        System.out.println(set);

        if (set.contains(2)) {
            System.out.println("contains 2");
        }
        else{
            System.out.println("not contains 2");
        }
        System.out.println("Set is empty ? " + set.isEmpty());
        System.out.println("Clearing the set via set.clear()");  set.clear();
        System.out.println("Set is empty ? " + set.isEmpty());
    }
}