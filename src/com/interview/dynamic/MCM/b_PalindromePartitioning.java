package com.interview.dynamic.MCM;

import java.util.Arrays;
import java.util.Stack;

public class b_PalindromePartitioning {

    public int b_PalindromePartitioning(String s, int i, int j){
        if(i >= j)
            return 0;
        if(isPalindrome(s, i, j))
            return 0;

        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int temp = b_PalindromePartitioning(s, i, k) +
                        b_PalindromePartitioning(s, k+1, j) + 1;
            if(temp < min)
                min = temp;
        }
        return min;
    }

    private Boolean isPalindrome(String s, int i, int j){
        if(i >= j)
            return true;

        while (i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static int[][] t = new int[1001][1001];
    public b_PalindromePartitioning(){
        for (int i=0; i<t.length; i++)
            Arrays.fill(t[i], -1);
    }

    public int b_PalindromePartitioning_momorization(String s, int i, int j){
        if(i >= j)
            return 0;
        if(isPalindrome(s, i, j))
            return 0;

        if(t[i][j] != -1)
            return t[i][j];

        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int temp = b_PalindromePartitioning_momorization(s, i, k) +
                    b_PalindromePartitioning_momorization(s, k+1, j) + 1;
            if(temp < min)
                min = temp;
        }
        t[i][j] = min;
        return min;
    }

    public int b_PalindromePartitioning_momorization_opmized(String s, int i, int j){
        if(i >= j)
            return 0;
        if(isPalindrome(s, i, j))
            return 0;

        if(t[i][j] != -1)
            return t[i][j];

        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int left, right;

            if(t[i][k] != -1)
                left = t[i][k];
            else
                left = b_PalindromePartitioning_momorization_opmized(s, i, k);

            if(t[k+1][j] != -1)
                right = t[k+1][j];
            else
                right = b_PalindromePartitioning_momorization_opmized(s, k+1, j);

            int temp = left + right + 1;
            if(temp < min)
                min = temp;
        }
        t[i][j] = min;
        return min;
    }
}
