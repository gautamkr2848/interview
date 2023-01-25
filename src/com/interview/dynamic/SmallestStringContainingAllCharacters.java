package com.interview.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Approach: Basically a window of characters is maintained by using two pointers namely start and end.
        These start and end pointers can be used to shrink and increase the size of window respectively.
        Whenever the window contains all characters of given string, the window is shrinked from left side to
        remove extra characters and then its length is compared with the smallest window found so far.
        If in the present window, no more characters can be deleted then we start increasing the size of the
        window using the end until all the distinct characters present in the string are also there in the window.
        Finally, find the minimum size of each window.*/

/*1. Maintain an array (visited) of maximum possible characters (256 characters) and as soon as we find any
     in the string, mark that index in the array (this is to count all distinct characters in the string).
  2. Take two pointers start and end which will mark the start and end of window.
  3. Take a counter=0 which will be used to count distinct characters in the window.
  4. Now start reading the characters of the given string and if we come across a character which has not been
     visited yet increment the counter by 1.
  5. If the counter is equal to total number of distinct characters, Try to shrink the window.
  6. For shrinking the window -:
     a. If the frequency of character at start pointer is greater than 1 increment the pointer as it is redundant.
     b.Now compare the length of present window with the minimum window length.*/

public class SmallestStringContainingAllCharacters {

    public String findSubString(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);

        int dist_count = map.size();
        int size = Integer.MAX_VALUE;
        String res = "";

        for (int i = 0; i < n; i++) {
            int count = 0;
            int visited[] = new int[256];

            String tmp = "";
            for (int j = i; j < n; j++) {
                if (visited[s.charAt(j)] == 0) {
                    count++;
                    visited[s.charAt(j)] = 1;
                }
                tmp = tmp + s.charAt(j);
                if (count == dist_count)
                    break;
            }
            if (tmp.length() < size && count == dist_count) {
                res = tmp;
                size=res.length();
            }
        }
        return res;
    }
}
