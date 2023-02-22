package Dynamic_Programming;

import java.util.Arrays;

public class Catalan_of_num {
    // 0 and 1's catalan is 1
    // Make Unique BST is same like catalan's number
    // Also Mountain ranges is like catalan's number

    public static void main(String[] args) {
        int n = 4 ;
        System.out.println(Catalan(n));

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(Catalan_memoi(n, dp));

        System.out.println(Catalan_Tabul(n));
    }

    // recursion
    public static int Catalan(int n) {
        if(n == 0 || n == 1)
        return 1;

        int ans = 0 ;
        for (int i = 0; i < n ; i++) {
            ans += Catalan(i)*Catalan(n-i-1);
        }

        return ans;
    }

    // Memoization
    public static int Catalan_memoi(int n,int []dp) {
        if(n == 0 || n == 1)
        return 1;

        if(dp[n] != -1)
        return dp[n];

        int ans = 0 ;
        for (int i = 0; i < n ; i++) {
            ans += Catalan_memoi(i,dp)*Catalan_memoi(n-i-1,dp);
        }

        return dp[n] = ans;
    }

    // Tabulation
    public static int Catalan_Tabul(int n) {
        int dp[] = new int[n+1];

        dp[0] = 1 ;
        dp[1] = 1 ;

        for (int i = 2; i < dp.length; i++) {
            
            for(int j=0 ; j < i ; j++)
            dp[i] += dp[j]*dp[i-j-1];

        }

        return dp[n];
    }
}
