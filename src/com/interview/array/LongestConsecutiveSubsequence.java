package com.interview.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    public static int findLongestConseqSubseq(int arr[], int n) {
        Set<Integer> S = new HashSet<Integer>();
        int ans = 0;

        for (int i = 0; i < n; ++i)
            S.add(arr[i]);

        for (int i = 0; i < n; ++i) {
            if (!S.contains(arr[i] - 1)) {
                int j = arr[i];
                while (S.contains(j))
                    j++;

                if (ans < j - arr[i])
                    ans = j - arr[i];
            }
        }
        return ans;
    }

}
