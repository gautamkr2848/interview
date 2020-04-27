package com.interview.dynamic;

public class CountDistinctSubSequence {

    public void countDistinctSubSequence(String s1, String s2){
        int a = s1.length();
        int b = s2.length();

        if (a > b)
            System.out.println(0);

        int[][] T = new int[a+1][b+1];

        for (int i = 1; i <= a; i++)
            T[i][0] = 0;

        for (int j = 0; j <= b; j++)
            T[0][j] = 1;

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (s1.charAt(i - 1) != s2.charAt(j - 1))
                    T[i][j] = T[i][j - 1];
                else
                    T[i][j] = T[i][j - 1] + T[i - 1][j - 1];
            }
        }

        System.out.println(T[a][b]);
    }

}
