package com.interview.array;

import java.util.Arrays;

public class ZigZagArray {

    public void zigZag(){
        int arr[] = new int[]{4, 3, 7, 8, 6, 2, 1};
        boolean flag = false;

        for (int i=0; i<arr.length-1; i++) {
            if (flag) {
                if (arr[i] < arr[i+1]) {
                    arr = swap(arr, i);
                }
            } else {
                if (arr[i] > arr[i+1]) {
                    arr = swap(arr, i);
                }
            }
            flag = !flag;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] swap(int[] a, int pos){

        int temp  = a[pos];
        a[pos] = a[pos+1];
        a[pos+1] = temp;

        return a;
    }
}
