import java.util.*;

public class pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n--");
        int n = sc.nextInt();

        System.out.println("[1] Star Pattern");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("[2] Inverted star pattern");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i + 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("[3] Half pyramid Number");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println("[4] Character Pattern");
        char ch = 'A';
        for(int i=1 ; i<=n ; i++){
            for( int j = 1 ; j<= i ; j++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
        
    }
}
