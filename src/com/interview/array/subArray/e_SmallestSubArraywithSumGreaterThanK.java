package com.interview.array.subArray;

public class e_SmallestSubArraywithSumGreaterThanK {

    public int smallestSubWithSumGreaterThanK(int arr[], int k) {
        int n = arr.length;
        int curr_sum = 0, length = Integer.MAX_VALUE;
        int start = 0, end = 0;

        while (end < n) {

            while (curr_sum <= k && end < n) {
                curr_sum = curr_sum + arr[end];
                end++;
            }

            while (curr_sum > k && start < n) {
                if (end - start < length)
                    length = end - start;

                curr_sum = curr_sum - arr[start];
                start++;
            }
        }
        return length;
    }
}
