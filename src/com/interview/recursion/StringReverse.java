package com.interview.recursion;

public class StringReverse {

    public void stringReverse(String str){
        if (str==null||(str.length() == 1))
            System.out.println(str);
        else {
            System.out.print(str.charAt(str.length()-1));
            stringReverse(str.substring(0,str.length()-1));
        }
    }

    private static String reverseString(String s){
        if(s == null || s.length() == 0)
            return s;
        else {
            return String.valueOf(s.charAt(s.length() - 1)).concat(reverseString(s.substring(0, s.length() - 1)));
        }
    }

    public String reverseString_3(String str) {
        if(str.isEmpty())
            return str;
        else
            return reverseString_3(str.substring(1))+str.charAt(0);
    }
}
