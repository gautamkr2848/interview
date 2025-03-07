package com.interview.dynamic.LCS;

/*
a : geek    b : eke
merge1 : geekeke
merge2 : geeke => output contains both string with min. length
o/p - length of a + length of b - length of LCS of a & b
*/

import java.util.Stack;

public class c2_ShortestCommonSupersequencePrint {

    public void g_PrintShortestCommonSupersequence(String a, String b, int m, int n){
        int[][] t = new int[m+1][n+1];    //for printing LCS we have to use this t[][] matrix not inside LCS one
        //lcs(a, b, m, n);
        Stack<Character> stk = new Stack<>();
        int i = m, j = n;

        while (i>0 && j>0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                stk.push(a.charAt(i-1));
                i--;
                j--;
            } else {
                if(t[i-1][j] >= t[i][j-1]) {
                    stk.push(b.charAt(i-1));
                    i--;
                } else {
                    stk.push(a.charAt(j-1));
                    j--;
                }
            }
        }

        while(i > 0){
            stk.push(a.charAt(i-1));
            i--;
        }
        while (j > 0){
            stk.push(b.charAt(j-1));
            j--;
        }

        while (!stk.empty()){
            char data = stk.pop();
            System.out.print(data + " ");
        }
    }
}
