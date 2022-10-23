import java.util.*;
public class D25_MergeSortLL {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public  Node FindMiddle(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public  Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while (head1 != null && head2 != null) {
            if (head1.data >= head2.data) {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            } else {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = FindMiddle(head);
        Node rightHead = mid.next;
        mid.next=null;
        Node newleft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        return merge(newleft, newRight);
    }
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }else{
        newNode.next = head;
        head = newNode;
}
    }
    public void print_LL() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "=>");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        D25_MergeSortLL LL =new D25_MergeSortLL();
        LL.addFirst(1);
        LL.addFirst(2);
        LL.addFirst(3);
        LL.addFirst(4);
        LL.addFirst(5);
        System.out.println("UNSORTED LINKED LIST");
        LL.print_LL();
        LL.head=LL.mergeSort(head);
        System.out.println("SORTED LINKED LIST - AFTER APPLYING MERGE SORT");
        LL.print_LL();
    }
}
