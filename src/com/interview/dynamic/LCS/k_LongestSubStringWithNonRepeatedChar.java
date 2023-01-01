package com.interview.dynamic.LCS;

//For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.
//For “BBBB” the longest substring is “B”, with length 1.

public class k_LongestSubStringWithNonRepeatedChar {

    public int k_LongestSubStringWithNonRepeatedChar(){
        String str = "geeksforgeeks";
        String test = "";
        int maxLength = -1;

        if (str.isEmpty())
            return 0;
        else if (str.length() == 1)
            return 1;

        for (char c : str.toCharArray()) {
            String current = String.valueOf(c);

            if (test.contains(current))
                test = test.substring(test.indexOf(current) + 1);

            test = test + current;
            maxLength = Math.max(test.length(), maxLength);
        }

        return maxLength;
    }
}
