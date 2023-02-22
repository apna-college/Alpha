package Hash;

import java.util.HashMap;

public class Valid_anagram {
    public static void main(String[] args) {
        
        String s = "heart";
        String t = "erth";

        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s,String t){ // O(n)
        HashMap<Character,Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)+1) ;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(hm.get(ch) != null){
                if(hm.get(ch) == 1)
                hm.remove(ch);

                else
                hm.put(ch, hm.get(ch)-1);
            }
            else
            return false ;
        }

        return hm.isEmpty() ;
    }
}
