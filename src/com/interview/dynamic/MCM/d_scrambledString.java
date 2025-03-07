package com.interview.dynamic.MCM;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given two strings of equal length (say n+1), S1[0…n] and S2[0…n].
If S2 is a scrambled form of S1, then there must exist an index i such that
at least one of the following conditions is true:
    1. S2[0…i] is a scrambled string of S1[0…i] and S2[i+1…n] is a scrambled
        string of S1[i+1…n].
    2. S2[0…i] is a scrambled string of S1[n-i…n] and S2[i…n] is a scrambled
        string of S1[0…n-i].

Input: S1=”coder”, S2=”ocder”
Output: Yes
Explanation:
“ocder” is a scrambled form of “coder”

Input: S1=”abcde”, S2=”caebd”
Output: No
Explanation:
“caebd” is not a scrambled form of “abcde”
*/

////  0   i       n-i     n

public class d_scrambledString {

    public static boolean isScramble(String S1, String S2) {

        if (S1.length() != S2.length())
            return false;

        int n = S1.length();
        if (n == 0 || S1.equals(S2))
            return true;

        char[] tempArray1 = S1.toCharArray();
        char[] tempArray2 = S2.toCharArray();

        Arrays.sort(tempArray1);
        Arrays.sort(tempArray2);

        String copy_S1 = new String(tempArray1);
        String copy_S2 = new String(tempArray2);

        if (!copy_S1.equals(copy_S2))
            return false;

        for (int i = 1; i < n; i++) {
            if (isScramble(S1.substring(0, i), S2.substring(0, i)) &&
                    isScramble(S1.substring(i, n), S2.substring(i, n)))
                return true;

            if (isScramble(S1.substring(n - i, n), S2.substring(0, i)) &&
                    isScramble(S1.substring(0, n - i), S2.substring(i, n)))
                return true;
        }
        return false;
    }

    //Time complexity - O(2^n)

    public static void main(String[] args) {
        System.out.println(isScramble("coder", "ocder"));
        System.out.print(isScramble("abcde", "caebd"));
    }




    Map<String, Boolean> mp = new HashMap<String, Boolean>();

    private boolean isScramble_2(String S1, String S2) {

        if (S1.length() != S2.length())
            return false;

        int n = S1.length();
        if (n == 0 || S1.equals(S2))
            return true;

        char[] tempArray1 = S1.toCharArray();
        char[] tempArray2 = S2.toCharArray();

        Arrays.sort(tempArray1);
        Arrays.sort(tempArray2);

        String copy_S1 = new String(tempArray1);
        String copy_S2 = new String(tempArray2);

        if (!copy_S1.equals(copy_S2))
            return false;

        // make key of type string for search in map
        String key = (S1 + " " + S2);
        // checking if both string are before calculated or not
        // if calculated means find in map then return it's
        // value
        if (mp.containsKey(key))
            return mp.get(key);

        boolean flag = false;   // declaring flag variable to store result

        for (int i = 1; i < n; i++) {

            if (isScramble_2(S1.substring(0, i), S2.substring(0, i))
                    && isScramble_2(S1.substring(i, n), S2.substring(i, n))) {
                flag = true;
                mp.put(key, flag);
                return true;
            }

            if (isScramble_2(S1.substring(0, i), S2.substring(n - i, n))
                    && isScramble_2(S1.substring(i, n), S2.substring(0, n - i))) {
                flag = true;
                mp.put(key, flag);
                return true;
            }
        }

        mp.put(key, flag);

        return false;
    }

    //Time Complexity: O(N^2)
}


