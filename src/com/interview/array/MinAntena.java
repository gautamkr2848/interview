package com.interview.array;

import java.util.Arrays;

public class MinAntena {

    public void minAntena(){
        int house[] = { 7, 2, 4, 6, 5, 9, 12, 11 };
        int range = 2;
        int n = house.length;

        Arrays.sort(house);

        int count = 0;
        int i=0;

        while(i<n){
            count++;

            int tmp = house[i] + range;
            while (i<n && house[i] <= tmp)
                i++;
            i--;
            tmp = house[i] + range;
            while (i<n && house[i] <= tmp)
                i++;
        }
        System.out.println(count);
    }
}
