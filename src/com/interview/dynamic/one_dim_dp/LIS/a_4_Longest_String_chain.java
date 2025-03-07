package com.interview.dynamic.one_dim_dp.LIS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class a_4_Longest_String_chain {

    // Custom comparison function for sorting strings by length
    static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();

    // Function to compare two strings and check if they form a valid chain
    static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return first == s1.length() && second == s2.length();
    }

    // Function to find the length of the longest string chain
    static int longestStrChain(List<String> arr) {
        int n = arr.size();

        // Sort the array by string length
        arr.sort(comp);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (compare(arr.get(i), arr.get(j)) && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }

            if (dp[i] > maxi) {
                maxi = dp[i];
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("a", "b", "ba", "bca", "bda", "bdca");

        System.out.println("The length of the longest string chain is: " + longestStrChain(words));
    }
}
