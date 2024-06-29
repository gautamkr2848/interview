package com.interview.array.subArray;

public class h_EvenSumSubArray {

    public int countEvenSum(int arr[], int n) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                if (sum % 2 == 0)
                    result++;
            }
        }
        return (result);
    }

    public long countEvenSum_2(int[] arr, int n) {
        long res = 0;

        int s = 0;
        for (int i = n - 1; i >= 0; i--){
            if (arr[i] % 2 == 1) {
                // s is the count of subarrays starting from
                // index i+1 whose sum was even
                /*if a[i] is odd then all subarrays starting
                from index i+1 which was odd becomeseven
                when a[i] gets added to it.*/
                s = n - i - 1 - s;
            } else {
                /*if a[i] is even then all subarrays
        starting from index i+1 which was even remain same
        and one extra a[i] even subarray gets added to it.*/
                s = s + 1;
            }
            res = res + s;
        }
        return res;
    }
}
