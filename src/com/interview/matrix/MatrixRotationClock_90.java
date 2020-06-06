package com.interview.matrix;

public class MatrixRotationClock_90 {

    public void matrixRotation_1(int[][] mat){
        int length = mat.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < length - i - 1; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[length - 1 - j][i];
                mat[length - 1 - j][i] = mat[length - 1 - i][length - 1 - j];
                mat[length - 1 - i][length - 1 - j] = mat[j][length - 1 - i];
                mat[j][length - 1 - i] = temp;
            }
        }
        displayMatrix(mat);
    }

    public void displayMatrix(int mat[][]) {
        int N = mat.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);
            System.out.print("\n");
        }
        System.out.print("\n");
    }

}
