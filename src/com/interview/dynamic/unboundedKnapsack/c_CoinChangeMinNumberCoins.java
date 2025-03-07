package com.interview.dynamic.unboundedKnapsack;

//Find minimum number of coins that make a given value

import java.util.Arrays;

// The minimum number of coins for a value V can be computed using the below recursive formula.

// If V == 0:
//      0 coins required
// If V > 0:
//      minCoins(coins[0..m-1], V ) = min { 1 + minCoins(V-coin[i])} where, 0 <=i <= m-1 and coins[i] <= V.

public class  c_CoinChangeMinNumberCoins {

    public static void coinChangeMinNumberCoins(){
        int[] coinArray = {25, 10, 5};
        int sum = 30;
        int n = coinArray.length;
        int[][] t = new int[n+1][sum+1];

        for (int i = 0; i <= n; i++)
            t[i][0] = 0;
        for (int i = 0; i <= sum; i++) {
            t[0][i] = Integer.MAX_VALUE - 1;

            if( sum % coinArray[0] == 0)
                t[1][i] = sum / coinArray[0];
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

    public static int minCoins(int[] arr, int k, int n) {
        if(n == 0) {
            if(k % arr[0] == 0)
                return k / arr[0];
            else
                return Integer.MAX_VALUE-1;
        }

        int left = 0 + minCoins(arr, k, n-1);
        int right = Integer.MAX_VALUE;
        if(arr[n] <= k)
            right = 1 + minCoins(arr, k - arr[n], n);

        return Math.min(left, right);
    }

    public static void main(String[] args) {
        int arr[] =  {25, 5, 10};
        int n = arr.length-1;
        int k = 30;
        //System.out.println(minCoins(arr, k, n));
        //coinChangeMinNumberCoins();
        coinChangeMinNumberCoins();
    }

    public static int minCoinsUtil(int[] coins, int m, int V, int[] dp) {

        if (V == 0)
            return 0;

        if (dp[V] != -1)
            return dp[V];

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            if (coins[i] <= V) {
                int sub_res = minCoinsUtil( coins, m, V - coins[i], dp);

                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }
        dp[V] = res;
        return res;
    }
}
