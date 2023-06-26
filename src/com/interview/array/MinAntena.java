package com.interview.array;

import java.util.Arrays;

/*
Algorithm:-

1. First, sort all the elements.
2. Count only once and then traverse till its middle house.
3. After this again traverse till tower range.
4. Again repeat 1, 2, 3 steps till all the houses are covered.
*/

public class MinAntena {

    public void minAntena(){
        int house[] = { 7, 2, 4, 6, 5, 9, 12, 11 };
        int range = 2;
        int n = house.length;

        Arrays.sort(house);

        int count = 0;
        int i=0;

        while(i < n){
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
