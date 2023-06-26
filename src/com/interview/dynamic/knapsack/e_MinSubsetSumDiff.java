package com.interview.dynamic.knapsack;

/*
    sum = set1 + set2
    sum = s1 + s2
    s2 = sum - s1

    Math.abs(s2 - s1)
    Math.abs(sum - s1 - s1)
    Math.abs(sum - 2s1)

    Input:  arr[] = {1, 6, 11, 5}
    Output: 1
    Explanation:
    Subset1 = {1, 5, 6}, sum of Subset1 = 12
    Subset2 = {11}, sum of Subset2 = 11
*/

import java.util.Arrays;

public class e_MinSubsetSumDiff {

    public void minSubsetSumDiff(){
        int[] arr = {3, 1, 4, 2, 2, 1};
        int sum = Arrays.stream(arr).sum();
        int n = arr.length;

        boolean t[][] = new boolean[n+1][sum+1];

        for (int i = 0; i <= sum; i++)
            t[0][i] = false;
        for (int i = 0; i <= n; i++)
            t[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                if (arr[i - 1] > j)
                    t[i][j] = t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j] || t[i - 1][j - arr[i - 1]];
            }
        }

        int diff = Integer.MAX_VALUE;

        //The idea is, sum of S1 is j and it should be closest
        //to sum/2, i.e., 2*j should be closest to sum (as this will ideally minimize sum-2*j)

        for (int j = sum / 2; j >= 0; j--){
            if (t[n][j] == true){
                diff = Math.min(diff, sum - 2*j);
            }
        }
        System.out.println(diff);
    }
}
