package com.interview.dynamic.one_dim_dp.LIS;

import java.util.*;

/*
If we closely observe the problem then we can convert this problem to longest Common Subsequence Problem.

Firstly we will create another array of unique elements of original array and sort it.
Now the longest increasing subsequence of our array must be present as a subsequence in our sorted array. That’s why
our problem is now reduced to finding the common subsequence between the two arrays.
*/

public class a_1_LongestIncreasingSubsequence {

    public void lis() {
        int[] arr = {50,3,10,7,40,80};
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(arr[i]);

        int lis[] = new int[set.size()];
        int k = 0;
        for (int val : set)
            lis[k++] = val;

        Arrays.sort(lis);

        int m = set.size();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[j - 1] == lis[i - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[m][n]);
    }

    public static int longestIncreasingSubsequence(int arr[], int n){

        int dp[]=new int[n];
        Arrays.fill(dp,1);

        for(int i=0; i<n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int ans = -1;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {50,3,10,7,40,80};
        int n = arr.length;
        longestIncreasingSubsequence(arr, n);
    }
}
