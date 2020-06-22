package com.interview.matrix;

public class MatrixSearch {

    public void matrixSearch(){
        int mat[][] = { { 10, 20, 30}, { 15, 25, 35 }, { 27, 29, 37}};
        int n = 3, x = 25;
        int i = 0, j = n - 1; // set indexes for top right

        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                System.out.print("n Found at " + i + " " + j);
                return;
            }
            if (mat[i][j] > x)
                j--;
            else
                i++;
        }
        System.out.print("n Element not found");
    }
}
