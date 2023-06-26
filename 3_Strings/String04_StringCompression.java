/*
String compression

Example 1:
    string = "aaabbccdd"
    output : "a3b2c3d2"

Example 2:
    string = "aaaabbbdd"
    output : "a4b3d2"

Example 1:
    string = "abc"
    output : "abc"
 */

public class String04_StringCompression {

    public static String compress(String str) { //TC -> O(n) || n -> size of string
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "aaabbccdd";
        String str2 = "aaaabbbdd";
        String str3 = "abc";

        System.out.println(compress(str1));
    }
}
