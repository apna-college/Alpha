import java.util.LinkedHashSet;

public class Linked_HashSet {
    // Order of Insertion
    // Ordered using DLL(Doubly Linked List)
    // LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
    // Performance -- 
    //   LHM < HashMap
    //   LHS < HashSet
    //    |      |
    //     -O(1)-
    // As we add values , as we get output.
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Noida");
        lhs.add("Bengaluru");

        System.out.println(lhs); // [Delhi, Mumbai, Noida, Bengaluru] -- the way is same,as we inserted these elements.
    }
}
