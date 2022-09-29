package basics;
import java.util.Scanner;

public class decimalTobinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter decimal number: ");
        int dec = sc.nextInt();

        int bin = 0, i = 0;
        while (dec > 0){
            bin += (dec % 2) * Math.pow(10, i);
            dec /= 2;
            i++;
        }
        System.out.println("binary number = " + bin);
        sc.close();
    }
}
