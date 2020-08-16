package com.interview.array.sort;

public class SelectionSort {

    public void selectionSort(){
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            int min = i;    // Find the minimum element in unsorted array
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min])
                    min = j;

            int temp = arr[min];    // Swap the found minimum element with the first element
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
