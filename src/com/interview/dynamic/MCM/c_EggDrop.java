package com.interview.dynamic.MCM;

import java.util.Arrays;

public class c_EggDrop {

    public int eggDrop(int eggs, int floors){
        if (floors == 1 || floors == 0 || eggs == 1)
            return floors;

        int min = Integer.MAX_VALUE;
        for(int i=1; i <= floors; i++)
            min = Math.min(min, 1 + Math.max(eggDrop(eggs-1, i-1), eggDrop(eggs, floors-i)));

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
