package com.interview.array.sort;

public class g_Sort0_1 {

    public void sort0_1() {
        int[] arr = {1, 0, 0, 1, 0, 1, 0};
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] == 1) {
                if (arr[end] != 1) {
                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                }
                end--;
            } else
                start++;
        }

        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
    }
}
