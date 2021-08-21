package com.interview.array;

import java.util.Arrays;

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
