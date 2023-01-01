package com.interview.dynamic.knapsack;

/*
Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True
There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
There is no subset that add up to 30.
*/

public class b_SubsetSum {

    public void subSetSum(int[] arr, int sum){
        int n = arr.length;
        boolean[][] t = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= sum; i++)
            t[0][i] = false;
        for (int i = 0; i <= n; i++)
            t[i][0] = true;

        for(int i=1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1] > j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
            }
        }
        System.out.println(t[n][sum]);
    }
}
