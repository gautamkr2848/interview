package com.interview.dynamic.MCM;

import java.util.Arrays;

//Boolean Parenthesization
//Find no. of ways to make the expression true by passing ()
//T ^ F | F
public class c_EvaluateExpToTrue {

    public void noOfWaysToEvaluateExpToTrue(char[] symbol, char[] operator, int n){

        int[][] F = new int[n][n];
        int[][] T = new int[n][n];

        for(int i=0; i<n; i++){
            F[i][i] = (symbol[i] == 'F') ? 1 : 0;
            T[i][i] = (symbol[i] == 'T') ? 1 : 0;
        }

        for (int gap = 1; gap < n; ++gap) {
            for (int i = 0, j = gap; j < n; ++i, ++j) {
                T[i][j] = F[i][j] = 0;
                for (int g = 0; g < gap; g++) {
                    // Find place of parenthesization using current value of gap
                    int k = i + g;

                    // Store Total[i][k] and Total[k+1][j]
                    int tik = T[i][k] + F[i][k];
                    int tkj = T[k + 1][j] + F[k + 1][j];

                    // Follow the recursive formulas according to the current operator
                    if (operator[k] == '&') {
                        T[i][j] += T[i][k] * T[k + 1][j];
                        F[i][j] += (tik * tkj - T[i][k] * T[k + 1][j]);
                    }
                    if (operator[k] == '|') {
                        F[i][j] += F[i][k] * F[k + 1][j];
                        T[i][j] += (tik * tkj - F[i][k] * F[k + 1][j]);
                    }
                    if (operator[k] == '^') {
                        T[i][j] += F[i][k] * T[k + 1][j] + T[i][k] * F[k + 1][j];
                        F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j];
                    }
                }
            }
        }
        System.out.println(T[0][n - 1]);
    }

    public void noOfWaysToEvaluateExpToTrue_2(int n, String s){
        int dp[][][] = new int[n + 1][n + 1][2];

        for (int row[][] : dp)
            for (int col[] : row)
                Arrays.fill(col, -1);

        System.out.println(parenthesis_count(s, 0, n - 1, 1, dp));
    }

    private int parenthesis_count(String str, int i, int j, int isTrue, int[][][] dp) {
        if (i > j)
            return 0;

        if (i == j) {
            if (isTrue == 1)
                return (str.charAt(i) == 'T') ? 1 : 0;
            else
                return (str.charAt(i) == 'F') ? 1 : 0;
        }

        if (dp[i][j][isTrue] != -1)
            return dp[i][j][isTrue];

        int temp_ans = 0;

        int leftTrue, rightTrue, leftFalse, rightFalse;

        for (int k = i + 1; k <= j - 1; k = k + 2) {

            if (dp[i][k - 1][1] != -1)
                leftTrue = dp[i][k - 1][1];
            else            // Count number of True in left Partition
                leftTrue = parenthesis_count(str, i, k - 1, 1, dp);

            if (dp[i][k - 1][0] != -1)
                leftFalse = dp[i][k - 1][0];
            else        // Count number of False in left Partition
                leftFalse = parenthesis_count(str, i, k - 1, 0, dp);

            if (dp[k + 1][j][1] != -1)
                rightTrue = dp[k + 1][j][1];
            else        // Count number of True in right Partition
                rightTrue = parenthesis_count(str, k + 1, j, 1, dp);

            if (dp[k + 1][j][0] != -1)
                rightFalse = dp[k + 1][j][0];
            else    // Count number of False in right Partition
                rightFalse = parenthesis_count(str, k + 1, j, 0, dp);


            if (str.charAt(k) == '&') {     // Evaluate AND operation
                if (isTrue == 1)
                    temp_ans = temp_ans + leftTrue * rightTrue;
                else
                    temp_ans = temp_ans + leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
            } else if (str.charAt(k) == '|') {      // Evaluate OR operation
                if (isTrue == 1)
                    temp_ans = temp_ans + leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                else
                    temp_ans = temp_ans + leftFalse * rightFalse;
            } else if (str.charAt(k) == '^') {      // Evaluate XOR operation
                if (isTrue == 1)
                    temp_ans = temp_ans + leftTrue * rightFalse + leftFalse * rightTrue;
                else
                    temp_ans = temp_ans + leftTrue * rightTrue + leftFalse * rightFalse;

            }
            dp[i][j][isTrue] = temp_ans;
        }
        return temp_ans;
    }
}
