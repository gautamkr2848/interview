package com.interview.dynamic;

/*
Input: p[] = {0.3, 0.4, 0.7}
Output: 0.442
Probability for a tail = (1 – Probability for a head)
For heads greater than tails, there are 4 possibilities:
P({head, head, tail}) = 0.3 x 0.4 x (1 – 0.7) = 0.036
P({tail, head, head}) = (1 – 0.3) x 0.4 x 0.7 = 0.196
P({head, tail, head}) = 0.3 x (1 – 0.4) x 0.7= 0.126
P({head, head, head}) = 0.3 x 0.4 x 0.7 = 0.084
Adding the above probabilities
0.036 + 0.196 + 0.126 + 0.084 = 0.442

The idea is to use dynamic programming. Let’s assume dp[i][j] to be the probability of
getting j heads with first i coins. To get j heads at the ith position, there are two possibilities:

    1. If number of heads till (i – 1) coins is equal to j then a tail comes at ith.
    2. If number of heads till (i – 1) coins is equal to (j – 1) then a head comes at ith position

Hence, it can be broken into its subproblems as follows:
    dp[i][j] = dp[i – 1][j] * (1 – p[i]) + dp[i – 1][j – 1] * p[i]
*/
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
        for (int i = (n + 1) / 2; i <= n; i++)
            ans += dp[n][i];

        System.out.println(ans);
    }
}
