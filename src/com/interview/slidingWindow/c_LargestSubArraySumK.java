package com.interview.slidingWindow;

public class c_LargestSubArraySumK {

    public void largestSumSubArraySumK(){
        int[] arr = {4, 1, 1, 1, 2, 3, 5};
        int sum = 0;
        int k = 5;
        int count = 0, i=0, j=0;
        while (j < arr.length){
            sum = sum + arr[j];
            if(sum < k) {
                j++;
            } else if(sum == k) {
                count = Math.max(count, j-i+1);
                j++;
            }
            boolean flag = true;
            while (sum > k){
                sum = sum - arr[i];
                i++;
                if(flag){
                    if(sum == k)
                        count = Math.max(count, j-i+1);
                    j++;
                    flag = false;
                }
            }
        }
        System.out.print(count);
    }
}
