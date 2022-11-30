public class WordBreakProblem {
    static class Node {
        Node children[] = new Node[26]; // k-ary can has 26 children at max (a-z)
        boolean eow;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // O(L) where L is length of longest word
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true; // making current end node of word true to identify end of word.
    }

    public static boolean Search(String key){
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level)-'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    //word break TC=O(L) L: length of key
    public static boolean wordBreak(String key){  // started index from 1 cause in substring(1st idx,last idx) last idx is exclusive
        if (key.length()==0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if(Search(key.substring(0, i)) &&
               wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String[] word = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
        String key= "ilikesung";
        String key1= "ilikesamsung";
        System.out.println(wordBreak(key)); //false
        System.out.println(wordBreak(key1));//true
    }
}
