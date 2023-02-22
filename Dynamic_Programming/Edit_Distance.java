// two string given convert first into second with minimum operation, Operationn can be take only insert,delete,replace

package Dynamic_Programming;

public class Edit_Distance {
    public static void main(String[] args) {
        System.out.println(EditDistance("intention", "execution"));
    }

    public static int EditDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // create table
        int dp[][] = new int[n + 1][m + 1];

        // Meaning --> for (i,j) string-1 length i and string-2 length j store minimum
        // operation taken to make string 1 as string 2

        // Intialization
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0)
                    dp[i][j] = j;

                if (j == 0)
                    dp[i][j] = i;
            }
        }

        // fill the table with bottom->up manner
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                // if character same
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }
}
