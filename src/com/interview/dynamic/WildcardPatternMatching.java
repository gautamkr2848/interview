package com.interview.dynamic;

import java.util.Arrays;

public class WildcardPatternMatching {

    public void wildcardPatternMatching(){
        String str = "baaabab";
        String pattern = "*****ba*****ab";

        int m = str.length();
        int n = pattern.length();

        if (n == 0)     // empty pattern can only match with empty string
            System.out.println(m == 0);

        boolean[][] temp = new boolean[m + 1][n + 1];
        temp[0][0] = true;      // empty pattern can match with empty string

        for (int j = 1; j <= n; j++)        // Only '*' can match with empty string
            if (pattern.charAt(j - 1) == '*')
                temp[0][j] = temp[0][j - 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pattern.charAt(j - 1) == '*')
                    temp[i][j] = temp[i][j - 1] || temp[i - 1][j];
                else if (pattern.charAt(j - 1) == '?' || str.charAt(i - 1) == pattern.charAt(j - 1))
                    temp[i][j] = temp[i - 1][j - 1];
                else
                    temp[i][j] = false;
            }
        }
        System.out.println(temp[m][n]);
    }
}
