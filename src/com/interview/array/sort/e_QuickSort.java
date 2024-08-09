package com.interview.array.sort;

public class    e_QuickSort {

    public static void main(String[] args) {
        qs();
    }
    public static void qs(){
        int arr[] = { 12, 3, 5, 7, 4, 19, 26 };
        int low = 0, high = arr.length-1;
        quickSort(arr, low, high);

        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private static void quickSort(int[] arr, int low, int high){
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high], i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot)
                swap(arr, i++, j);
        }
        swap(arr, i, high);
        return i;
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
