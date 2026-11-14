package com.spa.leetcode.medium;

public class DominoAndTrominoTiling {

    // https://leetcode.com/problems/domino-and-tromino-tiling/submissions/1626452630/

    public int numTilings(int n) {
        // Initialize a DP array to store tiling counts for 4 states
        // f[0]: full covering, f[1]: top row is missing, f[2]: bottom row is missing, f[3]: transitional state (both rows are missing)
        long[] dp = {1, 0, 0, 0};
      
        // Modulo value to prevent overflow
        int mod = (int) 1e9 + 7;
      
        // Iterate over the sequence from 1 to n
        for (int i = 1; i <= n; ++i) {
            // Temporary array to hold the new states counts
            long[] newDp = new long[4];
          
            // New full covering can be achieved from any previous state
            newDp[0] = (dp[0] + dp[1] + dp[2] + dp[3]) % mod;
          
            // New top missing can be achieved from state when previously bottom was missing and the transitional state
            newDp[1] = (dp[2] + dp[3]) % mod;
          
            // New bottom missing can be achieved from state when previously top was missing and the transitional state
            newDp[2] = (dp[1] + dp[3]) % mod;
          
            // New transitional state comes solely from previous full covering state
            newDp[3] = dp[0];
          
            // Update the dp array for the next iteration
            dp = newDp;
        }
      
        // After completing all iterations, the count of fully covered tilings is in dp[0]
        return (int) dp[0];
    }
}
