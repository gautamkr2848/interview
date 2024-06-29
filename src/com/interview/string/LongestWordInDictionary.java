package com.interview.string;

import java.util.Collections;
import java.util.List;

/*
Giving a dictionary and a string ‘str’, find the longest string in dictionary which can be formed by deleting some
characters of the given ‘str’.

Examples:

Input : dict = {"ale", "apple", "monkey", "plea"}
        str = "abpcplea"
Output : apple

Input  : dict = {"pintu", "geeksfor", "geeksgeeks",
                                        " forgeek"}
         str = "geeksforgeeks"
Output : geeksgeeks
*/

public class LongestWordInDictionary {

    public void longestWord(List<String> d, String S) {
        Collections.sort(d);
        String res = "";
        for(String c : d) {
            String tmp = check(c, S);
            res = tmp.length() > res.length() ? tmp : res;
        }

        System.out.println(res);
    }

    private String check(String d, String s) {

        int i = 0;
        int j = 0;
        while(i < d.length() && j < s.length()) {

            if(d.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else
                j++;

            if(i == d.length())
                return d;
        }
        return "";
    }
}
