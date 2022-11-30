package com.interview.array;

import java.util.Arrays;

/*

Input  : {1, 5, 3, 19, 18, 25};
Output : 1
Minimum difference is between 18 and 19

Input  : {30, 5, 20, 9};
Output : 4
Minimum difference is between 5 and 9

 */

public class MinDiff {

    public void minimum_difference(int[] arr) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;

        for (int i=0; i<arr.length-1; i++)
            if (arr[i+1] - arr[i] < diff)
                diff = arr[i+1] - arr[i];

        System.out.println(diff);
    }
}
