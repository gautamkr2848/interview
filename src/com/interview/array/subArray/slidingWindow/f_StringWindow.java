package com.interview.array.subArray.slidingWindow;

//Smallest window in a String containing all characters of other String

//Follow the steps below to solve the problem:
//
//        Make a hash array of size 256.
//        First store the frequency of every character of pattern string.
//        Then loop over the string and decrement the frequency from the hash array.
//        When count variable equals to zero then start minimizing the window.

import java.util.HashMap;
import java.util.Map;

public class f_StringWindow {

    public String Minimum_Window(char []s, char []t) {
        int m[] = new int[256];
        int ans = Integer.MAX_VALUE;
        int start = 0, count = 0;

        for (int i = 0; i < t.length; i++) {
            if (m[t[i]] == 0)
                count++;
            m[t[i]]++;
        }

        int i = 0, j = 0;

        while (j < s.length) {
            m[s[j]]--;
            if (m[s[j]] == 0)
                count--;

            if (count == 0) {
                while (count == 0) {
                    if (ans > j - i + 1) {
                        ans = Math.min(ans, j - i + 1);
                        start = i;
                    }

                    m[s[i]]++;
                    if (m[s[i]] > 0)
                        count++;

                    i++;
                }
            }
            j++;
        }

        if (ans != Integer.MAX_VALUE)
            return String.valueOf(s).substring(start, ans+start);
        else
            return "-1";
    }

/*
First check if the length of the string is less than the length of the given pattern, if yes then print "-1"
Store the occurrence of characters of the given pattern in a hash array (say, hash_pat[]).
We will be using two pointer technique basically
Start matching the characters of the pattern with the characters of the string i.e. increment count if a character matches.
Check if (count == length of pattern ) this means a window is found.
If such a window is found, try to minimize it by removing extra characters from the beginning of the current window.
Delete one character from the first and again find this deleted key at right.
If found, then again check if count and pattern length are same and repeat the process.
Update min_length.
Print the minimum length window.
*/

    public void minWindowSubString() {

        String str = "timetopractice";
        String pat = "toc";
        int len1 = str.length();
        int len2 = pat.length();
        int no_of_chars = 256;

        if (len1 < len2)
            System.out.println("-1");

        int hash_pat[] = new int[no_of_chars];
        int hash_str[] = new int[no_of_chars];

        for (int i = 0; i < len2; i++)
            hash_pat[pat.charAt(i)]++;

        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < len1; i++) {

            hash_str[str.charAt(i)]++;

            if (hash_str[str.charAt(i)] <= hash_pat[str.charAt(i)])
                count++;

            if (count == len2) {
                while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)] == 0) {
                    if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
                        hash_str[str.charAt(start)]--;
                    start++;
                }

                int len_window = i - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        if (start_index == -1)
            System.out.println("-1");

        System.out.println(str.substring(start_index, start_index + min_len));

    }

    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0)
            return "";

        Map<Character, Integer> mapT = new HashMap();
        for(char c: t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c,0)+1);
        }
        int requiredMatch = mapT.size();

        int left = 0, minLeft = 0, minLength = Integer.MAX_VALUE, matchedSoFar = 0;
        Map<Character, Integer> mapS = new HashMap();
        for(int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);

            if(mapT.containsKey(rc)) {
                mapS.put(rc, mapS.getOrDefault(rc,0)+1);
                if(mapS.get(rc).intValue() == mapT.get(rc).intValue()) {
                    matchedSoFar++;
                }
                while(matchedSoFar == requiredMatch) {
                    if(right-left +1 < minLength) {
                        minLeft = left;
                        minLength = right-left +1;
                    }
                    char lc = s.charAt(left);
                    if(mapT.containsKey(lc)) {
                        mapS.put(lc, mapS.getOrDefault(lc,0)-1);
                        if(mapS.get(lc).intValue() < mapT.get(lc).intValue()) {
                            matchedSoFar--;
                        }
                    }
                    left++;
                }
            }
        }
        if(minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minLeft, minLeft+minLength);
    }
}