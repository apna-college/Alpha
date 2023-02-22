package Dynamic_Programming;

import java.util.Arrays;
import java.util.HashSet;

// given one array and find the longest common increasing subsequence
public class Longest_Comm_Increasing_Subsequence {
    public static void main(String[] args) {
        int arr[] = {50,3,10,7,40,80};

        System.out.println(LIS(arr));
    }

    public static int LIS(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) 
            set.add(arr[i]);
        
        int arr2[] = new int[set.size()];

        int i=0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }

        Arrays.sort(arr2);

        return LCS(arr,arr2);
    }

    public static int LCS(int a[],int b[]) {
        int n = a.length;
        int m = b.length;

        int dp[][] = new int[n+1][m+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(a[i-1] == b[j-1])
                dp[i][j] = 1 + dp[i-1][j-1];

                else
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
}
