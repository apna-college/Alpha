public class Trie{
   /*A Trie is a special data structure used to store strings that can be visualized like a
     graph. It consists of nodes and edges. Each node consists of at max 26 children and edges
     connect each parent node to its children.
   */
  static class Node{
    Node children[] = new Node[26]; //k-ary can has 26 children at max (a-z)
    boolean eow;

    public Node(){
        for (int i = 0; i < children.length; i++) {
            children[i] = null;
        }
    }
  }
  public static Node root = new Node(); //initialize empty root node

  //Insert in Trie
  public static void insert(String word){ //O(L) where L is length of longest word
    Node curr = root;
    for (int level = 0; level < word.length(); level++) {
        int idx = word.charAt(level)-'a';
        if (curr.children[idx] == null) {
            curr.children[idx] = new Node();
        }
        curr = curr.children[idx];
    }
    curr.eow = true; //making current end node of word true to identify end of word.
  }

  //Search in Trie
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
  public static void main(String[] args) {
    String []word = {"the","a","there","thier","any","thee"};
    for (int i = 0; i < word.length; i++) {
      insert(word[i]);
    }
    System.out.println(Search("any")); //true
    System.out.println(Search("an"));  //false
  }
}