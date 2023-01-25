package com.interview.array.subArray;

import com.interview.array.subArray.slidingWindow.a_Kadane;

import java.util.Arrays;

/* Return the maximum of the following:
            1. Sum returned by Kadane’s algorithm on the original array.
            2. Sum returned by Kadane’s algorithm on the modified array +
               the sum of all the array elements.

Input: arr[] = {8, -8, 9, -9, 10, -11, 12}
Output: 22
Explanation: Subarray 12, 8, -8, 9, -9, 10 gives the maximum sum, that is 22.

Input: arr[] = {10, -3, -4, 7, 6, 5, -4, -1}
Output:  23
Explanation: Subarray 7, 6, 5, -4, -1, 10 gives the maximum sum, that is 23.
*/

public class c_MaxSumCircularSubArray {

    public int runCircularKadane(int[] A) {
        if (A.length == 0)
            return 0;

        int max = Arrays.stream(A).max().getAsInt();

        if (max < 0)  // if the array contains all negative values, return the maximum element
            return max;

        int sum = Arrays.stream(A).sum();

        a_Kadane k = new a_Kadane();
        int kadane = k.Kadane(A);

        Arrays.setAll(A, i -> -A[i]);   // negate all the array elements
        int tmp = k.Kadane(A);

        return Integer.max(kadane, sum + tmp);
    }

    public int maxCircularSum(int a[], int n) {

        if (n == 1)
            return a[0];

        int sum = Arrays.stream(a).sum();

        int curr_max = a[0], max_so_far = a[0],
                curr_min = a[0], min_so_far = a[0];

        for (int i = 1; i < n; i++) {

            // Kadane's Algorithm to find Maximum subarray
            // sum.
            curr_max = Math.max(curr_max + a[i], a[i]);
            max_so_far = Math.max(max_so_far, curr_max);

            // Kadane's Algorithm to find Minimum subarray
            // sum.
            curr_min = Math.min(curr_min + a[i], a[i]);
            min_so_far = Math.min(min_so_far, curr_min);
        }

        if (min_so_far == sum)
            return max_so_far;

        return Math.max(max_so_far, sum - min_so_far);
    }
}
