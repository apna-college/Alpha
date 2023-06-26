public class String01_PalindromeBasic {

    public static boolean isPalindrome(String str) {    //TC -> O(n)
        int n = str.length();
        for(int i = 0; i < n/2; i++) {
            if(str.charAt(i) != str.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "racecar";
        String str2 = "noon";
        String str3 = "arghya";

        System.out.println("is string palindrome?(true/false)");
        System.out.println(">> "+isPalindrome(str1));

    }
}
