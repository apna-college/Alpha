package basics;
import java.util.Scanner;
import java.lang.Math;

public class binaryToDecimal{

    public static int bin2dec(int bin) {
        int i = 0, dec = 0;
        while(bin > 0){
            dec += (bin % 10) * Math.pow(2,i);
            bin /= 10;
            i++;
        }
        return dec;
        
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input decimal number: ");
        int bin = sc.nextInt();

        System.out.print(bin2dec(bin));

        sc.close();
    }
}
