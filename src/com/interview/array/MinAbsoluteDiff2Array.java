package com.interview.array;

import java.util.Arrays;

public class MinAbsoluteDiff2Array {

    public void MinAbsoluteDiff2Array(int[] A, int[] B){
        int m = A.length;
        int n = B.length;
        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0;
        int result = Integer.MAX_VALUE;
        while (i < m && j < n) {
            if (Math.abs(A[i] - B[j]) < result)
                result = Math.abs(A[i] - B[j]);

            if (A[i] < B[j])
                i++;
            else
                j++;
        }
        System.out.println(result);
    }
}
