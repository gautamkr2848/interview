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

    public String reverseString(String str) {
        if(str.isEmpty())
            return str;
        else
            return reverseString(str.substring(1))+str.charAt(0);
    }
}
