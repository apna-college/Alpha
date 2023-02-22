// reverse the k element of queue

package Queue;
import java.util.*;

public class Reversing_k_elements {
    public static void main(String[] args) {
        Deque<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);

        rke(q,3);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }

    public static void rke(Deque<Integer> q, int k){
        Queue<Integer> nq = new LinkedList<>(); 
        for (int i = 0; i < k; i++) {
            nq.add(q.remove());
        }

        while (!nq.isEmpty()) {
            q.addFirst(nq.remove());
        }
    }
}
