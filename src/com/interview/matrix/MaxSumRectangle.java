package com.interview.matrix;

/*
Kadane’s algorithm for 1D array can be used to reduce the time complexity to O(n^3). The idea is to fix the left and
right columns one by one and find the maximum sum contiguous rows for every left and right column pair. We basically
find top and bottom row numbers (which have maximum sum) for every fixed left and right column pair. To find the top
and bottom row numbers, calculate the sum of elements in every row from left to right and store these sums in an array
say temp[]. So temp[i] indicates sum of elements from left to right in row i. If we apply Kadane’s 1D algorithm on
temp[], and get the maximum sum subarray of temp, this maximum sum would be the maximum possible sum with left and
right as boundary columns. To get the overall maximum sum, we compare this sum with the maximum sum so far.
*/

public class MaxSumRectangle {

    public void maxSumRectangle(int[][] mat){

        int rows = mat.length;
        int columns = mat[0].length;
        int maxSum=0;

        for (int left = 0; left < columns; left++) {
            int temp[] = new int[rows];

            for (int right = left; right < columns; right++) {
                for (int i = 0; i < rows; i++)
                    temp[i] = temp[i] + mat[i][right];

                int sum = kadane(temp, rows);
                if (sum > maxSum)
                    maxSum = sum;
            }
        }
        System.out.println(maxSum);
    }

    private int kadane(int a[], int size){
        int max = a[0];
        int curr_max = a[0];

        for (int i = 1; i < size; i++) {
            curr_max = Math.max(a[i], curr_max + a[i]);
            max = Math.max(max, curr_max);
        }
        return max;
    }
}
