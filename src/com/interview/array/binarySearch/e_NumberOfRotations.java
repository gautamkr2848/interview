package com.interview.array.binarySearch;

public class e_NumberOfRotations {

    //idea is to find index of min element
    public int numberCount(int arr[]){
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

}
