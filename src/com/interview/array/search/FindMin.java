package com.interview.array.search;

public class FindMin {

    int minFromSortedRotated(int arr[], int low, int high){
        while(low < high) {
            int mid = (low + high) / 2;
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
