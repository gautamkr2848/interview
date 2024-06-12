package com.interview.string;

public class ValidSubsequence {

    public boolean validSubsequence(String s1, String s2) {
        int i=0, j=0;

        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                j++;
            }
            i++;
        }

        return j == s2.length();
    }
}
