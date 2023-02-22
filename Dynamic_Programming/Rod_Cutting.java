//try rod cutting in geeks for geeks website that does not have length array

package Dynamic_Programming;

public class Rod_Cutting {
    public static void main(String[] args) {
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 90, 10, 17, 17, 20 };
        int rodLength = 8;

        int dp[][] = new int[length.length + 1][rodLength + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Using Memoization -> " + rodCutting(length, price, rodLength, 0, dp));

    }

    // Memoization
    public static int rodCutting(int length[], int price[], int rl, int i, int dp[][]) {
        if(i == length.length || rl == 0)
        return 0;

        if(dp[i][rl] != -1)
        return dp[i][rl];

        if(length[i] <= rl){
            int include = price[i] + rodCutting(length, price, rl-length[i], i, dp);
            int exclude = rodCutting(length, price, rl, i+1, dp);
            dp[i][rl] = Math.max(include, exclude);
        }
        else{
            dp[i][rl] = rodCutting(length, price, rl, i+1, dp);
        }

        return dp[i][rl];
    }
}
