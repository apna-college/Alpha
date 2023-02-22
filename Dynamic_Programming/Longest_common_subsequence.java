package Dynamic_Programming;

public class Longest_common_subsequence {
    public static void main(String[] args) {
        String str1 = "abcde", str2="ace";
        int n = str1.length() ,m = str2.length();

        System.out.println(LCS_recursion(str1, str2, n, m));

        int dp[][] = new int[n+1][m+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(LCS_Memoization(str1, str2, n, m,dp));

        System.out.println(LCS_Tabulation(str1, str2));
    }

    public static int LCS_recursion(String str1,String str2,int n,int m) {
        if(n == 0 || m ==0)
        return 0;

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return 1 + LCS_recursion(str1, str2, n-1, m-1);
        }
        else{
            int case1 = LCS_recursion(str1, str2, n-1, m);
            int case2 = LCS_recursion(str1, str2, n, m-1);

            return Math.max(case1, case2);
        }
    }

    public static int LCS_Memoization(String str1,String str2,int n,int m,int dp[][]) { // O(n*m)
        if(n == 0 || m ==0)
        return 0;

        if(dp[n][m] != -1)
        return dp[n][m];

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            dp[n][m] =  1 + LCS_Memoization(str1, str2, n-1, m-1,dp);
        }
        else{
            int case1 = LCS_Memoization(str1, str2, n-1, m,dp);
            int case2 = LCS_Memoization(str1, str2, n, m-1,dp);

            dp[n][m] = Math.max(case1, case2);
        }

        return dp[n][m];
    }

    public static int LCS_Tabulation(String str1,String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        // Intialization also 0 value in java
        // meaning of dp[i][j] is the at both length i and j for maximum LCS

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                dp[i][j] = 1 + dp[i-1][j-1];
                else
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }

        return dp[n][m];
    }
}
