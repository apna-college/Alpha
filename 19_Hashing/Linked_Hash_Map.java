import java.util.LinkedHashMap;
import java.util.HashMap;
public class Linked_Hash_Map {
    //keys are insertion ordered
    public static void main(String[] args) {

        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println("HashMap = " + hm); // {China=150, US=50, India=100}

        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);

        System.out.println("LinkedHashMap = " + lhm); // {India=100, China=150, US=50}

        //entrySet() method ---> to create a set out of the same elements contained in the hash map.
        System.out.println("The set is" + lhm.entrySet()); // [India=100, China=150, US=50]
    }
}
