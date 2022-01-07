package com.interview.string;

public class MaxAfterKSwap {

    public String MaxNum(int[] arr, int s) {
        int[] result = new int[arr.length];

        int ans=0;
        for (int k = 1; k <arr.length; k++) {
            result = swap(arr, k, 0);
            ans=Math.max(result[0],arr[0]);
            MaxNum(result, s-1);
            swap(arr, k, 0);
        }

        return String.valueOf(result);
    }

    private int[] swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

        return arr;
    }
}
