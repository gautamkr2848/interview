package com.interview.greedy;

/*
Given an array of size n that has the following specifications:

Each element in the array contains either a policeman or a thief.
Each policeman can catch only one thief.
A policeman cannot catch a thief who is more than K units away from the policeman.

Input : arr[] = {'T', 'T', 'P', 'P', 'T', 'P'},
            k = 2.
Output : 3.

Input : arr[] = {'P', 'T', 'P', 'T', 'T', 'P'},
            k = 3.
Output : 3.
 */

import java.util.ArrayList;
import java.util.List;

public class PoliceThief {

    public int policeThief(char arr[], int n, int k) {
        int res = 0;
        List<Integer> thief = new ArrayList<>();
        List<Integer> police = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P')
                police.add(i);
            else if (arr[i] == 'T')
                thief.add(i);
        }

        int l = 0, r = 0;
        while (l < thief.size() && r < police.size()) {

            if (Math.abs(thief.get(l) - police.get(r)) <= k) {
                l++;
                r++;
                res++;
            } else if (thief.get(l) < police.get(r))
                l++;
            else
                r++;
        }
        return res;
    }
}
