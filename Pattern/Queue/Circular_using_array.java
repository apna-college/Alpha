package Queue;

public class Circular_using_array {
    static class cir_queue{
        static int arr[] ;
        static int size ;
        static int rear ;
        static int front ;

        cir_queue(int n){
           arr = new int[n] ;
           size = n ;
           rear = -1 ;
           front = -1 ;
        }

        public  boolean isEmpty(){
            return rear == -1 && front == -1 ;
        }

        public  boolean isFull(){
            return (rear + 1) % size == front ; 
        }

        public  void add(int data){
            if(isFull()){
                System.out.println("queue is already full.");
            }

            // add 1st element
            if(front == -1){
               front = 0 ;
            }
            rear = (rear+1)%size ;
            arr[rear] = data ;
        }

        public  int remove(){
           if(isEmpty())
           return -1;

           int result = arr[front];

           if(front == rear)
           front=rear = -1 ;

           else{
              front = (front+1)%size ;
           }
           return result ;
        }

        public  int peek() {
            if(isEmpty())
            return -1;

            return arr[front] ;
        }
    }

    public static void main(String[] args) {
        cir_queue q = new cir_queue(5);
    q.add(1);
    q.add(2);
    q.add(3);

    System.out.println(q.remove());
    q.add(4);

    System.out.println(q.remove());
    q.add(5);

    while (!q.isEmpty()) {
        System.out.println(q.peek());
        q.remove();
    }
    
    System.out.println(q.peek());

    }
}
