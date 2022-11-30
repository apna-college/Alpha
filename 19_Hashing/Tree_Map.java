import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Tree_Map {
    // Keys are sorted
    // put,get,romove are O(log n)
    public static void main(String[] args) {
        TreeMap<String,Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("US", 50);

        System.out.println("TreeMap = " + tm); // TreeMap = {China=150, India=100, US=50}

        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);

        System.out.println("LinkedHashMap = " + lhm); // {India=100, China=150, US=50}
    }
}
