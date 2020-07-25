package com.interview.string;

public class MaxAfterKSwap {

    public void maxAfterKSwap(int[] arr, int k) {
        int pos[] = new int[arr.length + 1];

        for (int i = 0; i < arr.length; ++i)
            pos[arr[i]] = i;

        for (int i = 0; i < arr.length && k > 0; ++i) {

            // If element is already i'th largest, then no need to swap
            if (arr[i] == arr.length - i)
                continue;

            // Find position of i'th largest value, n-i
            int temp = pos[arr.length - i];

            // Swap the elements position
            pos[arr[i]] = pos[arr.length - i];
            pos[arr.length - i] = i;

            // Swap the ith largest value with the current value at ith place
            int tmp1 = arr[temp];
            arr[temp] = arr[i];
            arr[i] = tmp1;
            --k;
        }

        for(int i=0; i < arr.length; i++)
            System.out.print(arr[i]);
    }
}
