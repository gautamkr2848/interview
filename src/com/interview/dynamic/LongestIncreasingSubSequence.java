package com.interview.dynamic;

public class LongestIncreasingSubSequence {

    public int longestIncreasingSubSequence(int[] arr){

        int n = arr.length;
        int T[] = new int[n];
        int max = 0;

        /* Initialize LIS values for all indexes */
        for (int i = 0; i < n; i++ )
            T[i] = 1;

        /* Compute optimized LIS values in bottom up manner */
        for (int i = 1; i < n; i++ )
            for (int j = 0; j < i; j++ )
                if ( arr[i] > arr[j] && T[i] < T[j] + 1)
                    T[i] = T[j] + 1;

        /* Pick maximum of all LIS values */
        for (int i = 0; i < n; i++ )
            if ( max < T[i] )
                max = T[i];

        return max;
    }
}
