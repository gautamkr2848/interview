package com.interview.recursion;

/*
When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.
    1. If the egg breaks after dropping from ‘xth’ floor, then we only need to check for floors lower than ‘x’
       with remaining eggs as some floor should exist lower than ‘x’ in which egg would not break; so the problem
       reduces to x-1 floors and n-1 eggs.
    2. If the egg doesn’t break after dropping from the ‘xth’ floor, then we only need to check for floors higher
       than ‘x’; so the problem reduces to ‘k-x’ floors and n eggs.
*/

import java.util.Arrays;

public class EggDrop {

    public int eggDrop(int eggs, int floors){
        if (floors == 1 || floors == 0 || eggs == 1)
            return floors;

        int min = Integer.MAX_VALUE;
        for(int i=1; i <= floors; i++){
            int val = 1 + Math.max(eggDrop(eggs-1, i-1),eggDrop(eggs, floors-i));
            if(val < min){
                min = val;
            }
        }
        return min;
    }

    public int eggDrop_2(int eggs, int floors){
        if (floors == 1 || floors == 0 || eggs == 1)
            return floors;

        int[][] t = new int[eggs+1][floors+1];
        for(int i=0; i<eggs; i++)
            Arrays.fill(t[i], -1);

        if(t[eggs][floors] != -1)
            return t[eggs][floors];

        int min = Integer.MAX_VALUE;
        for(int i=1; i <= floors; i++){
            int val = 1 + Math.max(eggDrop(eggs-1, i-1),eggDrop(eggs, floors-i));
            if(val < min){
                min = val;
            }
        }
        t[eggs][floors] = min;
        return min;
    }

}
