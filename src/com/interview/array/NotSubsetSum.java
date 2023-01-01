package com.interview.array;

/*
Given a sorted array (sorted in non-decreasing order) of positive numbers,
find the smallest positive integer value that cannot be represented as sum of
elements of any subset of given set.
        Input:  arr[] = {1, 3, 6, 10, 11, 15};
        Output: 2
*/

public class NotSubsetSum {

    public void findSmallest(int[] arr, int n) {
        int res = 1;
        for (int i = 0; i < n && arr[i] <= res; i++)
            res = res + arr[i];

        System.out.println(res);
    }
}
