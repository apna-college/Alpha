package Hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Bottom_view_of_BT {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);
    }

    public static void bottom_view(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Integer> m = new HashMap<>();

        
    }

    static class Info {
        Node node;
        int hd; // horizontol distance

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
