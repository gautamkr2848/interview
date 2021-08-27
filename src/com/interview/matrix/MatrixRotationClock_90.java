package com.interview.matrix;

public class MatrixRotationClock_90 {

    public void matrixRotation_2(int matrix[][]){
        //reverse elements of all the rows
        //find the transpose of the matrix

        int n = matrix.length;

        for(int i=0; i<n; i++)
            arrayReverse(matrix[i]);

        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
    }

    private void arrayReverse(int[] a){
        int start = 0;
        int end = a.length-1;
        while(start < end){
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            start++;
            end--;
        }
    }
}
