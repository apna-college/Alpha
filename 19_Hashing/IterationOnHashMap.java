import java.util.HashMap;
import java.util.Set;
public class IterationOnHashMap {
    public static void main(String[] args) {
        HashMap <String,Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        Set<String> Keys = hm.keySet();
        System.out.println(Keys); // [China, US, India]

        for(String k : Keys){
            System.out.println("key = " + k + " , Value = " + hm.get(k));
        }
    }
}
