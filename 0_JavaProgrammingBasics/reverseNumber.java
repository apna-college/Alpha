import java.util.Scanner;
public class ReverseNumber{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = 0;

        for(int n = sc.nextInt(); n > 0; n /= 10){
            m = (m*10)+(n%10);
        }
        System.out.println(m);
        sc.close();
    }
}
