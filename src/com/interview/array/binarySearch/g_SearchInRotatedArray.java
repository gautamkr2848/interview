package com.interview.array.binarySearch;

/*
1) Find middle point mid = (l + h)/2
2) If key is present at middle point, return mid.
3) Else If arr[l..mid] is sorted
    a) If key to be searched lies in range from arr[l]
       to arr[mid], recur for arr[l..mid].
    b) Else recur for arr[mid+1..h]
4) Else (arr[mid+1..h] must be sorted)
    a) If key to be searched lies in range from arr[mid+1]
       to arr[h], recur for arr[mid+1..h].
    b) Else recur for arr[l..mid]
 */

public class g_SearchInRotatedArray {

    public int search(int arr[], int l, int h, int key) {
        if (l > h) return -1;

        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;

        if (arr[l] <= arr[mid]) {       // left array is sorted
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
            else
                return search(arr, mid + 1, h, key);
        } else {        // right array is sorted
            if (key >= arr[mid] && key <= arr[h])
                return search(arr, mid + 1, h, key);
            else
                return search(arr, l, mid - 1, key);
        }
    }

    private int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == arr[mid])
                return mid;

            if (arr[left] <= arr[mid]) { // left array is sorted
                if (target >= arr[left] && target < arr[mid]) { // target lies between start and mid index
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // right array is sorted
                if (target > arr[mid] && target <= arr[right]) { // target lies between mid and end index
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
