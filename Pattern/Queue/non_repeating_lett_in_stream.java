// find first non repeating letter in stream --- O(n)

package Queue;

import java.util.*;

public class non_repeating_lett_in_stream {
    public static void main(String[] args) {
        nnr("aabccxb");
    }

    public static void nnr(String str){
        Queue<Character> q = new LinkedList<>();

        int freq[] = new int[26];

        for (int i = 0; i < str.length(); i++) {  
            char ch = str.charAt(i);
            q.add(ch);

            freq[ch-'a']++; // frwq increaseing // ch-a means current character's index in freq array

            while (!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }

            if(q.isEmpty())
            System.out.print("-1"+" ");

            else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }
}
