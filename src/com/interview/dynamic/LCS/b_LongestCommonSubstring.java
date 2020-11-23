package com.interview.dynamic.LCS;

/*          a   b   c   d   a   f
        0   0   0   0   0   0   0
   z    0   0   0   0   0   0   0
   b    0   0   1   0   0   0   0
   c    0   0   0   2   0   0   0
   d    0   0   0   0   3   0   0
   f    0   0   0   0   0   0   1

   length of longest common sub string = 3
 */

public class b_LongestCommonSubstring {

    public void lcs(String a, String b){
        int m = a.length(), n = b.length();
        int t[][] = new int[m+1][n+1];
        int length = 0, row = 0, column = 0;

        for (int i = 0; i <= n; i++)
            t[0][i] = 0;
        for (int i = 0; i <= m; i++)
            t[i][0] = 0;

        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                if(a.charAt(i-1) == b.charAt(j-1))
                    t[i][j] = t[i-1][j-1] +1;
                else
                    t[i][j] = 0;

                if(t[i][j] > length) {
                    length = t[i][j];
                    row = i;
                    column = j;
                }
            }
        }

        if (length == 0) {
            System.out.println("No Common Substring");
            return;
        }

        String resultStr = "";

        while (t[row][column] != 0) {
            resultStr = a.charAt(row - 1) + resultStr;
            row--;
            column--;
        }
        System.out.println(resultStr);
    }
}
