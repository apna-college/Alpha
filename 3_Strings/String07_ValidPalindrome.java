/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
 
Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 
Constraints:
    1 <= s.length <= 2 * 105
    s consists only of printable ASCII characters.
 */

public class String07_ValidPalindrome {

    public static boolean isPalindrome(String str) {    //TC -> O(n) || SC -> O(1) //--> n = length of the string
        int startIndex = 0, endIndex = str.length()-1;
        while(startIndex < endIndex) {
                //----when there is a space----//
            if(!Character.isLetterOrDigit(str.charAt(startIndex))) { 
                startIndex++;
                continue; // --> back to starting of the loop
            }
            if(!Character.isLetterOrDigit(str.charAt(endIndex))) {
                endIndex--;
                continue; // --> back to starting of the loop
            }
                        //---- ----//
            if(Character.toLowerCase(str.charAt(startIndex)) != Character.toLowerCase(str.charAt(endIndex))) {
                return false;   //--> whenever both character does not match
            }

            startIndex++;
            endIndex--;
        }

        return true; //--> when loop ends completely
    }

    public static void main(String[] args) {
        String str1 = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        String str3 = " ";
        // String str4 = "A Man 4 aba 4 nama";
        // String str5 = "raceaecar";

        System.out.println("is String is Palindrome?(true/false) \n>> " + isPalindrome(str2));
    }
}