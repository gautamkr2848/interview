package com.interview.dynamic.LCS;

import java.util.Arrays;

public class a_3_Longest_Divisible_subset {

    static void findLargest(int[] arr) {
        int divCount[] = new int[arr.length];       // array that maintains the maximum index    till which the condition is satisfied
        Arrays.fill(divCount, 1);           // we will always have atleast one  element divisible by itself

        int prev[] = new int[arr.length];           // maintain the index of the last increment
        Arrays.fill(prev, -1);

        int max_ind = 0;        // index at which last increment happened

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {

                // only increment the maximum index if
                // this iteration will increase it
                if (arr[i] % arr[j] == 0 && divCount[i] < divCount[j] + 1) {
                    prev[i] = j;
                    divCount[i] = divCount[j] + 1;

                }

            }
            // Update last index of largest subset if size
            // of current subset is more.
            if (divCount[i] > divCount[max_ind])
                max_ind = i;
        }

        // Print result
        int k = max_ind;
        while (k >= 0) {
            System.out.print(arr[k] + " ");
            k = prev[k];
        }

    }
}
