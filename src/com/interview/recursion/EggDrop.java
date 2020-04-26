package com.interview.recursion;

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

}
