package com.interview.array.binarySearch;

public class b_FindMin {

    public int minFromSortedRotated(){
        int[] arr = {11, 3, 5, 7, 9};
        int low = 0;
        int high = arr.length - 1;

        while(low < high) {
            int mid = low + (high - low)/2;
            if (arr[mid] == arr[high])
                high--;
            else if(arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
        return arr[high];
    }
}
