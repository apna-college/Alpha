package Dynamic_Programming;
//Leetcode 45

import java.util.Arrays;

public class Min_Array_Jump {
    public static void main(String[] args) {
        System.out.println(new int[]{2,3,1,1,4});
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp,-1);

        //fill the table in bottom-up means small problems to big problems
        dp[n-1]=0;
        
        for(int i=n-2 ; i>=0 ; i--){
            int maxSteps = nums[i];
            int ans = Integer.MAX_VALUE;
                for(int j=i+1 ; j <= i+maxSteps && j<n ; j++){
                    if(dp[j] != -1)
                        ans = Math.min(ans,dp[j]+1);
                }

            if(ans < Integer.MAX_VALUE)
            dp[i] = ans;
        } 

        return dp[0]; // that is big problem
    }
}
