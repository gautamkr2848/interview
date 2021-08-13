package com.interview.dynamic.knapsack;

//Target sum is same as this

/*
s1 + s2 = sum
s1 - s2 = diff
----------------
2s1 = sum + diff
s1 = (sum + diff) / 2;
*/

public class e_SubsetDiffCount {

    public void subsetDiffCount(int[] arr, int diff){
        int sum = 0;
        int n = arr.length;
        for(int i=0; i<n; i++)
            sum += arr[i];

        sum = (sum + diff) / 2;
        d_SubsetSumCount s = new d_SubsetSumCount();
        s.subsetSumCount(arr, sum);
    }
}
