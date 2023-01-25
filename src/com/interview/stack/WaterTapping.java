package com.interview.stack;

import java.util.Stack;

/*
Input: arr[] = {2, 0, 2}
Output: 2

Input: arr[]   = {3, 0, 2, 0, 4}
Output: 7

Input: arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
Output: 6

At every index, The amount of rainwater stored is the difference between the current index height and a minimum of left
max height and right max-height.

Here we can use the two-pointer approach to find the minimum among the left-max and right-max of the probable outermost
boundary for any index and iterate likewise.

For example:

Say we have indices i, j and a boundary of (left, right). where i is the left pointer and j is the right pointer.

If the minimum is arr[left], we can say that i is bounded in one side by left and no matter whatever the values are in
between (i, right), the rightmost boundary of i will at  least have height arr[right] which is the probable outermost
boundary for i.

So the water height of water column at index i is arr[left] – arr[i] and we can increment i then.
Similar things happen for j also.
*/

public class WaterTapping {

    //preferred
    public int trap(int[] heights) {

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

    public int water(int[] height) {

        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < height.length; i++) {

            while ((!stack.isEmpty()) && (height[stack.peek()] < height[i])) {

                int pop_height = height[stack.pop()];

                if (stack.isEmpty())
                    break;

                int distance = i - stack.peek() - 1;
                int min_height = Math.min(height[stack.peek()], height[i]) - pop_height;
                ans = ans + distance * min_height;
            }
            stack.push(i);
        }
        return ans;
    }
}
