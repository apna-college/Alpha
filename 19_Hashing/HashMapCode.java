import java.util.HashMap;
public class HashMapCode{
    /* #Hashing --Map --(1)HashMap,(2)LinkedHashMap,(3)TreeMap
     *   |______--Set --(1)HashSet,(2)LinkedSet,(3)TreeSet
     * 
     * HasMap
     * (Key,Value)
     *   |
     *  unique
     *  
     *  i.g.     Menu
     *        Tea       10
     *        Samosha   15
     *        Pizza     250
     *        Burger    50
     * 
     * HashMap Operations // import java.util.HashMap;
     * 
     * put(key,Value);--------|
     * get(Key);              |
     * containsKey(key);     O(1)
     * remove(key);-----------|
     * 
     */
    public static void main(String[] args) {
        HashMap <String,Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);
        int population = hm.get("India"); //{China=150, US=50, India=100}
        System.out.println(population); //100
        System.out.println(hm.containsKey("India")); // True
        System.out.println(hm.containsKey("Indonasia")); //false

        System.out.println(hm.size()); // 3
        System.out.println(hm.isEmpty()); // false
        hm.remove("China");
        System.out.println(hm);
        hm.clear(); // to clear full HashMap
        System.out.println(hm.isEmpty()); //True
    }
}