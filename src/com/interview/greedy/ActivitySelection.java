package com.interview.greedy;

//sort all activities according to finish time

public class ActivitySelection {

    public void activitySelection(){
        int s[] =  {1, 3, 0, 5, 8, 5};
        int f[] =  {3, 4, 6, 7, 9, 9};

        int i=0;
        System.out.print(i+" ");

        for (int j = 1; j < s.length; j++){
            if (s[j] >= f[i]){
                System.out.print(j+" ");
                i = j;
            }
        }
    }
}
