package com.interview.greedy;

import java.util.Arrays;

public class BoatsToSave {

    public void minBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int boats = 0, left = 0, right = arr.length - 1;

        while (left <= right) {
            if (arr[left] + arr[right] <= limit) {      // If heaviest and lightest person can fit in same boat
                left++;
            }

            right--;        // In any case, the heaviest person will be on the boat

            boats++;
        }

        System.out.println(boats);
    }
}
