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

/*
Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
Output : 5
Explanation:
The longest common substring is “Geeks” and is of length 5.

Input : X = “abcdxyz”, y = “xyzabcd”
Output : 4
Explanation:
The longest common substring is “abcd” and is of length 4.
*/

public class b_LongestCommonSubstring {

    public void lcs(String a, String b){
        int m = a.length(), n = b.length();
        int t[][] = new int[m+1][n+1];
        int length = 0, end = m;

        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                    if(t[i][j] > length) {
                        length = t[i][j];
                        end = i;
                    }
                } else
                    t[i][j] = 0;
            }
        }
        System.out.println(a.substring(end - length, end));
    }
}
