package com.interview.array.binarySearch;

public class e_NumberOfRotations {

    //idea is to find index of min element
    int numberCount(int arr[]){
        int n = arr.length;
        int min = arr[0], min_index = -1;
        for (int i = 0; i < n; i++) {
            if (min > arr[i]) {
                min = arr[i];
                min_index = i;
            }
        }
        return min_index;
    }

    int numberCount_2(int arr[], int low, int high){
        if (high < low) return 0;
        if (high == low) return low;
        int mid = (low + high)/2;

        // Check if element (mid+1) is minimum element
        // {3, 4, 5, 1, 2}
        if (mid < high && arr[mid+1] < arr[mid])
            return (mid + 1);

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return mid;

        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
            return numberCount_2(arr, low, mid - 1);

        return numberCount_2(arr, mid + 1, high);
    }

}
