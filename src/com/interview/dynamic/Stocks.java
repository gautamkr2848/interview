package com.interview.dynamic;

import java.util.Arrays;

public class Stocks {

    // For 1 txn
    public void maxProfitWithOneTxn(int arr[]) {
        int minSoFar = arr[0];
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minSoFar)
                minSoFar = arr[i];
            else if(arr[i] - minSoFar > profit)
                profit = arr[i] - minSoFar;
        }

        System.out.print(profit);
    }

    //Time Complexity: O(N)
    //Space Complexity: O(1)

    // Any number of txn
    public static int getMaximumProfit_recurssion(int[] arr, int index, int buy, int n) {
        if(index == n)  return 0;

        int profit = 0;
        if(buy == 0) {
            profit = Math.max(getMaximumProfit_recurssion(arr, index+1, 0, n),              // can not buy
                    getMaximumProfit_recurssion(arr, index+1, 1, n) - arr[index]);          // can buy
        } else {
            profit = Math.max(getMaximumProfit_recurssion(arr, index+1, 1, n),              // can not sell
                    getMaximumProfit_recurssion(arr, index+1, 0, n) + arr[index]);          // can sell
        }
        return profit;
    }

    // Time Complexity: O(2 pow N)
    // spaace Complexity: O(N)

    static int[][] dp = new int[1000][2];
    public static int getMaximumProfit_memorization(int[] arr, int index, int buy, int n) {
        if(index == n)  return 0;

        if(dp[index][buy] != -1) return dp[index][buy];

        int profit = 0;
        if(buy == 0) {
            profit = Math.max(getMaximumProfit_memorization(arr, index+1, 0, n),              // can not buy
                    getMaximumProfit_memorization(arr, index+1, 1, n) - arr[index]);          // can buy
        } else {
            profit = Math.max(getMaximumProfit_memorization(arr, index+1, 1, n),              // can not sell
                    getMaximumProfit_memorization(arr, index+1, 0, n) + arr[index]);          // can sell
        }
        dp[index][buy] = profit;
        return dp[index][buy];
    }

    public static long getMaximumProfit(long[] arr, int n) {
        long[][] dp = new long[n + 1][2];

        dp[n][0] = dp[n][1] = 0;        // Base condition: If we have no stocks to buy or sell, profit is 0
        long profit = 0;

        // Iterate through the array in reverse to calculate the maximum profit
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0)  // We can buy the stock
                    profit = Math.max(0 + dp[i + 1][0], -arr[i] + dp[i + 1][1]);

                if (buy == 1)  // We can sell the stock
                    profit = Math.max(0 + dp[i + 1][1], arr[i] + dp[i + 1][0]);

                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }

    // Time Complexity: O(N*2)
    // Space Complexity: O(N*2)

    // We can’t buy a stock on the very next day of selling it. This is the cooldown clause.
    public static int stockProfit(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n + 2][2];

        // Iterate through the array backwards
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[i + 1][0], -arr[i] + dp[i + 1][1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + dp[i + 1][1], arr[i] + dp[i + 2][0]);
                }

                dp[i][buy] = profit;
            }
        }

        // The maximum profit is stored in dp[0][0]
        return dp[0][0];
    }

    //Time Complexity: O(N*2)
    //Space Complexity: O(N*2)

    // After every transaction, there is a transaction fee (‘fee’) associated with it.
    public static int maximumProfit(int n, int fee, int[] arr) {
        // Handle the base case when n is 0
        if (n == 0)
            return 0;

        int dp[][] = new int[n + 1][2];

        // Iterate through the array backwards
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[i + 1][0], -arr[i] + dp[i + 1][1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + dp[i + 1][1], arr[i] - fee + dp[i + 1][0]);
                }

                dp[i][buy] = profit;
            }
        }
        return dp[0][0];
    }

    // Time Complexity: O(N*2)
    // Space Complexity: O(N*2)
}
