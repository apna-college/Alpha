package Queue ;

public class Using_linkedList {

    static class Node{
        int data;
        Node next ;
        public Node(int data){
           this.data = data ;
           this.data = data ;
        }
    }

    public static Node head = null;
    public static Node tail = null ;

    static class queue{
        public boolean isEmpty(){
            return head == null && tail == null ;
        } 

        public void add(int data){
            Node newNode = new Node(data);

            if(head == null){
                head = tail = newNode ;
                return ;
            }

            tail.next = newNode ;
            tail = newNode ;
        }

        public int remove(){
            if(isEmpty()){
                return -1 ;
            }

            int front = head.data ;
            if(head == tail){
                head = tail = null ;
        
            }
            else
            head = head.next ;

            return front ;
        }

        public int peek(){
            if(isEmpty())
            return -1 ;

            return head.data ;
        }
    }

    public static void main(String[] args) {
        queue q = new queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
