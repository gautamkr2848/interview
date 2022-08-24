package com.interview.dynamic.MCM;

import java.util.Arrays;

/*
m1 2 * 3, m2 3 * 6  cost => 2 * 3 * 6
m1 2 * 3, m2 3 * 6, m3 6 * 9
    1. (m1 * m2) * m3
    2. m1 * (m2 * m3)
    cost to be min
*/

public class a_MatrixChainMultiplication {

    public int MCM(int[] arr, int i, int j){
        //value of i always should be = 1 & j = n - 1
        if(i >= j)
            return 0;

        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int temp = MCM(arr, i, k) + MCM(arr, k+1, j) + arr[i-1] * arr[k] * arr[j];
            if(temp <   min)
                min = temp;
        }
        return min;
    }

    static int[][] t = new int[1001][1001];
    public a_MatrixChainMultiplication(){
        for(int i=0; i<t.length; i++)
            Arrays.fill(t[i], -1);
    }

    public int MCM_memorization(int[] arr, int i, int j){
        if(i >= j)
            return 0;

        if(t[i][j] != -1)
            return t[i][j];

        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int temp = MCM_memorization(arr, i, k) + MCM_memorization(arr, k+1, j) + arr[i-1] * arr[k] * arr[j];
            if(temp < min)
                min = temp;
        }
        t[i][j] = min;
        return min;
    }
}
