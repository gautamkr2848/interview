package com.interview.dynamic.unboundedKnapsack;

//Find minimum number of coins that make a given value

public class c_CoinChangeMinNumberCoins {

    public void coinChangeMinNumberCoins(int[] coinArray, int sum){
        int n = coinArray.length;
        int[][] t = new int[n+1][sum+1];

        for (int i = 0; i <= n; i++)
            t[i][0] = 0;
        for (int i = 0; i <= sum; i++)
            t[0][i] = Integer.MAX_VALUE - 1;
        for (int i = 0; i <= sum; i++) {
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
