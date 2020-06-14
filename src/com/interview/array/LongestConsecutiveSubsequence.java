package com.interview.array;

import java.util.Arrays;

/*We can also project the arrays to a new array with length to be the largest element in the array.
Then iterate over the array and get the longest consecutive sequence. If the largest number is very large,
then the time complexity would be bad.*/

public class LongestConsecutiveSubsequence {

    public void longestConsecutiveSubsequence(int[] a){
        int n = a.length;
        Arrays.sort(a);
        int count = 1;
        int result = 0;

        for(int i=0; i < n-1; i++){
            if(a[i] + 1 == a[i+1]) {
                count++;
                result = count;
            } else {
                count = 1;
            }
        }
        System.out.println(result);
    }

}
