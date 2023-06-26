package com.interview.dynamic.knapsack;

/*
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and
then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the
expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

1   1   2   3
add + or - before the number
Get o/p = 1

s1 - s2 = 1 Given

Give count of total combinations

+1  -1  -2  +3  = 1
+1  +1  +2  -3  = 1
-1  +1  -2  +3  = 1

total count = 3
*/

public class g_TargetSum {
    //same as f_SubsetSumDiffCount
    //replace diff as sum given
}
