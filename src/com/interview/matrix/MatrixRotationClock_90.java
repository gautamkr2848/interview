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

    public void matrixRotation_2(int mat[][]){
        //reverse elements of all the rows
        //find the transpose of the matrix
    }

    public void antiClockWise(int mat[][]){
        int N = mat.length;
        for (int x = 0; x < N / 2; x++) {
            // Consider elements in group
            // of 4 in current square
            for (int y = x; y < N - x - 1; y++) {
                // Store current cell in
                // temp variable
                int temp = mat[x][y];

                // Move values from right to top
                mat[x][y] = mat[y][N - 1 - x];

                // Move values from bottom to right
                mat[y][N - 1 - x]
                        = mat[N - 1 - x][N - 1 - y];

                // Move values from left to bottom
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];

                // Assign temp to left
                mat[N - 1 - y][x] = temp;
            }
        }
    }

}
