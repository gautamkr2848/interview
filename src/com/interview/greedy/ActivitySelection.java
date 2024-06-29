package com.interview.greedy;

//sort all activities according to finish time

import java.util.Arrays;

public class ActivitySelection {

    public static void activitySelection(){
        int s[] =  {1, 3, 0, 5, 8, 5};
        int f[] =  {3, 4, 6, 7, 9, 9};

        Arrays.sort(f);

        int i=0;
        System.out.print(i+" ");

        for (int j = 1; j < s.length; j++){
            if (s[j] >= f[i]){
                System.out.print(j+" ");
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        activitySelection();
    }
}
