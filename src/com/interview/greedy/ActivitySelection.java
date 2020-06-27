package com.interview.greedy;

public class ActivitySelection {

    public void activitySelection(){
        int s[] =  {1, 3, 0, 5, 8, 5};
        int f[] =  {2, 4, 6, 7, 9, 9};

        int i=0;
        System.out.print(i+" ");

        // Consider rest of the activities
        for (int j = 1; j < s.length; j++){
            // If this activity has start time greater than or equal to the finish time
            // of previously selected activity, then select it
            if (s[j] >= f[i]){
                System.out.print(j+" ");
                i = j;
            }
        }
    }
}
