package com.interview.dynamic.LCS;

public class h_LongestRepeatingSubstring {

    public void longestRepeatingSubstring(){
        String str = "ABCABCA";
        int n = str.length();
        int T[][] = new int[n + 1][n + 1];

        String res = "";
        int length = 0, end = n;

        for (int i = 0; i <= n; i++)
            T[0][i] = 0;
        for (int i = 0; i <= n; i++)
            T[i][0] = 0;

        int i, index = 0;
        for (i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && T[i - 1][j - 1] < (j - i)) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                    if(T[i][j] > length){
                        length = T[i][j];
                        end = i;
                    }
                } else {
                    T[i][j] = 0;
                }
            }
        }
        System.out.println(str.substring(end-length, end));
    }
}
