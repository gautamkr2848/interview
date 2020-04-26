package com.interview;

import com.interview.dynamic.LongestCommonSubSequence;
import com.interview.dynamic.LongestCommonSubstring;
import com.interview.recursion.Knapsack_0_1;

import java.lang.*;

public class Main {

    public static void main(String[] args) {

        Knapsack_0_1 l = new Knapsack_0_1();
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(l.knapSack(W, wt, val, n));
    }
}
