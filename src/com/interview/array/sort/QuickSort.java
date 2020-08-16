package com.interview.array.sort;

public class QuickSort {

    public void quickSort(){
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        qs(arr, 0, n-1);

        for(int i=0; i<n; i++)
            System.out.print(arr[i] + " ");
    }

    private void qs(int arr[], int low, int high){
        if (low < high) {
            int pi = partition(arr, low, high);
            qs(arr, low, pi-1);
            qs(arr, pi+1, high);
        }
    }

    private int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++) {
            if (arr[j] < pivot) {   // If current element is smaller than the pivot
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
