package com.interview.array.sort;

// no. of swaps to sort the array

import java.util.Arrays;

public class ArrayInversion_merge {

    public void arrayInversion_1(){
        int[] a = {2, 4, 1, 5};
        int count = 0;
        for (int i = 0; i < a.length - 1; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[i] > a[j])
                    count++;
        System.out.println("Inversion count "+ count);
    }

    public int arrayInversion_2(int[] arr, int l, int r){
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count += arrayInversion_2(arr, l, m);
            count += arrayInversion_2(arr, m + 1, r);

            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }

    private int mergeAndCount(int[] arr, int l, int m, int r){

        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }

        while (i < left.length)
            arr[k++] = left[i++];

        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;
    }
}
