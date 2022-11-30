import java.util.HashSet;
import java.util.Iterator;

public class IterationOnHashSet {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        // (A) Using Iterator , Itorator is interface in java which returns iterator
        System.out.println("(A) Using Iterator ");
        Iterator it = cities.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("(B) (Advance / Enhance for-each loop) ");
        // (B) (Advance / Enhance for-each loop) 
        for (String city : cities) {
            System.out.println(city);
        }
    }
}
