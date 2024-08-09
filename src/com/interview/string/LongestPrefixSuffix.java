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
        int i=1, n = s.length();
        String res = "";

        while (i <= n/2) {
            if(s.substring(0,i).equalsIgnoreCase(s.substring(n-i, n))){
                res = s.substring(0,i);
            } else {
                continue;
            }
            i++;
        }
        System.out.println(res);
    }
}
