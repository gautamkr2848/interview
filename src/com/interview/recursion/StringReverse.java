package com.interview.recursion;

public class StringReverse {

    public String reverseString(String str) {
        if(str.isEmpty())
            return str;
        else
            return reverseString(str.substring(1)) + str.charAt(0);
    }
}
