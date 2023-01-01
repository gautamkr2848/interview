package com.interview.array.sort;

/*First convert the original array to create the heap out of the array
  Then move the max element to last position and do heapify to recreate the heap
  with rest of the array element. Repeat this process*/

public class HeapSort {

    e_QuickSort q = new e_QuickSort();
    public void heapSort(){
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i=n-1; i>0; i--) {
            q.swap(arr, 0, i);
            heapify(arr, i, 0);
        }

        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
    }

    private void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            q.swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
}
