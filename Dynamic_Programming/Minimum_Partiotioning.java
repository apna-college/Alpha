package Dynamic_Programming;

//Problem -> Given a array find the min difference between two subset array sum
// Variation of 0-1 knapsack

public class Minimum_Partiotioning {
    public static void main(String[] args) {
        int nums[] = { 1, 6, 11, 5 };
        int n = nums.length;

        int arrSum = 0;
        for (int i = 0; i < n; i++)
            arrSum += nums[i];

        int sum1 = knapsack_0_1(nums, arrSum / 2);
        int sum2 = arrSum - sum1;

        int ans = Math.abs(sum1 - sum2);
        System.out.println(ans);
    }

    public static int knapsack_0_1(int nums[], int cap) {
        int n = nums.length;
        int dp[][] = new int[n + 1][cap + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums[i - 1] <= j) {
                    int include = nums[i - 1] + dp[i - 1][j - nums[i - 1]];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][cap];
    }
}
