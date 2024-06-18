package com.interview.trie;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix() {
        String[] a = {"flower", "flow", "flight"};
        int size = a.length;

        if (size == 0)
            return "";

        if (size == 1)
            return a[0];

        Arrays.sort(a);
        int end = Math.min(a[0].length(), a[size-1].length());      /* find the minimum length from first and last string */
        int i = 0;
        while (i < end && a[0].charAt(i) == a[size-1].charAt(i) )       /* find the common prefix between the first and last string */
            i++;

        return a[0].substring(0, i);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix());
    }
}
