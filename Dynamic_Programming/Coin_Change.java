// similar to unbounded but here we will not compare but we will find total ways so, Addition

package Dynamic_Programming;

public class Coin_Change {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[] { 2, 5, 3, 6 }, 10));
    }

    public static int coinChange(int coins[], int sum) {
        int dp[][] = new int[coins.length + 1][sum + 1];

        // There are 1 way to give coin and that is empty set {}
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] <= j)
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[coins.length][sum];
    }
}
