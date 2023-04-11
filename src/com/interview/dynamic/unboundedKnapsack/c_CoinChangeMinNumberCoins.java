package com.interview.dynamic.unboundedKnapsack;

//Find minimum number of coins that make a given value

public class  c_CoinChangeMinNumberCoins {

    public void coinChangeMinNumberCoins(){
        int[] coinArray = {25, 10, 5, 20 };
        int sum = 35;
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

    public int minCoins_2(int coins[], int m, int sum) {

        int table[] = new int[sum + 1];
        table[0] = 0;

        for (int i = 1; i <= sum; i++)
            table[i] = Integer.MAX_VALUE;

        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < m; j++) {
                if (coins[j] <= i) {
                    int tmp = table[i - coins[j]];
                    if (tmp != Integer.MAX_VALUE && tmp + 1 < table[i])
                        table[i] = tmp + 1;
                }
            }
        }

        if(table[sum]==Integer.MAX_VALUE)
            return -1;

        return table[sum];
    }
    //Time complexity: O(m*V).
    //Auxiliary space: O(V)
}
