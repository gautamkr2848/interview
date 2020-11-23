package com.interview.array.binarySearch;

public class a_BinarySearch {

    public int binarySearch(int[] arr, int key, int low, int high){

        if(low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key)
                return mid;

            if (arr[mid] < key)
                return binarySearch(arr, key, mid + 1, high);
            else
                return binarySearch(arr, key, low, mid - 1);
        }
        return -1;
    }

    public int binarySearch_2(){
        int[] arr = {1, 3, 5, 11, 15};
        int key = 11;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == key)
                return mid;
            else if(key < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
