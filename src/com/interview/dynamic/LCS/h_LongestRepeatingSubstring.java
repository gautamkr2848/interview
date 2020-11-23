package com.interview.dynamic.LCS;

public class h_LongestRepeatingSubstring {

    public void longestRepeatingSubstring(){
        String str = "ABCABCA";
        int n = str.length();
        int T[][] = new int[n + 1][n + 1];

        String res = "";
        int res_length = 0;

        int i, index = 0;
        for (i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && T[i - 1][j - 1] < (j - i)) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                } else {
                    T[i][j] = 0;
                }

                if (T[i][j] > res_length) {
                    res_length = T[i][j];
                    index = Math.max(i, index);
                }
            }
        }

        if (res_length > 0) {
            for (i = index - res_length + 1; i <= index; i++) {
                res += str.charAt(i - 1);
            }
        }
        System.out.println(res);
    }
}
