package com.interview.dynamic.knapsack;

//Target sum is same as this

/*
s1 + s2 = sum
s1 - s2 = diff
----------------
2s1 = sum + diff
s1 = (sum + diff) / 2;


Input: N = 4, arr[] = [5, 2, 6, 4], diff = 3
Output: 1
Explanation: We can only have a single partition which is shown below:
{5, 2} and {6, 4} such that S1 = 7 and S2 = 10 and thus the difference is 3

Input: N = 5, arr[] = [1, 2, 3, 1, 2], diff = 1
Output: 5
Explanation: We can have five partitions which is shown below
{1, 3, 1} and {2, 2} – S1 = 5, S2 = 4
{1, 2, 2} and {1, 3} – S1 = 5, S2 = 4
{3, 2} and {1, 1, 2} – S1 = 5, S2 = 4
{1, 2, 2} and {1, 3} – S1 = 5, S2 = 4
{3, 2} and {1, 1, 2} – S1 = 5, S2 = 4
*/

import java.util.Arrays;

public class f_SubsetSumDiffCount {

    public void subsetDiffCount(int[] arr, int diff){
        int sum = Arrays.stream(arr).sum();

        sum = (sum + diff) / 2;
        d_SubsetSumCount s = new d_SubsetSumCount();
        s.subsetSumCount(arr, sum);
    }
}
