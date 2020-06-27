package com.interview.dynamic;

public class CoinChange {

    public void coinChange(){
        int Coins[] = { 1, 5, 10 };
        int n = 12;
        int[] ways = new int[n + 1];
        ways[0] = 1;

        for (int i = 0; i < Coins.length; i++) {
            for (int j = 0; j < ways.length; j++) {
                if (Coins[i] <= j)
                    ways[j] = ways[j] + ways[(j - Coins[i])];
            }
        }
        System.out.println(ways[n]);
    }
}
