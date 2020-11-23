package com.interview.matrix;

import java.util.ArrayList;
import java.util.List;

class Cell{
    int x,y;

    Cell(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BooleanMatrix {

    public void booleanMatrix(){
        int mat[][] = { {1, 0, 0, 1},
                        {0, 0, 1, 0},
                        {0, 0, 0, 0}};

        List<Cell> cellList = new ArrayList<>();

        for(int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                if(mat[i][j] == 1){
                    Cell c = new Cell(i, j);
                    cellList.add(c);
                }
            }
        }

        int[][] result = new int[3][4];
        for(Cell c : cellList){
            int row = c.x;
            int column = c.y;
            for(int i=0; i<3; i++){
                result[row][i] = 1;
                result[i][column] = 1;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(result[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
