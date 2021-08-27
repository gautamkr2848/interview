package com.interview.array.sort;

/*
In QuickSort, we pick a pivot element, then move the pivot element to its correct
position and partition the surrounding array. The idea is, not to do complete quicksort,
but stop at the point where pivot itself is k’th smallest element. Also, not to recur
for both left and right sides of pivot, but recur for one of them according to the
position of pivot. The worst case time complexity of this method is O(n2), but it
works in O(n) on average.
*/

public class kthSmallestElement_QuickSort {

    public void kthSmallestElement_QuickSort(){
        int[] arr= { 12, 3, 5, 7, 4, 19, 26 };
        int k = 3;      //int k = arr.length-val+1;  for greater element
        System.out.print(kthSmallest(arr, 0, arr.length - 1, k));
    }

    private int kthSmallest(int[] arr, int l, int r, int k) {
        if (k > 0 && k <= r - l + 1) {      // If k is smaller than number of elements in array
            QuickSort q = new QuickSort();
            int pos = q.partition(arr, l, r);

            // If position is same as k
            if (pos - l == k - 1)
                return arr[pos];

            // If position is more, recur for left subarray
            if (pos - l > k - 1)
                return kthSmallest(arr, l, pos - 1, k);
            else
                return kthSmallest(arr, pos + 1, r, k - 1 - pos + l);
        }

        // If k is more than number of elements in array
        return Integer.MAX_VALUE;
    }
}
