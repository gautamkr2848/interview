package com.interview.array;

import java.util.Arrays;

public class CountPairsWithDiffK {

    public int countPairsWithDiffK(int arr[], int n, int k) {
        int count = 0;
        Arrays.sort(arr); // Sort array elements

        int l = 0, r = 0;
        while(r < n) {
            if(arr[r] - arr[l] == k) {
                count++;
                l++;
                r++;
            } else if(arr[r] - arr[l] > k)
                l++;
            else // arr[r] - arr[l] < sum
                r++;
        }
        return count;
    }
}
