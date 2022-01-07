package com.interview.array.subArray;

public class MaxSumSubArraySizeK {

    public int maxSum(int arr[], int n, int k) {
        if (n < k) {
            System.out.println("Invalid");
            return -1;
        }

        int res = 0;
        for (int i=0; i<k; i++)
            res += arr[i];

        int curr_sum = res;
        for (int i=k; i<n; i++) {
            curr_sum += arr[i] - arr[i-k];
            res = Math.max(res, curr_sum);
        }

        return res;
    }
}
