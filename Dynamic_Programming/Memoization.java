package Dynamic_Programming;

// Top-down approach
// memoization is about recursion
// In memoization first we will solve subproblem then store them in storage and then we can reuse them
// create skewed recusrion tree

// example  fibonacci

class Memoization {
    public static void main(String[] args) {
        int n=5;

        int dp[] = new int[n+1];
        System.out.println(fibonacci(n, dp));
    }

    public static int fibonacci(int n,int dp[]){
        if(n ==0 || n== 1)
        return n;

        // if dp[n] is already finded then just return that
        if(dp[n] !=0)
        return dp[n];

        dp[n] = fibonacci(n-1, dp) + fibonacci(n-2, dp);  // store them in our array (storage)

        return dp[n];
    }
}