package Queue;
import java.util.*;

public class Stack_Queue_Using_Dqueue {
    

    static class Stack{
        Deque<Integer> deq = new LinkedList<>();

        public void push(int data){
            deq.addLast(data);
        }

        public int pop(){
            return deq.removeLast();
        }

        public  int peek(){
            return deq.getLast();
        }
    }

    static class Queue{
        Deque<Integer> deq = new LinkedList<>();

        public void add(int data){
            deq.addLast(data);
        }

        public int remove(){
            return deq.removeFirst();
        }

        public int peek(){
            return deq.getFirst();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());
    }
}
