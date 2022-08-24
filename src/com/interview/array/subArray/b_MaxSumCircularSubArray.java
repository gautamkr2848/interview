package com.interview.array.subArray;

import com.interview.array.subArray.slidingWindow.Kadane;

import java.util.Arrays;

/* Return the maximum of the following:
            1. Sum returned by Kadane’s algorithm on the original array.
            2. Sum returned by Kadane’s algorithm on the modified array +
               the sum of all the array elements.
        */

public class b_MaxSumCircularSubArray {

    public int runCircularKadane(int[] A) {
        if (A.length == 0)
            return 0;

        int max = Arrays.stream(A).max().getAsInt();

        if (max < 0)  // if the array contains all negative values, return the maximum element
            return max;

        Arrays.setAll(A, i -> -A[i]);   // negate all the array elements
        Kadane k = new Kadane();
        int tmp = k.Kadane(A);

        Arrays.setAll(A, i -> -A[i]);   // restore the array
        return Integer.max(k.Kadane(A), Arrays.stream(A).sum() + tmp);
    }
}
