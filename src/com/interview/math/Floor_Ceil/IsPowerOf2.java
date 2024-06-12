package com.interview.math.Floor_Ceil;

public class IsPowerOf2 {

    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;

        return (int)(Math.ceil((Math.log(n) / Math.log(2)))) == (int)(Math.floor((Math.log(n) / Math.log(2))));
    }
}
