package com.interview.dynamic.one_dim_dp;

public class StairJump {

    public int stairCase(int n) {
        if(n <= 1)
            return 1;
        return stairCase(n-1) + stairCase(n-2);
    }
}
