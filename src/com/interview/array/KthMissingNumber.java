package com.interview.array;

// 2 3 4 7 11
// k = 5

// index =       0 1 2 3 4
// desired =     1 2 3 4 5

// differences = 1 2 1 3 6

// o/p - 9

public class KthMissingNumber {

    static int findKthMissing(int[] arr, int k) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] - mid - 1 < k) {       // If the number of missing elements is less than k
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left + k;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(findKthMissing(a, k));
    }
}
