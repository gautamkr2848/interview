package com.interview.array.binarySearch;

public class c_FirstAndLastOccurance {

    public int c_FirstAndLastOccurance(){
        int[] arr = {1, 3, 5, 11, 15};
        int key = 11;
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == key) {
                result = mid;
                high = mid - 1;     //for last occurance low = mid + 1
            } else if(key < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return result;
    }
}
