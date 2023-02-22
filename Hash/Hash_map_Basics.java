package Hash;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class Hash_map_Basics {
    public static void main(String[] args) {
        HashMap<String,Float> hm = new HashMap<>();

        hm.put("vipul", 1.1f);
        hm.put("amit", 2.2f);
        hm.put("kavita",3.3f);
        hm.put("kamini",6.6f);
        hm.put("dimple",3.7f);
        hm.put("kishan", 2.6f);

        // System.out.println(hm.get(3));

        hm.remove("kamini");
        System.out.println(hm);


        System.out.println(hm.containsKey("dimple"));
        Set<String> v = hm.keySet();
        System.out.println("_______");
        for (String i : v) {
            System.out.println("|"+i+"|"+hm.get(i)+"|");
        }
        System.out.println("-------");



        // Linked hash map
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("vipul",  1);
        lhm.put("amit", 2);
        lhm.put("kavita",3);
        lhm.put("kamini",4);
        lhm.put("dimple",5);
        lhm.put("kishan",6);

        System.out.println("Linked hash map is here --> "+lhm);
        Set<String> a = lhm.keySet();
        for (String str : a) {
            System.out.println(str+" "+lhm.get(str));
        }
        System.out.println();

        // Tree map
        TreeMap<String,Integer> tm = new TreeMap() ;
        tm.put("vipul",  1);
        tm.put("amit", 2);
        tm.put("kavita",3);
        tm.put("kamini",4);
        tm.put("dimple",5);
        tm.put("kishan",6);

        System.out.println("Tree map is here ---> "+tm);
    }

    
}
