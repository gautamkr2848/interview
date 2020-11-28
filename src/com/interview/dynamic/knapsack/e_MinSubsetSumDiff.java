package com.interview.dynamic.knapsack;

/*
    sum = set1 + set2
    sum = s1 + s2
    s2 = sum - s1

    Math.abs(s2 - s1)
    Math.abs(sum - s1 - s1)
    Math.abs(sum - 2s1)
*/

public class e_MinSubsetSumDiff {

    public void minSubsetSumDiff(){
        int[] arr = {3, 1, 4, 2, 2, 1};
        int sum = 0;
        int n = arr.length;
        for(int i=0; i<n; i++)
            sum += arr[i];

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
                    t[i][j] = t[i-1][j] || t[i - 1][j - arr[i - 1]];
            }
        }

        int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--){
            if (t[n][j] == true){
                diff = Math.min(diff, sum - 2*j);
            }
        }
        System.out.println(diff);
    }
}
