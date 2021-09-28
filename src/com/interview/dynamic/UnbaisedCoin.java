package com.interview.dynamic;

public class UnbaisedCoin {

    public void Probability() {

        double[] p =  {0.3, 0.4, 0.7};
        int n =p.length-1;
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 1.0;

        for (int i = 1; i <= n; i++) {   // Iterating for every coin
            for (int j = 0; j <= i; j++) {   // j represents the numbers of heads
                if (j == 0)
                    dp[i][j] = dp[i - 1][j] * (1.0 - p[i]);
                else
                    dp[i][j] = dp[i - 1][j] * (1.0 - p[i]) + dp[i - 1][j - 1] * p[i];
            }
        }

        double ans = 0.0;

        // When the number of heads is greater than (n+1)/2
        // it means that heads are greater than tails as
        // no of tails + no of heads is equal to n for
        // any permutation of heads and tails
        for (int i = (n + 1) / 2; i <= n; i += 1)
            ans += dp[n][i];

        System.out.println(ans);
    }
}
