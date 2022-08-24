package com.interview.array.sort;

/*10, 7, 8, 9, 1, 5
  7, 10, 8, 9, 1, 5
  7, 8, 10, 9, 1, 5
  7, 8, 9, 10, 1, 5
  1, 7, 8, 9, 10, 5
  1, 5, 7, 8, 9, 10*/

public class InsertionSort {

    public void insertionSort(){
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
