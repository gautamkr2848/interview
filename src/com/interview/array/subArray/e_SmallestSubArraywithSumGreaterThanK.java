package com.interview.array.subArray;

public class e_SmallestSubArraywithSumGreaterThanK {

    public static void main(String[] args) {
        int arr[] = {1, 4, 45, 6, 0, 19};
        int x = 51, sum = 0, len = Integer.MAX_VALUE, j=0;

        for(int i=0; i< arr.length; i++) {
            sum = sum + arr[i];

            if(sum > x) {
                len = Math.min(len, i-j+1);

                while (sum > x) {
                    sum = sum - arr[j++];
                    if(sum > x)
                        len = Math.min(len, i-j+1);
                }
            }
        }
        System.out.println(len);
    }
}
