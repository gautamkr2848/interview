package com.interview.dynamic;

/*          a   b   c   d   a   f
        0   0   0   0   0   0   0
   z    0   0   0   0   0   0   0
   b    0   0   1   0   0   0   0
   c    0   0   0   2   0   0   0
   d    0   0   0   0   3   0   0
   f    0   0   0   0   0   0   1

   length of longest common sub string = 3
 */

public class LongestCommonSubstring {

    public void lcs(String a, String b){

        int T[][] = new int[a.length()+1][b.length()+1];
        int max = 0;

        for(int i=1; i <= a.length(); i++){
            for(int j=1; j <= b.length(); j++){
                if(a.charAt(i-1) == b.charAt(j-1))
                    T[i][j] = T[i-1][j-1] +1;
                else
                    T[i][j] =0;

                if(max < T[i][j]){
                    max = T[i][j];
                }
            }
        }

        System.out.println("Longest Common Substring Length : " + max);
    }
}
