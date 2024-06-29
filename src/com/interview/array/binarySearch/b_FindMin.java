package com.interview.array.binarySearch;

public class b_FindMin {

    public static int findMin() {
        int[] arr = {18, 11, 13, 15, 17};
        int n = arr.length;
        int low = 0;
        int high = n-1;

        if (arr[low] <= arr[high])
            return arr[low];

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < arr[mid - 1])        // Check if mid is the minimum element
                return arr[mid];

            if (arr[mid] > arr[high])       // If the left half is sorted, the minimum element must be in the right half
                low = mid + 1;
            else      // If the right half is sorted, the minimum element must be in the left half
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(findMin());
    }
}
