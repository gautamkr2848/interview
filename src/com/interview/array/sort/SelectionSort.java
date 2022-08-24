package com.interview.array.sort;

/*10, 7, 8, 9, 1, 5
  1, 7, 8, 9, 10, 5
  1, 5, 8, 9, 10, 7
  1, 5, 7, 9, 10, 8
  1, 5, 7, 8, 10, 9
  1, 5, 7, 8, 9, 10*/

public class SelectionSort {

    QuickSort q = new QuickSort();
    public void selectionSort(){
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            int min = i;    // Find the minimum element in unsorted array
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min])
                    min = j;

            q.swap(arr, min, i);
        }
    }
}
