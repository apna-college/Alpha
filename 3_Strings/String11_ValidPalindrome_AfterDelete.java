/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

Example 1:

Input: s = "aba"
Output: true

Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:

Input: s = "abc"
Output: false

 

Constraints:

    1 <= s.length <= 105
    s consists of lowercase English letters.


 */
public class String11_ValidPalindrome_AfterDelete {

    public static boolean isPalindrome(String str) {    //TC -> O(n^2)
        int startIndex = 0, endIndex = str.length()-1;
        while(startIndex < endIndex) {
            if(str.charAt(startIndex) != str.charAt(endIndex)) {
                return check(str, startIndex, endIndex-1) || check(str, startIndex+1, endIndex);
            }

            startIndex++;
            endIndex--;
        }

        return true; //--> when loop ends completely
    }

    public static boolean check(String str, int i, int j) {
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abeea"));
    }
}
