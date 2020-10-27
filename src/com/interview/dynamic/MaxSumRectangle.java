package com.interview.dynamic;

public class MaxSumRectangle {

    public void maxSumRectangle(){
        int mat[][] = new int[][] { { 1, 2, -1, -4, -20 },
                { -8, -3, 4, 2, 1 },
                { 3, 8, 10, 1, 3 },
                { -4, -1, 1, 7, -6 } };
        int rows = mat.length;
        int columns = mat[0].length;
        int maxSum=0;

        for (int left = 0; left < columns; left++) {
            int temp[] = new int[rows];

            for (int right = left; right < columns; right++) {
                for (int i = 0; i < rows; ++i)
                    temp[i] += mat[i][right];

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
