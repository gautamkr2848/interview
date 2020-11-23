package com.interview.dynamic.knapsack;

//Target sum is same as this

public class f_SubsetDiffCount {

    public void subsetDiffCount(int[] arr, int diff){
        int sum = 0;
        int n = arr.length;
        for(int i=0; i<n; i++)
            sum += arr[i];

        sum = (sum + diff) / 2;
        d_SubsetSumCount s = new d_SubsetSumCount();
        s.subsetSumCount_4(arr, sum);
    }
}
