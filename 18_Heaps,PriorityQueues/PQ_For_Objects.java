import java.util.PriorityQueue;
public class PQ_For_Objects {
    static class Student implements Comparable<Student>{
        //Overriding
        String name;
        int rank;

        public Student(String name,int rank){
            this.name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;  // make it reverse to get decressing order
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A",4));
        pq.add(new Student("B",5));
        pq.add(new Student("C",2));
        pq.add(new Student("D",12));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + " --> " + pq.peek().rank);
            pq.remove();
        }
    }
}
