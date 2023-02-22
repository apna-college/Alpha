//Problem like Edit_Distance but here we will perform only 2 operation instead of 3 and that is insertion and deletion only
package Dynamic_Programming;

public class String_Conversion {
    public static void main(String[] args) {
        System.out.println(Str_Convers("abcdef", "abcg"));
    }

    public static int Str_Convers(String str1,String str2) {
        int lcs = LCS(str1, str2);
        int operations = str1.length() - lcs ;
        operations += str2.length() - lcs ;

        return operations;
    }

    public static int LCS(String str1,String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}
