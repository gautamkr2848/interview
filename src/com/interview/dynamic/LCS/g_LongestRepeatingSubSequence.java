package com.interview.dynamic.LCS;

    /*same as Longest Common Subsequence
    if(a.charAt(i-1) == b.charAt(j-1) && i != j)
    Extra field - i != j */

/*Input: str = "abc"
Output: 0
There is no repeating subsequence

Input: str = "aab"
Output: 1
The two subsequence are 'a'(first) and 'a'(second).
Note that 'b' cannot be considered as part of subsequence
as it would be at same index in both.

Input: str = "aabb"
Output: 2

Input: str = "axxxy"
Output: 2*/

public class g_LongestRepeatingSubSequence {

    //String a = "axxxy", String b = "axxxy"

    public static void g_LongestRepeatingSubSequence(String a, String b){
        int m = a.length(), n = b.length();
        int t[][] = new int[m+1][n+1];

        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                if(a.charAt(i-1) == b.charAt(j-1) && i != j)
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }
        System.out.println(t[m][n]);
    }

    public static void main(String[] args) {
        g_LongestRepeatingSubSequence("aabebcdd", "aabebcdd");
    }
}
