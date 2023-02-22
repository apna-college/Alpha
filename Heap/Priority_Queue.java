package Heaps;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Priority_Queue {
    static class Student implements Comparable<Student> {
        String name;
        int rank;
        public Student(String name,int rank){
            this.name = name ;
            this.rank = rank ;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank ;
        }
    } 

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new Student("a", 15000));
        pq.add(new Student("b", 45000));
        pq.add(new Student("c", 1500));
        pq.add(new Student("d", 5000));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name+" -> "+pq.peek().rank);
            pq.remove();
        }
    }
}
