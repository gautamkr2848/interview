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

public class b_MaxSumCircularSubArray {

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
}
