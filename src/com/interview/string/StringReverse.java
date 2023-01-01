package com.interview.string;

public class StringReverse {

    public void stringReverse(){
        String s = "abcdefg";
        StringBuilder s2 = new StringBuilder(s);
        int n = s.length();
        int i=0;
        while(i<n){
            char temp = s2.charAt(i);
            s2.setCharAt(i, s2.charAt(n-1));
            s2.setCharAt(n-1, temp);
            i++;
            n--;
        }
        System.out.println(s2);
    }

    //2nd approach
    public String reverseString(String str) {
        if(str.isEmpty())
            return str;
        else
            return reverseString(str.substring(1)) + str.charAt(0);
    }
}
