package com.interview.array.twoPointer;

/*
Input: arr[] = {2, 0, 2}
Output: 2

Input: arr[]   = {3, 0, 2, 0, 4}
Output: 7

Input: arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
Output: 6
*/

public class WaterTapping {

    // Traverse every array element and find the highest bars on the left and right sides. Take the smaller of two
    // heights. The difference between the smaller height and the height of the current element is the amount of water
    // that can be stored in this array element.

    //Complexity Analysis:

    //Time Complexity: O(N2). There are two nested loops traversing the array.
    //Space Complexity: O(1). No extra space is required.

    public static int maxWater(int[] arr, int n) {

        int res = 0;
        for (int i = 1; i < n - 1; i++) {

            int left = arr[i];
            int right = arr[i];

            for (int j = 0; j < i; j++) {   // Find maximum element on its left
                left = Math.max(left, arr[j]);
            }

            for (int j = i + 1; j < n; j++) {   // Find maximum element on its right
                right = Math.max(right, arr[j]);
            }

            res = res + Math.min(left, right) - arr[i];
        }
        return res;
    }

    //For every element we needed to calculate the highest element on the left and on the right.

    //So, to reduce the time complexity:

    //For every element we can precalculate and store the highest bar on the left and on the right (say stored in arrays left[] and right[]).
    //Then iterate the array and use the precalculated values to find the amount of water stored in this index,
    //which is the same as ( min(left[i], right[i]) – arr[i] )

    //Time Complexity: O(N). Only one traversal of the array is needed, So time Complexity is O(N).
    //Space Complexity: O(N). Two extra arrays are needed, each of size N.

    public void rainWater(int[] a) {
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = a[0];
        for(int i=1; i<n; i++)
            left[i] = Math.max(left[i-1], a[i]);

        right[n-1] = a[n-1];
        for(int i=n-2; i>=0; i--)
            right[i] = Math.max(right[i+1], a[i]);

        int ans = 0;
        for(int i=0; i<n; i++)
            ans = ans + Math.min(left[i], right[i]) - a[i];

        System.out.print(ans);
    }

    //At every index, The amount of rainwater stored is the difference between the current index height and a minimum of left
    //max height and right max-height.

    //Here we can use the two-pointer approach to find the minimum among the left-max and right-max of the probable outermost
    //boundary for any index and iterate likewise.

    //For example:

    //Say we have indices i, j and a boundary of (left, right). where i is the left pointer and j is the right pointer.

    //If the minimum is arr[left], we can say that i is bounded in one side by left and no matter whatever the values are in
    //between (i, right), the rightmost boundary of i will at  least have height arr[right] which is the probable outermost
    //boundary for i.

    //So the water height of water column at index i is arr[left] – arr[i] and we can increment i then.
    //Similar things happen for j also.

    public static int trap() {
        int[] heights = {3, 0, 2, 0, 1};

        int i = 0, j = heights.length - 1, water = 0;

        int left = heights[i];
        int right = heights[j];

        while (i < j) {
            if (heights[i] <= heights[j]) {
                i++;
                left = Integer.max(left, heights[i]);
                water = water + left - heights[i];
            } else {
                j--;
                right = Integer.max(right, heights[j]);
                water = water + right - heights[j];
            }
        }
        return water;
    }

    public static void main(String[] args) {
        System.out.print(trap());
    }

}
