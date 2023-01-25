package com.interview.dynamic.LCS;

import java.util.*;

/*
If we closely observe the problem then we can convert this problem to longest Common Subsequence Problem.

Firstly we will create another array of unique elements of original array and sort it.
Now the longest increasing subsequence of our array must be present as a subsequence in our sorted array. That’s why
our problem is now reduced to finding the common subsequence between the two arrays.
*/

public class a_2_LongestIncreasingSubsequence {

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

    public void longestIncreasingSubSequence_2(){
        //int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int arr[] = {5, 13, 2, 11, 6, 8, 14, 8, 13};
        int n = arr.length;
        int max = 0;
        for(int i=0; i< Math.pow(2,n); i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<n; j++){
                if ((i & (int)(Math.pow(2,j))) > 0)
                    list.add(arr[j]);
            }

            int k;
            for(k=0; k<list.size()-1;k++) {
                if(!(list.get(k) < list.get(k+1))){
                    break;
                }
            }
            if (k == list.size()-1 && list.size() > max)
                max = list.size();
        }
        System.out.println(max);
    }
}
