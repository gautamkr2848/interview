package com.interview.stack;

import java.util.Stack;

/*
Input: arr[] = {2, 0, 2}
Output: 2

Input: arr[]   = {3, 0, 2, 0, 4}
Output: 7

Input: arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
Output: 6
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
                water = water + (left - heights[i]);
            } else {
                j--;
                right = Integer.max(right, heights[j]);
                water = water + (right - heights[j]);
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
