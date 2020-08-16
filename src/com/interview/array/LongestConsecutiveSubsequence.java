package com.interview.array;

import java.util.Arrays;

//Sort the array and find immediate element having a[i]+1 = a[i+1]

public class LongestConsecutiveSubsequence {

    public void longestConsecutiveSubsequence(){
        int[] a = {3, 2, 5, 11, 6, 0};
        int n = a.length;
        Arrays.sort(a);
        int count = 1;
        int result = 0;

        for(int i=0; i < n-1; i++){
            if(a[i] + 1 == a[i+1]) {
                count++;
                if(count > result)
                    result = count;
            } else {
                count = 1;
            }
        }
        System.out.println(result);
    }

}
