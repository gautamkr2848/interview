package com.interview.string;

/*
    1. Take two-pointer where the first pointer track from the left side of a string
        and second pointer keep track from the right side of a string.
    2. Till the time we find the same character, keep moving the right pointer to one step left.
    3. If the same character not found then return -1.
    4. If the same character found then swap the right pointer’s character towards the
        right until it is not placed at its correct position in a string.
    5. Increase left pointer and repeat step 2.
*/

import java.util.HashMap;
import java.util.Map;

// ababd

// dbaba

public class MinSwapStringPelindorme {

    public int minSwap(String s) {

        if(!isValid(s))
            return -1;

        int n = s.length();
        char[] arr = s.toCharArray();
        int count = 0;

        for (int i = 0; i < n / 2; i++) {
            int left = i;
            int right = n - left - 1;

            while (left < right) {
                if (arr[left] == arr[right]) {
                    break;
                } else {
                    right--;
                }
            }

            if (left == right) {        // arr[left] is the character in the middle of the palindrome
                swap(arr, left);
                count++;
                i--;
            } else {
                for (int j = right; j < n - left - 1; j++) {
                    swap(arr, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void swap(char[] arr, int i) {
        char tmp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = tmp;
    }

    private boolean isValid(String s) {
        int odd = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) +1);

        for (Map.Entry i : map.entrySet()) {
            int val = (int)i.getValue();
            if(val % 2 == 1)
                odd++;
        }

        if (odd > 1)
            return false;
        return true;
    }


    public int minSwap_2(String s) {

        int left = 0;
        int right = s.length() - 1;
        int result = 0;

        if(!isValid(s))
            return -1;

        while (left < right) {
            int l = left, r = right;
            while (s.charAt(l) != s.charAt(r))
                r--;

            if (l == r) {   // when we found odd element
                char ch1 = s.charAt(r), ch2 = s.charAt(r+1);
                s = s.substring(0, r) + ch2 + ch1 + s.substring(r + 2);
                result++;
                continue;
            } else {    // Normal element
                while (r < right) {
                    char ch1 = s.charAt(r), ch2 = s.charAt(r+1);
                    s = s.substring(0, r) + ch2 + ch1 + s.substring(r + 2);
                    result++;
                    r++;
                }
            }
            left++;
            right--;
        }
        return result;
    }
}
