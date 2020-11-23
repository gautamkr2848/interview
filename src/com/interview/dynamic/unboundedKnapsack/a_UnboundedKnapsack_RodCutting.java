package com.interview.dynamic.unboundedKnapsack;

/*
For Rod Cutting
    wt[] => length[]
    price[] => value[]
    W => length or n
*/

public class a_UnboundedKnapsack_RodCutting {

    public void unbounded(int[] wt, int[] val, int w, int n){
        int[][] t = new int[n+1][w+1];
        for (int i = 0; i <= w; i++)
            t[0][i] = 0;
        for (int i = 0; i <= n; i++)
            t[i][0] = 0;

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
