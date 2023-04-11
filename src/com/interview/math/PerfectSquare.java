package com.interview.math;

public class PerfectSquare {

    public boolean isPerfectSquare(int x) {
        if (x >= 0) {
            int tmp = (int)Math.sqrt(x);
            return ((tmp * tmp) == x);
        }
        return false;
    }

    public boolean isPerfectSquare_3(int x) {
        if (x >= 0) {
            if(Math.floor((double) x) == Math.ceil((double) x))
                return true;
        }
        return false;
    }

    public boolean isPerfectSquare_2(int num) {
        long left = 1, right = num;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid * mid == num)
                return true;

            if (mid * mid < num)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
