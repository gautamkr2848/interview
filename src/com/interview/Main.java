package com.interview;

import com.interview.dynamic.LongestCommonSubstring;

import java.lang.*;

public class Main {

    public static void main(String[] args) {
        String str1 = "GeeksforGeeks";
        String str2 = "Geeks";
        LongestCommonSubstring l = new LongestCommonSubstring();
        l.lcs(str1, str2);
    }
}
