package Dynamic_Programming;

public class Knapsack_01 {
    public static void main(String[] args) {
        int v[] = { 15, 14, 10, 45, 30 };
        int w[] = { 2, 5, 1, 3, 4 };
        int cap = 7;

        int dp[][] = new int[cap + 1][v.length + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Using Memoization ->" + knapsack(v, w, cap, 0, dp));
        System.out.println("Using Tabulation ->" + Knapsack_Tab(v, w, cap));
    }

    // Memoization
    public static int knapsack(int v[], int w[], int cap, int i, int dp[][]) {
        if (cap == 0 || i == v.length)
            return 0;

        if (dp[cap][i] != -1)
            return dp[cap][i];

        // valid
        if (w[i] <= cap) {
            int include = v[i] + knapsack(v, w, cap - w[i], i + 1, dp);
            int exclude = knapsack(v, w, cap, i + 1, dp);

            dp[cap][i] = Math.max(include, exclude);
            return dp[cap][i];
        }

        // invalid so, exclude
        else
            dp[cap][i] = knapsack(v, w, cap, i + 1, dp);
        return dp[cap][i];
    }

    // Tabulation
    public static int Knapsack_Tab(int v[], int w[], int cap) {
        int dp[][] = new int[cap + 1][v.length + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < cap + 1; i++) {
            for (int j = 1; j < v.length + 1; j++) {

                int val = v[j - 1];
                int we = w[j - 1];

                // valid
                if (we <= i) {
                    int include = val + dp[i - we][j - 1];
                    int exclude = dp[i][j - 1];

                    dp[i][j] = Math.max(include, exclude);
                }

                // Invalid
                else {
                    int exclude = dp[i][j - 1];
                    dp[i][j] = exclude;
                }
            }
        }

        // for (int i = 0; i < dp.length; i++) {
        // for (int j = 0; j < dp[0].length; j++) {
        // System.out.print(dp[i][j]+" ");
        // }
        // System.out.println();
        // }

        return dp[cap][v.length];
    }
}
