package com.interview.stack;

//water[i] = Math.min(Greatest element in right array, Greatest element in left array) - height[i]
/*
arr[] =   {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
left[] =  {0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3}
right[] = {3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1}
*/

public class WaterTapping {
    int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    int n = arr.length;

    public void waterTapping(){

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
