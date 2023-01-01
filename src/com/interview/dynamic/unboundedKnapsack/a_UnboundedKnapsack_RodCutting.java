package com.interview.dynamic.unboundedKnapsack;

/*
For Rod Cutting
    wt[] => length[]
    price[] => value[]
    W => length or n


Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
Determine the maximum value obtainable by cutting up the rod and selling the pieces.
*/

public class a_UnboundedKnapsack_RodCutting {

    public void unbounded(int[] wt, int[] val, int w, int n){
        int[][] t = new int[n+1][w+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {

                if (wt[i - 1] > j)
                    t[i][j] = t[i - 1][j];
                else
                    t[i][j] = Math.max(val[i - 1] + t[i][j - wt[i - 1]], t[i - 1][j]);
            }
        }
         System.out.println(t[n][w]);
    }
}
