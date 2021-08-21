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

    public void minFromSortedRotated_2(){
        int[] arr = {11, 3, 5, 7, 9};
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;

        while(low < high) {
            int mid = low + (high - low)/2;
            if(arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]) {
                System.out.print(arr[mid]);
                break;
            }else if(arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }

    }
}
