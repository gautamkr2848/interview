package com.interview.recursion;

public class Knapsack_0_1 {

    //Given weights and values of n items, put these items in a knapsack of capacity W
    // to get the maximum total value in the knapsack.

    public int knapSack(int W, int wt[], int val[], int n){
        if (n == 0 || W == 0)
            return 0;

        if (wt[n-1] > W)
            return knapSack(W, wt, val, n-1);
        else
            return Math.max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
                    knapSack(W, wt, val, n-1));
    }

}
