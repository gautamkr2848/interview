package com.interview.dynamic.LCS;

// Given two strings s and t, return the number of distinct subsequences of s which equals t.

//Input: s = "rabbbit", t = "rabbit"
//Output: 3

//Input: s = "babgbag", t = "bag"
//Output: 5

public class j_CountDistinctSubSequence {

    public static void countDistinctSubSequence(String s1, String s2){
        int a = s1.length();
        int b = s2.length();

        int[][] T = new int[a+1][b+1];

        for (int i = 0; i <= b; i++)
            T[0][i] = 0;

        for (int j = 0; j <= a; j++)
            T[j][0] = 1;

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    T[i][j] = T[i-1][j] + T[i - 1][j - 1];
                else
                    T[i][j] = T[i-1][j];
            }
        }

        System.out.println(T[a][b]);
    }

    public static void main(String[] args) {
        countDistinctSubSequence("rabbbit", "rabbit");
    }

}
