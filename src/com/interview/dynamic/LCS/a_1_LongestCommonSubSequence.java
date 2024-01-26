package com.interview.dynamic.LCS;

/*          a   b   c   d   a   f
        0   0   0   0   0   0   0
   a    0   1   1   1   1   1   1
   c    0   1   1   2   2   2   2
   b    0   1   2   2   2   2   2
   c    0   1   2   3   3   3   3
   f    0   1   2   3   3   3   4

   length of longest common sub sequence = 4
 */

/*
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
*/

import java.util.Arrays;
import java.util.Stack;

public class a_1_LongestCommonSubSequence {

    public int lcs_recurssion(String a, String b, int m, int n){
        if(m == 0 || n == 0)
            return 0;
        if(a.charAt(m-1) == b.charAt(n-1))
            return 1 + lcs_recurssion(a, b, m-1, n-1);
        else
            return Math.max(lcs_recurssion(a, b, m-1, n), lcs_recurssion(a, b, m, n-1));
    }

    static int[][] t = new int[10][10];
    public a_1_LongestCommonSubSequence(){
        for(int[] arr : t)
            Arrays.fill(arr, -1);
    }

    public int lcs_memorization(String a, String b, int m, int n){
        if(m == 0 || n == 0)
            return 0;
        if(t[m][n] != -1)
            return t[m][n];
        if(a.charAt(m-1) == b.charAt(n-1))
            t[m][n] = 1 + lcs_recurssion(a, b, m-1, n-1);
        else
            t[m][n] = Math.max(lcs_recurssion(a, b, m-1, n), lcs_recurssion(a, b, m, n-1));
        return t[m][n];
    }

    public int lcs(String a, String b, int m, int n){
        int t[][] = new int[m+1][n+1];

        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                if(a.charAt(i-1) == b.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }

        return t[m][n];
    }

    public void printLCS(String a, String b, int m, int n){
        int[][] t = new int[m+1][n+1];    //for printing LCS we have to use this t[][] matrix outside LCS one
        lcs(a, b, m, n);
        Stack<Character> stk = new Stack<>();

        while (m>0 && n>0){
            if(a.charAt(m-1) == b.charAt(n-1)){
                stk.push(a.charAt(m-1));
                m--;
                n--;
            } else {
                if(t[m-1][n] >= t[m][n-1])
                    m--;
                else
                    n--;
            }
        }

        while (!stk.empty())
            System.out.print(stk.pop() + " ");
    }
}

