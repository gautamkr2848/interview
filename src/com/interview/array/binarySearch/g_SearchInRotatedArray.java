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

        if (arr[l] <= arr[mid]) {
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
            else
                return search(arr, mid + 1, h, key);
        } else {
            if (key >= arr[mid] && key <= arr[h])
                return search(arr, mid + 1, h, key);
            else
                return search(arr, l, mid - 1, key);
        }
    }

}
