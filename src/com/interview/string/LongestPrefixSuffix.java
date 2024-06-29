package com.interview.string;

// Input : S = aabcdaabc
//Output : 4
//Explanation: The string “aabc” is the longest prefix which is also suffix.
//
//Input : S = abcab
//Output : 2

public class LongestPrefixSuffix {

    public static void main(String[] args) {
        String s = "aabcdaabc";
        int length = 0, i=1, n = s.length();
        String res = "";

        while (i <= n/2) {
            if(s.substring(0,i).equalsIgnoreCase(s.substring(n-i, n))){
                length++;
                res = s.substring(0,i);
                i++;
            } else {
                i++;
                continue;
            }
        }
        System.out.println(res);
    }
}
