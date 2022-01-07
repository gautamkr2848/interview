package com.interview.array.subArray;

/*
Input : arr[] = {5, 3, 9, 2, 7, 6, 4}
Output : 19
The subarray is {2, 7, 6, 4}.

forward = {5, 3, 12, 2, 9, 6, 4}
backward = [8, 3, 11, 2, 17, 10, 4]
 */

public class g_MaxSumBitonicSubArray {

    public void maxSumBitonicSubArray(){
        int[] arr = {5, 3, 9, 2, 7, 6, 4};
        int n = arr.length;
        int []forward = new int[n];
        int []backward = new int[n];
        int max_sum = Integer.MIN_VALUE;

        forward[0] = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > arr[i - 1])
                forward[i] = forward[i - 1] + arr[i];
            else
                forward[i] = arr[i];

        backward[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            if (arr[i] > arr[i + 1])
                backward[i] = backward[i + 1] + arr[i];
            else
                backward[i] = arr[i];

        for (int i = 0; i < n; i++) {
            int tmp = forward[i] + backward[i] - arr[i];
            if (max_sum < tmp)
                max_sum = tmp;
        }

        System.out.print(max_sum);
    }
}
