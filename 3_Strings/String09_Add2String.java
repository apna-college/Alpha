/*
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

 

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"

Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"

Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"

 

Constraints:

    1 <= num1.length, num2.length <= 104
    num1 and num2 consist of only digits.
    num1 and num2 don't have any leading zeros except for the zero itself.


*/ 


public class String09_Add2String {

    public static String addString(String num1, String num2) { //TC --> O(n) || SC --> O(1)
        StringBuilder sb = new StringBuilder("");
        int n1 = num1.length()-1, n2 = num2.length()-1;
        int sum, carry = 0;

        while(n1 >= 0 || n2 >= 0) {
            sum = carry;
            
            if(n1 >= 0) {
                sum += num1.charAt(n1) - '0';
                n1--;
            }
            if(n2 >= 0) {
                sum += num2.charAt(n2) - '0';
                n2--;
            }

            sb.append(sum%10);
            carry = sum/10;
        }

        if(carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }



    public static void main(String[] args) {
        String num1 = "9333852702227987", num2 = "85731737104263";

        System.out.println(">> "+addString(num1, num2));
    
    }
}