package com.interview.miscellaneous;

public class DayOfWeek {

    public void dayOfWeek(){
        int d = 27, m = 12, y = 1993;
        int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
        y -= (m < 3) ? 1 : 0;
        System.out.println (( y + y/4 - y/100 + y/400 + t[m-1] + d) % 7);
    }
}
