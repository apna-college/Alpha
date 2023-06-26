/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 

Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.


 */

import java.util.Arrays;

public class String10_LongestCommonPrefix {

    public static String lcp(String[] str) {    //TC -> O(n*log(n))
        Arrays.sort(str);
        String s1 = str[0];
        String s2 = str[str.length-1];

        int i = 0;

        while(i < s1.length() && i < s2.length()) {
            if(s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                break;
            }
        }

        return s1.substring(0, i);
        
    }

    public static void main(String[] args) {
        String[] str1 = {"flower","flow","flight"};

        System.out.println(lcp(str1));
    }
}
