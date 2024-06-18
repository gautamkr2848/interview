package com.interview.dynamic.MCM;

import java.util.Arrays;
import java.util.Stack;

//Break a string in such size, so that all substrings wil be a pelindrome
//nitin     => n    i   t   i   n   here all 5 strings are pelindrome
//nitin     => n    iti     n       here all 3 strings are pelindrome
//  o/p - 3

public class b_PalindromePartitioning {

    //i = 0, j = n-1
    // base condition-  size 0 and 1 string are already palindrome - No partitioning
    //         whole string a palindrome then dont partition it.
    public static int b_PalindromePartitioning(String s, int i, int j){
        if(i >= j || isPalindrome(s, i, j))
            return 0;

        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++)
            min = Math.min(min, b_PalindromePartitioning(s, i, k) + b_PalindromePartitioning(s, k+1, j) + 1);

        return min;
    }

    private static Boolean isPalindrome(String s, int i, int j){

        while (i < j){
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

    // Driver code
    public static void main(String[] args) {
        String str = "anaitin";
        System.out.println("Min cuts needed for Palindrome Partitioning is " + b_PalindromePartitioning(str, 0, str.length() - 1));
    }
}