package com.interview.dynamic.LCS;

import java.util.Stack;

public class c_ShortestCommonSupersequencePrint {

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
                if(t[i][j-1] > t[i-1][j]) {
                    stk.push(b.charAt(j-1));
                    j--;
                } else {
                    stk.push(a.charAt(i-1));
                    i--;
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
