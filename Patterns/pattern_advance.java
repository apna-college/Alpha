import java.util.Scanner;

public class pattern_advance {
    public static void main(String[] args) {

        hrp();
        ihp();
        ihwn();
        ft();
        zot();
        bfp();
        srp();
        h_rhmbus_p();
        dp();

    }

    // Hollow rectangle pattern
    public static void hrp() {
        Scanner sc = new Scanner(System.in);

        // This will become matrix so, we have to take input row & coloums and the most numbe rwill be th
        System.out.print("--> Hollow rectangle pattern:\nEnter total rows - ");
        int total_rows = sc.nextInt();
        System.out.print("Enter total coloms - ");
        int total_cols = sc.nextInt();

        for (int i = 1; i <= total_rows; i++) {  // rows means outer loop
            for (int j = 1; j <= total_cols; j++) { // cols means inner loop
                if (i == 1 || i == total_rows || j == 1 || j == total_cols) // border vale cells
                    System.out.print("*"); // in border print *
                else
                    System.out.print(" "); // in between hollow print space
            }
            System.out.println();
        }

    }

    // Inverted half pyramid
    public static void ihp() {
        Scanner sc = new Scanner(System.in);
        System.out.print("--> Inverted half pyramid:\nEnter number - ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) { // for printing spaces
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) { // for printing star
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Inverted half pyramid with numbers
    public static void ihwn() {
        Scanner sc = new Scanner(System.in);
        System.out.print("--> Inverted half pyramid with numbers:\nEnter number - ");
        int n = sc.nextInt();

        for(int i = 1 ; i<= n ; i++){
            for(int j = 1 ; j <= (n-i+1) ; j++){ 
                System.out.print(j);
            }
            System.out.println();
        }
    }

    // Floyd's triangle pattern
    public static void ft() {
        Scanner sc = new Scanner(System.in);
        System.out.print("--> Floyd's triangle pattern:\nEnter number - ");
        int n = sc.nextInt();
        int count = 1; // for printing the number throughout
        for(int i =1 ; i<=n ; i++){
            for(int j = 1 ; j <= i ; j++){
                System.out.print(count+" ");
                count++ ; // then count++
            }
            System.out.println();
        }
    }
    
    // 0 - 1 triangle
    public static void zot() {
        Scanner sc = new Scanner(System.in);
        System.out.print("--> 0-1 triangle pattern:\nEnter number - ");
        int n = sc.nextInt();

        for(int i =1 ; i <= n ; i++){
            for(int j = 1; j <= i ; j++){
                if((i+j) % 2 == 0)           // when each cell sum is even then print "1" & odd "0"
                System.out.print("1");
                else
                System.out.print("0");
            }
            System.out.println();
        }
    }

    //Butterfly pattern
    public static void bfp() {
        Scanner sc = new Scanner(System.in);
        System.out.print("--> Butterfly pattern:\nEnter number - ");
        int n = sc.nextInt();
 
        // In butterfly we have to take 2 part 1 is  -1st half and 2 is -2nd half

        //So, this outer loop for 1st half
        for(int i = 1 ; i <= n ; i++){
            //BF pattern contain 3 chiz - star then space then star

            //this inner loop for star
            for(int j = 1 ; j <= i ; j++){
                System.out.print("*");
            }

            //inner loop for space
            for(int j = 1 ; j <= 2*(n-i) ; j++){
                System.out.print(" ");
            }

            // inner loop for star
            for(int j = 1 ; j <= i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // This outer loop for 2nd half (mirror image of 1st half)
        // and in 2nd half only outer loop will be change
        for(int i = n ; i >= 1 ;i--){  

            //this inner loop for star
            for(int j = 1 ; j <= i ; j++){
                System.out.print("*");
            }

            //inner loop for space
            for(int j = 1 ; j <= 2*(n-i) ; j++){
                System.out.print(" ");
            }

            // inner loop for star
            for(int j = 1 ; j<=i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Solid rohmbos pattern
    public static void srp(){
        Scanner sc = new Scanner(System.in);
        System.out.print("--> Solid Rohmbos Pattern:\nEnter number - ");
        int n = sc.nextInt();

        for(int i = 1; i <= n ;i++){
            for(int j = 1 ; j <= n-i ; j++){
                System.out.print(" ");
            }
            for(int j = 1 ; j <= n ; j++){
                System.out.print("*");
            }
            System.out.println();
        } 
        
    }

    // Hollow rohmbus pattern
    public static void h_rhmbus_p() {
        Scanner sc = new Scanner(System.in);
        System.out.print("-->Hollo Rhmbos Pattern:\nEnter number - ");
        int n = sc.nextInt();

        for(int i = 1 ; i <= n ; i++ ){
            for(int j = 1 ; j <= n-i ; j++){
                System.out.print(" ");
            }
            for(int j = 1 ; j <= n ; j++){
                if(i == 1 || i == n || j == 1 || j ==n)
                System.out.print("*");
                else
                System.out.print(" ");
            } 
            System.out.println();
        }
    }

    // Diamond Pattern
    public static void dp() {
        Scanner sc = new Scanner(System.in);
        System.out.print("--> Diamond pattern:\nEnter number - ");
        int n = sc.nextInt();

        // 1st half 
        for(int i = 1 ; i<=n ; i++){
            for(int j = 1; j <= n-i ; j++){
                System.out.print(" ");
            }
            /*  for odd star printing there are two option 1) 2i+1    2) 2i-1
            so we take 2nd option 2i-1
            */
            for(int j = 1 ; j <= (2*i-1) ;j++){ 
               System.out.print("*");
            }
            System.out.println();
        }

        // 2nd half(mirror imag of 1st half)
        for(int i = n ; i >= 1 ; i--){
            for(int j = 1; j <= n-i ; j++){
                System.out.print(" ");
            }
            for(int j = 1 ; j <= 2*i-1 ;j++){
               System.out.print("*");
            }
            System.out.println();
        }
    }
}
