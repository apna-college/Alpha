/*
Determine if 2 Strings are anagrams of each other.
What are anagrams?
If two strings contain the same characters but in a different order, they can be said to be anagrams. Consider race and care. In this case, race's characters can be formed into a study, or care's characters can be formed into race. Below is a java program to check if two strings are anagrams or not.

Ex1:
    str1 = "anagram" str2 = "nagaram"
    >> true

Ex2:
    str1 = "rat" str2 = "cat"
    >> false

Ex1:
    str1 = "race" str2 = "ace"
    >> false

Ex1:
    str1 = "aacc" str2 = "ccac"
    >> false

 */

public class String06_Anagrams {
/* NOTE >> this code will give a wrong ans on --> str1 = "aacc" str2 = "ccac" , for this original ans will be "false", but this code will give ans true
    public static boolean isAnagrams(String str1, String str2) {
        if(str1.length() == str2.length()) {    // --> checking for equal length
            for(int i = 0; i < str1.length(); i++) {
                char ch = str1.charAt(i);
                int j = 0;
                while(j < str2.length() && ch != str2.charAt(j)) {  //--> checking for 
                        j++;
                }
                if(j < str2.length()) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
*/

    public static boolean isAnagrams(String str1, String str2) {    //TC -> O(n) | SC -> O(26) == O(1)  //n -> length of the string 
        if(str1.length() != str2.length()) {   //--> checking for equal length
            return false;
        } 

        int[] freq = new int[26];  //--> to count frequency of every character

        for(int i = 0; i < str1.length(); i++) {
            freq[Character.toLowerCase(str1.charAt(i)) - 'a']++;
            freq[Character.toLowerCase(str2.charAt(i)) - 'a']--;
        }

        for(int i = 0; i < 26; i++) {
            if(freq[i] != 0) {  //--> 0 means both sting have same numbers of characters
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String str1 = "aacc", str2 = "ccac";

        System.out.println(isAnagrams(str1, str2));
    }
}
