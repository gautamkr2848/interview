package com.interview.array.binarySearch;

public class FindMax {


    public int findMaximum() {
        int[] a = {1,15,25,45,42,21,17,12,11};
        int n = a.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(a[mid] > a[mid + 1] && a[mid] > a[mid - 1])
                return a[mid];

            if(a[mid] < a[mid + 1])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}
