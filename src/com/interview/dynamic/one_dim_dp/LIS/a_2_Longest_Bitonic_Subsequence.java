package com.interview.dynamic.one_dim_dp.LIS;

//       1 11 2 10 4 5 2 1

// LIS_L (Left to right) - 1 2  2 3  3 4 2 1
// LIS_R (right to left) - 1 5  2 4  3 3 2 1

// Longest_Bitonic_Subsequence - (LIS_R + LIS_L - 1)

import java.util.Arrays;

public class a_2_Longest_Bitonic_Subsequence {

    static int longestBitonicSequence(int[] arr, int n) {
        // Arrays to store lengths of increasing and decreasing subsequences
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        // Calculate the lengths of increasing subsequences
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[j]);
                }
            }
        }

        // Reverse the direction of nested loops and calculate the lengths of decreasing subsequences
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dp2[i] = Math.max(dp2[i], 1 + dp2[j]);
                }
            }
        }

        int maxi = -1;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }

        return maxi;
    }
}
