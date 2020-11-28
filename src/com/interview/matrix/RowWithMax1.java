package com.interview.matrix;

//All the rows are sorted
//start from top right corner

public class RowWithMax1 {

    public void rowWithMax1(){
        int arr[][] = {{0, 0, 0, 1},
                       {0, 0, 0, 1},
                       {0, 0, 0, 0},
                       {0, 1, 1, 1}};

        int row = 0, i, j;
        for (i = 0, j = arr.length - 1; i < arr.length; i++) {
            while (j >= 0 && arr[i][j] == 1) {
                row = i;
                j--;
            }
        }
        System.out.print("Row number = " + (row + 1) + ", MaxCount = " + (arr.length - 1 - j));
    }
}
