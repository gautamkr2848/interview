package com.interview.matrix;

public class MatrixSearch {

    public void matrixSearch(){
        int mat[][] = {{ 10, 20, 30},
                        { 15, 25, 35 },
                        { 27, 29, 37}};
        int n = 3, x = 20;
        int i = 0, j = n - 1; // set indexes for top right

        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                System.out.print("n Found at " + i + " " + j);
                return;
            }
            if (mat[i][j] <= x)
                i++;
            else
                j--;
        }
        System.out.print("n Element not found");
    }

    boolean searchMatrix(int[][] matrix, int target) {

        int rowIdx = searchPotentialRow(matrix, target);
        if (rowIdx != -1)
            return binarySearchOverRow(rowIdx, matrix, target);
        return false;
    }

    private int searchPotentialRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        int idx = matrix[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;

            if (matrix[mid][0] <= target && target <= matrix[mid][idx]) {
                return mid;
            }
            else if (matrix[mid][0] < target) low = mid + 1;
            else if (matrix[mid][0] > target) high = mid - 1;
        }
        return -1;
    }

    private boolean binarySearchOverRow(int rowIdx, int[][] matrix, int target) {
        int low = 0;
        int high = matrix[rowIdx].length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;

            if (matrix[rowIdx][mid] == target) {
                return true;
            }
            else if (matrix[rowIdx][mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
