package Dynamic_Programming;

import java.util.Arrays;

public class Matrix_Chain_Multiplication {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;
        System.out.println(MCM_Recursion(arr, 1, n - 1));

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(MCM_Memo(arr, 1, n - 1, dp));

        System.out.println(MCM_Tabu(arr));
    }

    // Recursion
    public static int MCM_Recursion(int[] arr, int i, int j) {
        if (i == j)
            return 0;

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int cost1 = MCM_Recursion(arr, i, k);
            int cost2 = MCM_Recursion(arr, k + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int final_cost = cost1 + cost2 + cost3;

            ans = Math.min(ans, final_cost);
        }

        return ans;
    }

    // Memoization(Top->bottom)
    public static int MCM_Memo(int[] arr, int i, int j, int[][] dp) {
        if (i == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int cost1 = MCM_Memo(arr, i, k, dp);
            int cost2 = MCM_Memo(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int final_cost = cost1 + cost2 + cost3;

            ans = Math.min(ans, final_cost);
        }

        return dp[i][j] = ans;
    }

    // Tabulation(bottom->up)
    public static int MCM_Tabu(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        for (int len = 2; len <= n-1 ; len++) {
            for (int row = 1; row <= n - len; row++) { // for row // row = i & col = j (for refering memoization code)
                int col = row + len - 1; // coloumn

                dp[row][col] = Integer.MAX_VALUE;
                for (int k = row; k <= col - 1; k++) {
                    int cost1 = dp[row][k];
                    int cost2 = dp[k+1][col];
                    int cost3 = arr[row - 1] * arr[k] * arr[col];
        
                    int final_cost = cost1 + cost2 + cost3;
        
                    dp[row][col] = Math.min(dp[row][col], final_cost);
                }
            }
        }

        print(dp);
        return dp[1][n-1];
    }

    public static void print(int[][] dp) {
        System.out.println("________________________________________-");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
