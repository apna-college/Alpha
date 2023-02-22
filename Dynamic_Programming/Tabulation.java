package Dynamic_Programming;

/* -> Tabulation is about iterative
-> In Tabultaion we will create table/set/storage
-> Tabulation step is the [1] Intialization [2] meanining off every index [3] Filling {small to large}
*/
public class Tabulation {

    public static void main(String[] args) {
        int n = 5;

        int dp[] = new int[n + 1];

        // Intialization
        dp[0] = 0;
        dp[1] = 1; 

        // Meaning think in paper and pen

        //Filling
        for (int i = 2; i  < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);
    }

}
