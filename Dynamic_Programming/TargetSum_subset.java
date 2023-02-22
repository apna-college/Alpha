package Dynamic_Programming;

public class TargetSum_subset {
    public static void main(String[] args) {
        System.out.println(TSS(new int[]{4,2,7,1,3}, 10));
    }

    public static boolean TSS(int nums[],int target){ // O(n*sum )
        boolean dp[][] = new boolean[nums.length+1][target+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        
        // i means items and j means target Sum
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int v = nums[i-1];

                // Include
                if(v <= j && dp[i-1][j-v])
                dp[i][j] = true;

                //Exclude
                else if(dp[i-1][j]){
                dp[i][j] = true;
                }
            }
        }
        printDP(dp);
        return dp[nums.length][target];
    }

    public static void printDP(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
