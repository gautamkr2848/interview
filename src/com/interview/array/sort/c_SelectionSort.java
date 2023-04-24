package com.interview.array.sort;

/*
  10, 7, 8, 9, 1, 5
  1, 7, 8, 9, 10, 5
  1, 5, 8, 9, 10, 7
  1, 5, 7, 9, 10, 8
  1, 5, 7, 8, 10, 9
  1, 5, 7, 8, 9, 10
*/

public class c_SelectionSort {

    e_QuickSort q = new e_QuickSort();
    public void selectionSort_2(){
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            int j = findMin(arr, i, n);
            q.swap(arr, i, j);
        }

        for(int i=0; i<n; i++)
            System.out.print(arr[i] + " ");
    }

    private int findMin(int[] arr, int start, int end){
        int min = start;
        for(int i=start + 1; i<end; i++){
            if(arr[i] < arr[min])
                min = i;
        }
        return min;
    }
}
