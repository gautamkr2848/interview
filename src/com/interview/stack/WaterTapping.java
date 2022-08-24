package com.interview.stack;

import java.util.Stack;

public class WaterTapping {

    public int maxArea() {
        int arr[] = new int[] {1,8,6,2,5,4,8,3,7};
        int water = 0, start = 0, end = arr.length - 1;

        while (start < end) {
            water = Math.max(water, Math.min(arr[start], arr[end]) * (end - start));

            if (arr[start] < arr[end])
                start++;
            else
                end--;
        }
        return water;
    }

    public int water(int[] height) {

        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < height.length; i++) {

            while ((!stack.isEmpty()) &&
                    (height[stack.peek()] < height[i])) {

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
