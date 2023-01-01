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

    public int findMin() {
        int[] a = {11, 13, 15, 17, 9};
        int n = a.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(a[mid] == a[high] || (a[mid] < a[mid + 1] && a[mid] < a[mid - 1]))
                return a[mid];

            if(a[mid] > a[high])
                low = mid + 1;
            else
                high = mid;
        }

        return -1;
    }
}
