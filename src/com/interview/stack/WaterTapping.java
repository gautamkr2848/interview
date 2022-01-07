package com.interview.stack;

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
}
