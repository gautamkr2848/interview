package com.interview.recursion;

public class StringReverse {

    public String reverseString_3(String str) {
        if(str.isEmpty())
            return str;
        else
            return reverseString_3(str.substring(1))+str.charAt(0);
    }
}
