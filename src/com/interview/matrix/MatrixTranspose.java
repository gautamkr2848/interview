package com.interview.matrix;

public class MatrixTranspose {

    public void matrixTranspose(int[][] mat) {
        int[][] temp = new int[mat.length][mat.length];
        for(int i=0; i<mat.length; i++)
            for(int j=0; j<mat.length; j++)
                temp[i][j] = mat[j][i];
        displayMatrix(temp);
    }

    public void displayMatrix(int mat[][]){
        int N = mat.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
