package Dynamic_Programming;

public class Climbing_Stairs {
    public static void main(String[] args) {
        int n=5;
        int dp[] = new int[n+1];
        System.out.println(climbStairs(n,dp));
        System.out.println(climbStairsTab(n));
    }

    // memoization
    public static int climbStairs(int n,int dp[]){
        if(n == 0)
        return 1;
        if(n < 0)
        return 0;

        if(dp[n] != 0)
        return dp[n];

        dp[n] = climbStairs(n-1, dp)+climbStairs(n-2, dp);
        return dp[n];
    }

    // tabulation
    public static int climbStairsTab(int n){
        int dp[] = new int[n+1];
        dp[0]=1;

        for (int i = 1; i <= n; i++) {
            if(i == 1)
            dp[i] = dp[i-1] + 0 ;
            else{
            dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
}
