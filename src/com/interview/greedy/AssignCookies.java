package com.interview.greedy;

import java.util.Arrays;

// greed [ ] = {1, 2, 3}
//sz [ ] = {1, 1}
//Output: 1

// greed [ ] = {1, 2}, j
//sz [ ] = {1, 2, 3}, i
//Output: 2

public class AssignCookies {

    static int maxChildren(int N,int M,int greed[], int sz[]) {
        Arrays.sort(sz);
        Arrays.sort(greed);

        int i=0, j=0;

        while(i<M && j<N) {
            if(sz[i] >= greed[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j;
    }

}
