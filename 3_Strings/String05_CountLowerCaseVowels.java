/*
Count how many times lowercase vowels occurred in a String entered.
 */
import java.util.Scanner;
public class String05_CountLowerCaseVowels {
    
    public static int countVowels(String str) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter String >> ");
        String str = scn.nextLine();
        System.out.println("---> "+countVowels(str)+" lowercase vowels.");
    }
}
