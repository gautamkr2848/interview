package com.interview.math.Floor_Ceil;

public class PerfectSquare {

    public boolean isPerfectSquare(int x) {
        if (x >= 0) {
            int tmp = (int)Math.sqrt(x);
            return ((tmp * tmp) == x);
        }
        return false;
    }

    public void checkperfectsquare(int n) {
        if (Math.ceil((double)Math.sqrt(n)) == Math.floor((double)Math.sqrt(n)))
            System.out.print("perfect square");
        else
            System.out.print("not a perfect square");
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
