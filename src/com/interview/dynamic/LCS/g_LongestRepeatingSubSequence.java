package com.interview.dynamic.LCS;

    /*same as Longest Common Subsequence
    if(a.charAt(i-1) == b.charAt(j-1) && i != j)
    Extra field - i != j */

public class g_LongestRepeatingSubSequence {

    public void h_LongestRepeatingSubSequence(String a, String b){
        int m = a.length(), n = b.length();
        int t[][] = new int[m+1][n+1];

        for (int i = 0; i <= n; i++)
            t[0][i] = 0;
        for (int i = 0; i <= m; i++)
            t[i][0] = 0;

        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                if(a.charAt(i-1) == b.charAt(j-1) && i != j)
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }
        System.out.println(t[m][n]);
    }
}
