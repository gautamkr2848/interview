package com.interview.recursion;

public class StringReverse {

    public String reverseString_3(String str) {
        if(str.isEmpty())
            return str;
        else
            return reverseString_3(str.substring(1)) + str.charAt(0);
    }

    public void reverse(char[] str, int start, int end) {
        if (start == end)
            return;

        char temp = str[start];
        reverse(str, start + 1, end);
        System.out.print(temp);
    }
}
