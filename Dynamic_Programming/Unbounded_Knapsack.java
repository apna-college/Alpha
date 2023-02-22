package Dynamic_Programming;

public class Unbounded_Knapsack {
    public static void main(String[] args) {
        System.out.println(Unbounded_Knap(new int[] { 15, 14, 10, 45, 30 }, new int[] { 2, 5, 1, 3, 4 }, 7));
    }

    public static int Unbounded_Knap(int v[], int w[], int cap) {
        int dp[][] = new int[v.length + 1][cap + 1];

        // i means items and j means capacity
        for (int i = 0; i < dp.length; i++) { // with 0 capacity we can not add single item
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) { // with 0 item we can not fulfill our capacity
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int val = v[i - 1];
                int we = w[i - 1];

                if (we <= j) {
                    dp[i][j] = Math.max(val + dp[i][j - we], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[v.length][cap];

    }
}
