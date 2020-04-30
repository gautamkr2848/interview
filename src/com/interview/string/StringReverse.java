package com.interview.string;

public class StringReverse {

    public void stringReverse(){
        String s = "abcdefg";
        StringBuilder s2 = new StringBuilder("abcdefg");
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
}
