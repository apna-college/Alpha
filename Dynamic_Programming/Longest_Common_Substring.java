package Dynamic_Programming;

public class Longest_Common_Substring {
    public static void main(String[] args) {
        String str1 = "ABCEFGE";
        String str2 = "ABGCEF";

        System.out.println(Lon_Com_Substring(str1,str2));
    }

    public static int Lon_Com_Substring(String str1,String str2){
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        // Intialization - also in java 0 but for understanding...
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if(i== 0 || j == 0)
                dp[i][j] = 0;
            }
        }
       
        // Meaning of dp[i][j] is that for length i and length j lengest common substring
        int ans = 0; // for tracking the activity of continuos substring

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }
                else{
                    dp[i][j] = 0; // reset the counter for the continues substring
                }
            }
        }

        return ans;
    }
}
