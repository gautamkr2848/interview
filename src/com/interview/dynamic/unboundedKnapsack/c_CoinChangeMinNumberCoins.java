package com.interview.dynamic.unboundedKnapsack;

//Find minimum number of coins that make a given value

import java.util.Arrays;

// The minimum number of coins for a value V can be computed using the below recursive formula.

// If V == 0:
//      0 coins required
// If V > 0:
//      minCoins(coins[0..m-1], V ) = min { 1 + minCoins(V-coin[i])} where, 0 <=i <= m-1 and coins[i] <= V.

public class  c_CoinChangeMinNumberCoins {

    public int minCoins_1(int coins[], int n, int sum) {

        if (sum == 0)
            return 0;
        int res = Integer.MAX_VALUE;

        for (int i=0; i<n; i++) {
            if (coins[i] <= sum) {
                int tmp = minCoins_1(coins, n, sum-coins[i]);

                if (tmp != Integer.MAX_VALUE && tmp + 1 < res)      // Check for INT_MAX to avoid overflow and see if result can minimized
                    res = tmp + 1;
            }
        }
        return res;
    }
    //Time complexity: exponential
    //Auxiliary space: O(n)

    public int minCoins_2(int coins[], int n, int sum) {

        int table[] = new int[sum + 1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;

        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    int tmp = table[i - coins[j]];
                    if (tmp != Integer.MAX_VALUE && tmp + 1 < table[i])
                        table[i] = tmp + 1;
                }
            }
        }

        return table[sum] == Integer.MAX_VALUE ? -1 : table[sum];
    }
    //Time complexity: O(m*V).
    //Auxiliary space: O(V)

    public void coinChangeMinNumberCoins(){
        int[] coinArray = {9, 10, 20, 5};
        int sum = 45;
        int n = coinArray.length;
        int[][] t = new int[n+1][sum+1];

        for (int i = 0; i <= n; i++)
            t[i][0] = 0;
        for (int i = 0; i <= sum; i++) {
            t[0][i] = Integer.MAX_VALUE - 1;

            if(coinArray[0] % sum == 0)
                t[1][i] = coinArray[0] / sum;
            else
                t[1][i] = Integer.MAX_VALUE - 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(coinArray[i-1] > j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = Math.min(1 + t[i][j-coinArray[i-1]], t[i-1][j]);
            }
        }
        System.out.println(t[n][sum]);
    }
}
