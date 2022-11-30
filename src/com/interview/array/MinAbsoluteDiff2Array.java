package com.interview.array;

import java.util.Arrays;

public class MinAbsoluteDiff2Array {

    public void MinAbsoluteDiff2Array(int[] A, int[] B){
        int m = A.length;
        int n = B.length;
        Arrays.sort(A);
        Arrays.sort(B);

        int a = 0, b = 0;
        int result = Integer.MAX_VALUE;
        while (a < m && b < n) {
            if (Math.abs(A[a] - B[b]) < result)
                result = Math.abs(A[a] - B[b]);

            if (A[a] < B[b])
                a++;
            else
                b++;
        }
        System.out.println(result);
    }
}
