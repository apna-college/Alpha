// import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueJCF{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); /* to get reverse priority */
        pq.add(3);
        pq.add(7);
        pq.add(4);
        pq.add(1);

        /* TO understand how queue actually works */
        System.out.println(pq);
        pq.remove();
        System.out.println(pq);
        pq.remove();
        System.out.println(pq);
        pq.remove();
        System.out.println(pq);

        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.remove();
        }

    }
}