package com.interview.array.sort;

// Dutch National Flag problem

/*
Given N balls of colour red, white or blue arranged in a line in random order. You have to arrange all the balls such
that the balls with the same colours are adjacent with the order of the balls, with the order of the colours being red,
white and blue (i.e., all red coloured balls come first then the white coloured balls and then the blue coloured balls).
*/

public class h_Sort0_1_2 {

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
