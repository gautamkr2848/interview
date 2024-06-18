package com.interview.dynamic.LCS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardPatternMatching {

    public static boolean wildPattren(String s, String p, int m, int n) {

        if(m<0 && n<0)
            return true;

        if(m>=0 && n<0)
            return false;

        if(m<0 && n>=0) {
            for(int i=0; i<n; i++) {
                if(p.charAt(i) != '*') return false;
            }
            return true;
        }

        if(s.charAt(m) == p.charAt(n) || p.charAt(n) == '?')
            return wildPattren(s, p, m-1, n-1);
        else if(p.charAt(n) == '*')
            return wildPattren(s, p, m, n-1) || wildPattren(s, p, m-1, n-1);
        else
            return false;
    }

    public static boolean wildcardPatternMatching(String str, String pattern, int m, int n){

        if (m == 0 && n == 0)
            return true;

        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], false);

        dp[0][0] = true;

        for (int j = 1; j <= n; j++)
            if (pattern.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pattern.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                else if (pattern.charAt(j - 1) == '?' || str.charAt(i - 1) == pattern.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = false;
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String str = "baaabab";
        String pattern = "ba*a?";

        int m = str.length();
        int n = pattern.length();

        System.out.println(wildcardPatternMatching(str, pattern, m, n));
        System.out.println(wildPattren(str, pattern, m-1, n-1));

    }
}
