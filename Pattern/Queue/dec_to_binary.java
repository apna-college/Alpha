package Queue;
import java.util.*;
public class dec_to_binary {
    public static void main(String[] args) {
        decToBi(10);
    }

    public static void decToBi(int n){
        Queue<String> q = new LinkedList<>();
        q.add("1");

        while (n-- > 0) {
            String s1 = q.remove();
            System.out.println(s1);
            String s2 = s1 ;

            q.add(s1 + "0");
            q.add(s2+ "1");
        }
    }
}
