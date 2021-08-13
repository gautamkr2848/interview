package com.interview.array.sort;

public class Sort0_1_2 {

    public void sort0_1_2() {
        int[] arr = {1, 0, 0, 2, 1, 0, 2};
        int low = 0, mid = 0, high = arr.length - 1;
        int pivot = 1;
        while (mid <= high) {
            if (arr[mid] < pivot) {       // current element is 0
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] > pivot) {        // current element is 2
                swap(arr, mid, high);
                high--;
            } else {        // current element is 1
                mid++;
            }
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
