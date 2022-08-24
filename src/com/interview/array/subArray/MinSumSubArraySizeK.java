package com.interview.array.subArray;

public class MinSumSubArraySizeK {

    public void findSubarray(int[] arr, int n, int k) {
        if (n < k)
            System.out.println("Invalid");

        int res = 0;
        for (int i=0; i<k; i++)
            res += arr[i];

        int curr_sum = res;
        for (int i=k; i<n; i++) {
            curr_sum += arr[i] - arr[i-k];
            res = Math.min(res, curr_sum);
        }
        System.out.println(res);
    }

}
