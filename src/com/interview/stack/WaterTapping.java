package com.interview.stack;

import java.util.Stack;

public class WaterTapping {

    //water[i] = Math.min(Greatest element in right array - Greatest element in left array) - height[i]
    public void waterTapping(){
        int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int n = arr.length;

        int left[] = new int[n];
        int right[] = new int[n];
        int water = 0;

        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], arr[i]);

        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);

        for (int i = 0; i < n; i++)
            water = water + Math.min(left[i], right[i]) - arr[i];

        System.out.print(water);
    }
}
