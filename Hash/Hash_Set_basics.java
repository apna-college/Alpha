package Hash;

import java.util.HashSet;
import java.util.Iterator;

public class Hash_Set_basics {
    public static void main(String[] args) {
        HashSet<String> city = new HashSet<>();
        city.add("Ahmedabad");
        city.add("baroda");
        city.add("Gandhinagar");
        city.add("Bhabhar");

        System.out.println(city);

        Iterator it = city.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        
        System.out.println();
        for (String str : city) {
            System.out.print(str+" ");
        }
    }
}
