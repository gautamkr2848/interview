package com.interview.dynamic.knapsack;

/*Knapsack    => Bag
    1. 0-1  => we can't break the item'
    2. Fractional   => we can break the item
    3. Unbounded    => we can add same item multiple item*/

import java.util.Arrays;

public class a_KnapSack_0_1 {

    public int knapSack_1(int[] wt, int[] val, int w, int n){
        if(n == 0 || w == 0)
            return 0;

        if(wt[n-1] > w)
            return knapSack_1(wt, val, w, n-1);
        else
            return Math.max(val[n-1] + knapSack_1(wt, val, w-wt[n-1], n-1), knapSack_1(wt, val, w, n-1));
    }

    static int[][] t = new int[5][51];
    public a_KnapSack_0_1(){
        for(int[] arr : t)
            Arrays.fill(arr, -1);
    }

    public int knapSack_2(int[] wt, int[] val, int w, int n){
        if(n == 0 || w == 0)
            return 0;
        if(t[n][w] != -1)
            return t[n][w];

        if(wt[n-1] > w)
            t[n][w] = knapSack_2(wt, val, w, n-1);
        else
            t[n][w] = Math.max(val[n-1] + knapSack_2(wt, val, w-wt[n-1], n-1), knapSack_2(wt, val, w, n-1));
        return t[n][w];
    }

    public int knapSack_3(int[] wt, int[] val, int w, int n){
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
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
            }
        }
        return t[n][w];
    }
}
