package com.interview.matrix;

public class MatrixRotation_180 {

    public void matrixRotation(int[][] mat){
        for(int i=mat.length-1; i>=0; i--) {
            for (int j = mat.length - 1; j >= 0; j--) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
