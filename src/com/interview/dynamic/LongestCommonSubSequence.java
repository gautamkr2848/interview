package com.interview.dynamic;

/*          a   b   c   d   a   f
        0   0   0   0   0   0   0
   a    0   1   1   1   1   1   1
   c    0   1   1   2   2   2   2
   b    0   1   2   2   2   2   2
   c    0   1   2   3   3   3   3
   f    0   1   2   3   3   3   4

   length of longest common sub sequence = 4
 */

public class LongestCommonSubSequence {

    public void lcs(String a, String b){

        int T[][] = new int[a.length()+1][b.length()+1];
        int max = 0;

        for(int i=1; i <= a.length(); i++){
            for(int j=1; j <= b.length(); j++){
                if(a.charAt(i-1) == b.charAt(j-1))
                    T[i][j] = T[i-1][j-1] +1;
                else
                    T[i][j] = Math.max(T[i-1][j], T[i][j-1]);

                if(max < T[i][j]){
                    max = T[i][j];
                }
            }
        }

        System.out.println("Longest Common Sub Sequence Length : " + max);
    }
}
